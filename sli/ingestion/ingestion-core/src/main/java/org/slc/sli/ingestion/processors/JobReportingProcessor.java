package org.slc.sli.ingestion.processors;

import java.util.Enumeration;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slc.sli.ingestion.BatchJob;
import org.slc.sli.ingestion.BatchJobLogger;
import org.slc.sli.ingestion.BatchJobStageType;
import org.slc.sli.ingestion.BatchJobStatusType;
import org.slc.sli.ingestion.Fault;
import org.slc.sli.ingestion.FaultsReport;
import org.slc.sli.ingestion.landingzone.IngestionFileEntry;
import org.slc.sli.ingestion.landingzone.LandingZone;
import org.slc.sli.ingestion.model.Metrics;
import org.slc.sli.ingestion.model.NewBatchJob;
import org.slc.sli.ingestion.model.ResourceEntry;
import org.slc.sli.ingestion.model.Stage;
import org.slc.sli.ingestion.model.da.BatchJobDAO;
import org.slc.sli.ingestion.model.da.BatchJobMongoDA;
import org.slc.sli.ingestion.queues.MessageType;

/**
 * Transforms body from ControlFile to ControlFileDescriptor type.
 *
 * @author bsuzuki
 *
 */
public class JobReportingProcessor implements Processor {

    // Logging
    private static final Logger LOG = LoggerFactory.getLogger(JobReportingProcessor.class);

    private LandingZone landingZone;

    public JobReportingProcessor(LandingZone lz) {
        this.landingZone = lz;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        BatchJob job = exchange.getIn().getBody(BatchJob.class); // existing impl

        Logger jobLogger = BatchJobLogger.createLoggerForJob(job.getId(), landingZone);  // existing impl

        // add output as lines
        jobLogger.info("jobId: " + job.getId());   // existing impl

        for (IngestionFileEntry fileEntry : job.getFiles()) {
            String id = "[file] " + fileEntry.getFileName();
            jobLogger.info(id + " (" + fileEntry.getFileFormat()
                    + "/" + fileEntry.getFileType() + ")");
            Long numProcessed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.processed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records considered: "
                    + numProcessed);
            }

            Long numPassed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.passed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records ingested successfully: "
                    + numPassed);
            }

            Long numFailed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.failed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records failed: "
                    + numFailed);
            }
        }

        // existing impl to write out properties
        Enumeration<?> names = job.propertyNames();
        while (names.hasMoreElements()) {
            String key = (String) names.nextElement();
            jobLogger.info("[configProperty] " + key + ": "
                    + job.getProperty(key));
        }

        FaultsReport fr = job.getFaultsReport();

        // TODO BatchJobUtils these errors need to be pulled from the db, write the DA interface to get the faults
        for (Fault fault : fr.getFaults()) {
            if (fault.isError()) {
                jobLogger.error(fault.getMessage());
            } else {
                jobLogger.warn(fault.getMessage());
            }
        }

        if (fr.hasErrors()) {
            jobLogger.info("Not all records were processed completely due to errors.");
        } else {
            jobLogger.info("All records processed successfully.");
        }

        // This header is set in PersistenceProcessor
        // TODO get this from the persistence processor
        if (exchange.getProperty("records.processed") != null) {
            jobLogger.info("Processed " + exchange.getProperty("records.processed") + " records.");
        }

        // clean up after ourselves
        ((ch.qos.logback.classic.Logger) jobLogger).detachAndStopAllAppenders();
        
        // TODO do new batch job processing in parallel
//        processUsingNewBatchJob(exchange);
        
    }

    
    private void processUsingNewBatchJob(Exchange exchange) throws Exception {
        
        // get job from the batch job db
        String batchJobId = exchange.getIn().getHeader("BatchJobId", String.class);
        if (batchJobId == null) {
            exchange.getIn().setHeader("ErrorMessage", "No BatchJobId specified in exchange header.");
            exchange.getIn().setHeader("IngestionMessageType", MessageType.ERROR.name());
            LOG.error("Error:", "No BatchJobId specified in " + this.getClass().getName() + " exchange message header.");
        }
        BatchJobDAO batchJobDAO = new BatchJobMongoDA();
        NewBatchJob job = batchJobDAO.findBatchJobById(batchJobId);

        Stage stage = new Stage();
        stage.setStageName(BatchJobStageType.JOB_REPORTING_PROCESSING.getName());
        stage.startStage();

        Logger jobLogger;
        jobLogger = BatchJobLogger.createLoggerForJob(job.getId(), landingZone);
        jobLogger.info("jobId: " + job.getId());

        // based on the PersistenceProcessor counts
        int totalProcessed = 0;
        int totalErrors = 0;
        
        // new batch job impl writes out persistence stage resource metrics
        for (ResourceEntry resourceEntry : job.getResourceEntries()) {
            String id = "[file] " + resourceEntry.getResourceName();
            jobLogger.info(id + " (" + resourceEntry.getResourceFormat()
                    + "/" + resourceEntry.getResourceType() + ")");
            
            Metrics metric = getStageMetric(job, BatchJobStageType.PERSISTENCE_PROCESSING, 
                    resourceEntry.getResourceId());
            if (metric != null) {
                int numProcessed = metric.getRecordCount();
                int numFailed = metric.getErrorCount();
                int numPassed = metric.getRecordCount() - numFailed;
                
                jobLogger.info(id + " records considered: " + numProcessed);
                jobLogger.info(id + " records ingested successfully: " + numPassed);
                jobLogger.info(id + " records failed: " + numFailed);
                
                totalProcessed += numProcessed;
                totalErrors += numFailed;
            }
        }
        
        // write properties
        for (Map.Entry<String, String> entry : job.getBatchProperties().entrySet()) {
            jobLogger.info("[configProperty] " + entry.getKey() + ": " + entry.getValue());            
        }

//        FaultsReport fr = job.getFaultsReport();
//
//        // TODO BatchJobUtils these errors need to be pulled from the db, write the DA interface to get the faults
//        for (Fault fault : fr.getFaults()) {
//            if (fault.isError()) {
//                jobLogger.error(fault.getMessage());
//            } else {
//                jobLogger.warn(fault.getMessage());
//            }
//        }
//
//        if (fr.hasErrors()) {
//            jobLogger.info("Not all records were processed completely due to errors.");
//            newJob.setStatus(BatchJobStatusType.COMPLETED_SUCCESSFULLY.getName());
//        } else {
//            jobLogger.info("All records processed successfully.");
//            newJob.setStatus(BatchJobStatusType.COMPLETED_SUCCESSFULLY.getName());
//        }
//
//        // This header is set in PersistenceProcessor
//        // TODO get this from the persistence processor
//        if (exchange.getProperty("records.processed") != null) {
//            jobLogger.info("Processed " + exchange.getProperty("records.processed") + " records.");
//        }

        if (totalErrors == 0) {
            jobLogger.info("Not all records were processed completely due to errors.");
            job.setStatus(BatchJobStatusType.COMPLETED_WITH_ERRORS.getName());            
        } else {
            jobLogger.info("All records processed successfully.");
            job.setStatus(BatchJobStatusType.COMPLETED_SUCCESSFULLY.getName());            
        }
        
        // clean up after ourselves
        ((ch.qos.logback.classic.Logger) jobLogger).detachAndStopAllAppenders();

        stage.stopStage();
        job.getStages().add(stage);
        batchJobDAO.saveBatchJob(job);
   }

    private Metrics getStageMetric(NewBatchJob job, BatchJobStageType stageType, String resourceId) {
        for (Stage stage : job.getStages()) {
            if (stage.getStageName() == stageType.getName()) {
                for (Metrics metric : stage.getMetrics()) {
                    if (metric.getResourceId() == resourceId) {
                        return metric;
                    }
                }
            }
        }
        
        return null;
    }

}
