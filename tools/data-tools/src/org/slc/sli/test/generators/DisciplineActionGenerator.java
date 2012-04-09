package org.slc.sli.test.generators;

import java.math.BigInteger;
import java.util.Random;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.slc.sli.test.edfi.entities.DisciplineAction;
import org.slc.sli.test.edfi.entities.DisciplineDescriptorType;
import org.slc.sli.test.edfi.entities.DisciplineIncidentIdentityType;
import org.slc.sli.test.edfi.entities.DisciplineIncidentReferenceType;
import org.slc.sli.test.edfi.entities.EducationalOrgIdentityType;
import org.slc.sli.test.edfi.entities.EducationalOrgReferenceType;
import org.slc.sli.test.edfi.entities.ObjectFactory;
import org.slc.sli.test.edfi.entities.StudentIdentityType;
import org.slc.sli.test.edfi.entities.StudentReferenceType;

/**
* Generates DisciplineIncident data
* 
* @author slee
*
*/
public class DisciplineActionGenerator {
    private static final Logger log = Logger.getLogger(DisciplineActionGenerator.class);

    static Random rand = new Random();
    private static String date = "2011-03-04";

    
    /**
     * Generates a DisciplineAction for a disciplineActionId
     * with a responsibilitySchoolId and a assignmentSchoolId as a references.
     *
     * @param disciplineActionId
     * @param responsibilitySchoolId
     * @param assignmentSchoolId
     * 
     * @return <code>DisciplineAction</code>
     */
    public static DisciplineAction generateLowFi(String disciplineActionId, 
                                                 String disciplineIncidentId, 
                                                 String studentId, 
                                                 String responsibilitySchoolId,
                                                 String assignmentSchoolId) {
        DisciplineAction action = generateLowFi(disciplineActionId, disciplineIncidentId, studentId, responsibilitySchoolId);
        
        EducationalOrgIdentityType edOrgIdentity = new EducationalOrgIdentityType();
        edOrgIdentity.getStateOrganizationIdOrEducationOrgIdentificationCode().add(assignmentSchoolId);
        EducationalOrgReferenceType schoolRef = new EducationalOrgReferenceType();
        schoolRef.setEducationalOrgIdentity(edOrgIdentity);
        action.setAssignmentSchoolReference(schoolRef);
        
        return action;
    }
    
    /**
     * Generates a DisciplineAction between a cohort and a student 
     * with a school as a reference.
     *
     * @param cohortId
     * @param studentId
     * @param schoolId
     * 
     * @return <code>DisciplineAction</code>
     */
    public static DisciplineAction generateLowFi(String disciplineActionId, 
                                                 String disciplineIncidentId, 
                                                 String studentId, 
                                                 String responsibilitySchoolId) {
        DisciplineAction action = basicLowFiFactory(disciplineActionId, responsibilitySchoolId);
        
        // construct and add the disciplineIncident reference
        DisciplineIncidentReferenceType dirt = new DisciplineIncidentReferenceType();
        DisciplineIncidentIdentityType diit = new DisciplineIncidentIdentityType();
        diit.setIncidentIdentifier(disciplineIncidentId);
        dirt.setDisciplineIncidentIdentity(diit);
        action.getDisciplineIncidentReference().add(dirt);

        // construct and add the student reference
        StudentIdentityType sit = new StudentIdentityType();
        sit.setStudentUniqueStateId(studentId);
        StudentReferenceType srt = new StudentReferenceType();
        srt.setStudentIdentity(sit);
        action.getStudentReference().add(srt);
        
        return action;
    }
    
    /**
     * Generates a DisciplineAction for a disciplineActionId
     * with a responsibilitySchoolId as a reference.
     *
     * @param disciplineActionId
     * @param responsibilitySchoolId
     * 
     * @return <code>DisciplineAction</code>
     */
    private static DisciplineAction basicLowFiFactory(String disciplineActionId, String responsibilitySchoolId) {

        DisciplineAction action = new DisciplineAction();
        
        action.setDisciplineActionIdentifier(disciplineActionId);
        //set incident date and time
        action.setDisciplineDate(date);
        action.setDisciplineActionLength(BigInteger.valueOf(rand.nextInt(100)));
        action.setActualDisciplineActionLength(BigInteger.valueOf(rand.nextInt(100)));        
        action.setDisciplineActionLengthDifferenceReason(GeneratorUtils.generateDisciplineActionLengthDifferenceReasonType());
                
        // construct and add the school references
        EducationalOrgIdentityType edOrgIdentity = new EducationalOrgIdentityType();
        edOrgIdentity.getStateOrganizationIdOrEducationOrgIdentificationCode().add(responsibilitySchoolId);
        EducationalOrgReferenceType schoolRef = new EducationalOrgReferenceType();
        schoolRef.setEducationalOrgIdentity(edOrgIdentity);
        action.setResponsibilitySchoolReference(schoolRef);
        
        //add Behaviors
        ObjectFactory factory = new ObjectFactory();
        double prob = 1.0D / DisciplineDescriptor.values().length;
        for(DisciplineDescriptor behaviorDescriptor : DisciplineDescriptor.values()) {
            if (rand.nextDouble() < prob) {
                DisciplineDescriptorType disciplineDescriptorType = new DisciplineDescriptorType();
                JAXBElement<String> disciplineDescriptorCode =  factory.createDisciplineDescriptorTypeCodeValue(behaviorDescriptor.codeValue);
                JAXBElement<String> disciplineDescriptorShortDescription =  factory.createDisciplineDescriptorTypeShortDescription(behaviorDescriptor.shortDescription);
                JAXBElement<String> disciplineDescriptorDescription =  factory.createDisciplineDescriptorTypeDescription(behaviorDescriptor.description);
                disciplineDescriptorType.getCodeValueOrShortDescriptionOrDescription().add(disciplineDescriptorCode);
                disciplineDescriptorType.getCodeValueOrShortDescriptionOrDescription().add(disciplineDescriptorShortDescription);
                disciplineDescriptorType.getCodeValueOrShortDescriptionOrDescription().add(disciplineDescriptorDescription);
                action.getDisciplines().add(disciplineDescriptorType);
            }
        }
        
        return action;
    }

    // DisciplineDescriptor for DisciplineAction. 
    public enum DisciplineDescriptor {
        REMOVAL("DISCIPLINE 001", "Discipline 001 description", "Removal from a class room description"),
        SUSPENSION("DISCIPLINE 002", "Discipline 002 description", "Suspension from school description"),
        EXPULSION("DISCIPLINE 003", "Discipline 003 description", "Expulsion description"),
        TRANSFER("DISCIPLINE 004", "Discipline 004 description", "Transfer to other school description");
        
        String codeValue;
        String shortDescription;
        String description;
        
        DisciplineDescriptor (String cv, String sd, String d) {
            codeValue = cv;
            shortDescription = sd;
            description = d;
        }
        public String getCodeValue() { return codeValue; }
        public String getShortDescription() { return shortDescription; }
        public String getDescription() { return description; }
    }

    public DisciplineAction generate(String disciplineId, String delimiter) {
        DisciplineAction disciplineAction = new DisciplineAction();

        try {
            Random random = new Random();
            
            String studentId = disciplineId.split(delimiter)[0];
            String schoolId = disciplineId.split(delimiter)[1];
            String discId = disciplineId.split(delimiter)[2];
            
            disciplineAction.setDisciplineActionIdentifier(discId);
                        
            ObjectFactory fact = new ObjectFactory();
            DisciplineDescriptorType ddType = fact.createDisciplineDescriptorType();
            JAXBElement<String> str = fact.createDisciplineDescriptorTypeDescription("Suspension");
            ddType.getCodeValueOrShortDescriptionOrDescription().add(str);
            disciplineAction.getDisciplines().add(ddType);
            
            disciplineAction.setDisciplineDate("2012-04-15");
            
            StudentReferenceType srt = StudentGenerator.getStudentReferenceType(studentId);
            disciplineAction.getStudentReference().add(srt);
            
            DisciplineIncidentReferenceType dirt = DisciplineGenerator.getDisciplineIncidentReferenceType(discId, "ThisStateID");
            disciplineAction.getDisciplineIncidentReference().add(dirt);
            
            EducationalOrgReferenceType eor = SchoolGenerator.getEducationalOrgReferenceType(schoolId);
            disciplineAction.setResponsibilitySchoolReference(eor);
              
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return disciplineAction;
    }
}
