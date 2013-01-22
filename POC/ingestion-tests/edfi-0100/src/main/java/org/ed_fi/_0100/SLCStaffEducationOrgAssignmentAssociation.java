//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.22 at 01:42:02 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * StaffEducationOrganizationAssociation with key fields: StaffReference (StaffUniqueStateId), EducationOrganizationReference (StateOrganizationId), StaffClassification and BeginDate. Changed types of StaffReference and EducationOrganizationReference to SLC reference types. 
 * 
 * <p>Java class for SLC-StaffEducationOrgAssignmentAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-StaffEducationOrgAssignmentAssociation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StaffReference" type="{http://ed-fi.org/0100}SLC-StaffReferenceType"/>
 *         &lt;element name="EducationOrganizationReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType"/>
 *         &lt;element name="StaffClassification" type="{http://ed-fi.org/0100}StaffClassificationType"/>
 *         &lt;element name="PositionTitle" type="{http://ed-fi.org/0100}PositionTitle" minOccurs="0"/>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-StaffEducationOrgAssignmentAssociation", propOrder = {
    "staffReference",
    "educationOrganizationReference",
    "staffClassification",
    "positionTitle",
    "beginDate",
    "endDate"
})
public class SLCStaffEducationOrgAssignmentAssociation {

    @XmlElement(name = "StaffReference", required = true)
    protected SLCStaffReferenceType staffReference;
    @XmlElement(name = "EducationOrganizationReference", required = true)
    protected SLCEducationalOrgReferenceType educationOrganizationReference;
    @XmlElement(name = "StaffClassification", required = true)
    protected StaffClassificationType staffClassification;
    @XmlElement(name = "PositionTitle")
    protected String positionTitle;
    @XmlElement(name = "BeginDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar beginDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the staffReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCStaffReferenceType }
     *     
     */
    public SLCStaffReferenceType getStaffReference() {
        return staffReference;
    }

    /**
     * Sets the value of the staffReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCStaffReferenceType }
     *     
     */
    public void setStaffReference(SLCStaffReferenceType value) {
        this.staffReference = value;
    }

    /**
     * Gets the value of the educationOrganizationReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public SLCEducationalOrgReferenceType getEducationOrganizationReference() {
        return educationOrganizationReference;
    }

    /**
     * Sets the value of the educationOrganizationReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public void setEducationOrganizationReference(SLCEducationalOrgReferenceType value) {
        this.educationOrganizationReference = value;
    }

    /**
     * Gets the value of the staffClassification property.
     * 
     * @return
     *     possible object is
     *     {@link StaffClassificationType }
     *     
     */
    public StaffClassificationType getStaffClassification() {
        return staffClassification;
    }

    /**
     * Sets the value of the staffClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffClassificationType }
     *     
     */
    public void setStaffClassification(StaffClassificationType value) {
        this.staffClassification = value;
    }

    /**
     * Gets the value of the positionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     * Sets the value of the positionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionTitle(String value) {
        this.positionTitle = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginDate(XMLGregorianCalendar value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
