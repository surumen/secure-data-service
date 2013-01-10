/*
 * Copyright 2012 Shared Learning Collaborative, LLC
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Cohort" type="{http://ed-fi.org/0100}Cohort"/>
 *         &lt;element name="StudentCohortAssociation" type="{http://ed-fi.org/0100}StudentCohortAssociation"/>
 *         &lt;element name="StaffCohortAssociation" type="{http://ed-fi.org/0100}StaffCohortAssociation"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cohortOrStudentCohortAssociationOrStaffCohortAssociation"
})
@XmlRootElement(name = "InterchangeStudentCohort")
public class InterchangeStudentCohort {

    @XmlElements({
        @XmlElement(name = "StaffCohortAssociation", type = StaffCohortAssociation.class),
        @XmlElement(name = "StudentCohortAssociation", type = StudentCohortAssociation.class),
        @XmlElement(name = "Cohort", type = Cohort.class)
    })
    protected List<Object> cohortOrStudentCohortAssociationOrStaffCohortAssociation;

    /**
     * Gets the value of the cohortOrStudentCohortAssociationOrStaffCohortAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cohortOrStudentCohortAssociationOrStaffCohortAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCohortOrStudentCohortAssociationOrStaffCohortAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffCohortAssociation }
     * {@link StudentCohortAssociation }
     * {@link Cohort }
     * 
     * 
     */
    public List<Object> getCohortOrStudentCohortAssociationOrStaffCohortAssociation() {
        if (cohortOrStudentCohortAssociationOrStaffCohortAssociation == null) {
            cohortOrStudentCohortAssociationOrStaffCohortAssociation = new ArrayList<Object>();
        }
        return this.cohortOrStudentCohortAssociationOrStaffCohortAssociation;
    }

}
