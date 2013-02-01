/*
 * Copyright 2012-2013 inBloom, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.20 at 03:09:04 PM EDT 
//


package org.slc.sli.sample.entities;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This association indicates the class sections to which a teacher is assigned to.
 * 
 * 
 * <p>Java class for TeacherSectionAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TeacherSectionAssociation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TeacherReference" type="{http://ed-fi.org/0100}StaffReferenceType"/>
 *         &lt;element name="SectionReference" type="{http://ed-fi.org/0100}SectionReferenceType"/>
 *         &lt;element name="ClassroomPosition" type="{http://ed-fi.org/0100}ClassroomPositionType"/>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HighlyQualifiedTeacher" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeacherSectionAssociation", propOrder = {
    "teacherReference",
    "sectionReference",
    "classroomPosition",
    "beginDate",
    "endDate",
    "highlyQualifiedTeacher"
})
public class TeacherSectionAssociation {

    @XmlElement(name = "TeacherReference", required = true)
    protected StaffReferenceType teacherReference;
    @XmlElement(name = "SectionReference", required = true)
    protected SectionReferenceType sectionReference;
    @XmlElement(name = "ClassroomPosition", required = true)
    protected ClassroomPositionType classroomPosition;
    @XmlElement(name = "BeginDate", type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar beginDate;
    @XmlElement(name = "EndDate", type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar endDate;
    @XmlElement(name = "HighlyQualifiedTeacher")
    protected Boolean highlyQualifiedTeacher;

    /**
     * Gets the value of the teacherReference property.
     * 
     * @return
     *     possible object is
     *     {@link StaffReferenceType }
     *     
     */
    public StaffReferenceType getTeacherReference() {
        return teacherReference;
    }

    /**
     * Sets the value of the teacherReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffReferenceType }
     *     
     */
    public void setTeacherReference(StaffReferenceType value) {
        this.teacherReference = value;
    }

    /**
     * Gets the value of the sectionReference property.
     * 
     * @return
     *     possible object is
     *     {@link SectionReferenceType }
     *     
     */
    public SectionReferenceType getSectionReference() {
        return sectionReference;
    }

    /**
     * Sets the value of the sectionReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SectionReferenceType }
     *     
     */
    public void setSectionReference(SectionReferenceType value) {
        this.sectionReference = value;
    }

    /**
     * Gets the value of the classroomPosition property.
     * 
     * @return
     *     possible object is
     *     {@link ClassroomPositionType }
     *     
     */
    public ClassroomPositionType getClassroomPosition() {
        return classroomPosition;
    }

    /**
     * Sets the value of the classroomPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassroomPositionType }
     *     
     */
    public void setClassroomPosition(ClassroomPositionType value) {
        this.classroomPosition = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(Calendar value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(Calendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the highlyQualifiedTeacher property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHighlyQualifiedTeacher() {
        return highlyQualifiedTeacher;
    }

    /**
     * Sets the value of the highlyQualifiedTeacher property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHighlyQualifiedTeacher(Boolean value) {
        this.highlyQualifiedTeacher = value;
    }

}
