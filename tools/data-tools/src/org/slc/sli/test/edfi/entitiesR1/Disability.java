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
 * This type represents an impairment of body
 * 				structure or function, a
 * 				limitation in activities, or a restriction
 * 				in participation, as ordered by
 * 				severity
 * 				of impairment.
 * 			
 * 
 * <p>Java class for disability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="disability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disability" type="{http://slc-sli/ed-org/0.1}descriptorReferenceType"/>
 *         &lt;element name="disabilityDiagnosis" type="{http://slc-sli/ed-org/0.1}disabilityDiagnosis" minOccurs="0"/>
 *         &lt;element name="orderOfDisability" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disability", propOrder = {
    "disability",
    "disabilityDiagnosis",
    "orderOfDisability"
})
public class Disability {

    @XmlElement(required = true)
    protected DescriptorReferenceType disability;
    protected String disabilityDiagnosis;
    protected Integer orderOfDisability;

    /**
     * Gets the value of the disability property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptorReferenceType }
     *     
     */
    public DescriptorReferenceType getDisability() {
        return disability;
    }

    /**
     * Sets the value of the disability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptorReferenceType }
     *     
     */
    public void setDisability(DescriptorReferenceType value) {
        this.disability = value;
    }

    /**
     * Gets the value of the disabilityDiagnosis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisabilityDiagnosis() {
        return disabilityDiagnosis;
    }

    /**
     * Sets the value of the disabilityDiagnosis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisabilityDiagnosis(String value) {
        this.disabilityDiagnosis = value;
    }

    /**
     * Gets the value of the orderOfDisability property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderOfDisability() {
        return orderOfDisability;
    }

    /**
     * Sets the value of the orderOfDisability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderOfDisability(Integer value) {
        this.orderOfDisability = value;
    }

}
