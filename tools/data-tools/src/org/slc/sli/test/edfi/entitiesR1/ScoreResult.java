//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.31 at 10:43:34 AM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A meaningful raw score or statistical expression of
 * 				the performance of an individual. The results can be expressed as a
 * 				number, percentile, range, level, etc.
 * 			
 * 
 * <p>Java class for scoreResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="scoreResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://slc-sli/ed-org/0.1}result"/>
 *         &lt;element name="assessmentReportingMethod" type="{http://slc-sli/ed-org/0.1}assessmentReportingMethodType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scoreResult", propOrder = {
    "result",
    "assessmentReportingMethod"
})
public class ScoreResult {

    @XmlElement(required = true)
    protected String result;
    @XmlElement(required = true)
    protected AssessmentReportingMethodType assessmentReportingMethod;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * Gets the value of the assessmentReportingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link AssessmentReportingMethodType }
     *     
     */
    public AssessmentReportingMethodType getAssessmentReportingMethod() {
        return assessmentReportingMethod;
    }

    /**
     * Sets the value of the assessmentReportingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessmentReportingMethodType }
     *     
     */
    public void setAssessmentReportingMethod(AssessmentReportingMethodType value) {
        this.assessmentReportingMethod = value;
    }

}
