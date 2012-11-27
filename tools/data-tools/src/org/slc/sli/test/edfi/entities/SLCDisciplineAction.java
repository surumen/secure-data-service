//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.11.16 at 01:39:34 PM EST
//


package org.slc.sli.test.edfi.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 *
 * <p>Java class for SLC-DisciplineAction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SLC-DisciplineAction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="DisciplineActionIdentifier" type="{http://ed-fi.org/0100}DisciplineActionIdentifier"/>
 *         &lt;element name="Disciplines" type="{http://ed-fi.org/0100}DisciplineDescriptorType" maxOccurs="unbounded"/>
 *         &lt;element name="DisciplineDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DisciplineActionLength" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ActualDisciplineActionLength" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DisciplineActionLengthDifferenceReason" type="{http://ed-fi.org/0100}DisciplineActionLengthDifferenceReasonType" minOccurs="0"/>
 *         &lt;element name="StudentReference" type="{http://ed-fi.org/0100}SLC-StudentReferenceType" maxOccurs="unbounded"/>
 *         &lt;element name="DisciplineIncidentReference" type="{http://ed-fi.org/0100}SLC-DisciplineIncidentReferenceType" maxOccurs="unbounded"/>
 *         &lt;element name="StaffReference" type="{http://ed-fi.org/0100}SLC-StaffReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ResponsibilitySchoolReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType"/>
 *         &lt;element name="AssignmentSchoolReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-DisciplineAction", propOrder = {
    "disciplineActionIdentifier",
    "disciplines",
    "disciplineDate",
    "disciplineActionLength",
    "actualDisciplineActionLength",
    "disciplineActionLengthDifferenceReason",
    "studentReference",
    "disciplineIncidentReference",
    "staffReference",
    "responsibilitySchoolReference",
    "assignmentSchoolReference"
})

@XmlRootElement(name = "DisciplineAction")
public class SLCDisciplineAction
    extends ComplexObjectType
{

    @XmlElement(name = "DisciplineActionIdentifier", required = true)
    protected String disciplineActionIdentifier;
    @XmlElement(name = "Disciplines", required = true)
    protected List<DisciplineDescriptorType> disciplines;
    @XmlElement(name = "DisciplineDate", required = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected String disciplineDate;
    @XmlElement(name = "DisciplineActionLength")
    protected BigInteger disciplineActionLength;
    @XmlElement(name = "ActualDisciplineActionLength")
    protected BigInteger actualDisciplineActionLength;
    @XmlElement(name = "DisciplineActionLengthDifferenceReason")
    protected DisciplineActionLengthDifferenceReasonType disciplineActionLengthDifferenceReason;
    @XmlElement(name = "StudentReference", required = true)
    protected List<SLCStudentReferenceType> studentReference;
    @XmlElement(name = "DisciplineIncidentReference", required = true)
    protected List<SLCDisciplineIncidentReferenceType> disciplineIncidentReference;
    @XmlElement(name = "StaffReference")
    protected List<SLCStaffReferenceType> staffReference;
    @XmlElement(name = "ResponsibilitySchoolReference", required = true)
    protected SLCEducationalOrgReferenceType responsibilitySchoolReference;
    @XmlElement(name = "AssignmentSchoolReference")
    protected SLCEducationalOrgReferenceType assignmentSchoolReference;

    /**
     * Gets the value of the disciplineActionIdentifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDisciplineActionIdentifier() {
        return disciplineActionIdentifier;
    }

    /**
     * Sets the value of the disciplineActionIdentifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDisciplineActionIdentifier(String value) {
        this.disciplineActionIdentifier = value;
    }

    /**
     * Gets the value of the disciplines property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disciplines property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisciplines().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisciplineDescriptorType }
     *
     *
     */
    public List<DisciplineDescriptorType> getDisciplines() {
        if (disciplines == null) {
            disciplines = new ArrayList<DisciplineDescriptorType>();
        }
        return this.disciplines;
    }

    /**
     * Gets the value of the disciplineDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDisciplineDate() {
        return disciplineDate;
    }

    /**
     * Sets the value of the disciplineDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDisciplineDate(String value) {
        this.disciplineDate = value;
    }

    /**
     * Gets the value of the disciplineActionLength property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getDisciplineActionLength() {
        return disciplineActionLength;
    }

    /**
     * Sets the value of the disciplineActionLength property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setDisciplineActionLength(BigInteger value) {
        this.disciplineActionLength = value;
    }

    /**
     * Gets the value of the actualDisciplineActionLength property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getActualDisciplineActionLength() {
        return actualDisciplineActionLength;
    }

    /**
     * Sets the value of the actualDisciplineActionLength property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setActualDisciplineActionLength(BigInteger value) {
        this.actualDisciplineActionLength = value;
    }

    /**
     * Gets the value of the disciplineActionLengthDifferenceReason property.
     *
     * @return
     *     possible object is
     *     {@link DisciplineActionLengthDifferenceReasonType }
     *
     */
    public DisciplineActionLengthDifferenceReasonType getDisciplineActionLengthDifferenceReason() {
        return disciplineActionLengthDifferenceReason;
    }

    /**
     * Sets the value of the disciplineActionLengthDifferenceReason property.
     *
     * @param value
     *     allowed object is
     *     {@link DisciplineActionLengthDifferenceReasonType }
     *
     */
    public void setDisciplineActionLengthDifferenceReason(DisciplineActionLengthDifferenceReasonType value) {
        this.disciplineActionLengthDifferenceReason = value;
    }

    /**
     * Gets the value of the studentReference property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentReference property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentReference().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SLCStudentReferenceType }
     *
     *
     */
    public List<SLCStudentReferenceType> getStudentReference() {
        if (studentReference == null) {
            studentReference = new ArrayList<SLCStudentReferenceType>();
        }
        return this.studentReference;
    }

    /**
     * Gets the value of the disciplineIncidentReference property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disciplineIncidentReference property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisciplineIncidentReference().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SLCDisciplineIncidentReferenceType }
     *
     *
     */
    public List<SLCDisciplineIncidentReferenceType> getDisciplineIncidentReference() {
        if (disciplineIncidentReference == null) {
            disciplineIncidentReference = new ArrayList<SLCDisciplineIncidentReferenceType>();
        }
        return this.disciplineIncidentReference;
    }

    /**
     * Gets the value of the staffReference property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffReference property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffReference().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SLCStaffReferenceType }
     *
     *
     */
    public List<SLCStaffReferenceType> getStaffReference() {
        if (staffReference == null) {
            staffReference = new ArrayList<SLCStaffReferenceType>();
        }
        return this.staffReference;
    }

    /**
     * Gets the value of the responsibilitySchoolReference property.
     *
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *
     */
    public SLCEducationalOrgReferenceType getResponsibilitySchoolReference() {
        return responsibilitySchoolReference;
    }

    /**
     * Sets the value of the responsibilitySchoolReference property.
     *
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *
     */
    public void setResponsibilitySchoolReference(SLCEducationalOrgReferenceType value) {
        this.responsibilitySchoolReference = value;
    }

    /**
     * Gets the value of the assignmentSchoolReference property.
     *
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *
     */
    public SLCEducationalOrgReferenceType getAssignmentSchoolReference() {
        return assignmentSchoolReference;
    }

    /**
     * Sets the value of the assignmentSchoolReference property.
     *
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *
     */
    public void setAssignmentSchoolReference(SLCEducationalOrgReferenceType value) {
        this.assignmentSchoolReference = value;
    }

}
