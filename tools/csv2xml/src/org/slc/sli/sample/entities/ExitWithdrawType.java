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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExitWithdrawType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExitWithdrawType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Student is in a different public school in the same local education agency"/>
 *     &lt;enumeration value="Transferred to a public school in a different local education agency in the same state"/>
 *     &lt;enumeration value="Transferred to a public school in a different state"/>
 *     &lt;enumeration value="Transferred to a private, non-religiously-affiliated school in the same local education agency"/>
 *     &lt;enumeration value="Transferred to a private, non-religiously-affiliated school in a different local education agency in the same state"/>
 *     &lt;enumeration value="Transferred to a private, non-religiously-affiliated school in a different state"/>
 *     &lt;enumeration value="Transferred to a private, religiously-affiliated school in the same local education agency"/>
 *     &lt;enumeration value="Transferred to a private, religiously-affiliated school in a different local education agency in the same state"/>
 *     &lt;enumeration value="Transferred to a private, religiously-affiliated school in a different state"/>
 *     &lt;enumeration value="Transferred to a school outside of the country"/>
 *     &lt;enumeration value="Transferred to an institution"/>
 *     &lt;enumeration value="Transferred to home schooling"/>
 *     &lt;enumeration value="Transferred to a charter school"/>
 *     &lt;enumeration value="Graduated with regular, advanced, International Baccalaureate, or other type of diploma"/>
 *     &lt;enumeration value="Completed school with other credentials"/>
 *     &lt;enumeration value="Died or is permanently incapacitated"/>
 *     &lt;enumeration value="Withdrawn due to illness"/>
 *     &lt;enumeration value="Expelled or involuntarily withdrawn"/>
 *     &lt;enumeration value="Reached maximum age for services"/>
 *     &lt;enumeration value="Discontinued schooling"/>
 *     &lt;enumeration value="Completed grade 12, but did not meet all graduation requirements"/>
 *     &lt;enumeration value="Enrolled in a postsecondary early admission program, eligible to return"/>
 *     &lt;enumeration value="Not enrolled, unknown status"/>
 *     &lt;enumeration value="Student is in the same local education agency and receiving education services, but is not assigned to a particular school"/>
 *     &lt;enumeration value="Enrolled in an adult education or training program"/>
 *     &lt;enumeration value="Completed a state-recognized vocational education program"/>
 *     &lt;enumeration value="Not enrolled, eligible to return"/>
 *     &lt;enumeration value="Enrolled in a foreign exchange program, eligible to return"/>
 *     &lt;enumeration value="Withdrawn from school, under the age for compulsory attendance; eligible to return"/>
 *     &lt;enumeration value="Exited"/>
 *     &lt;enumeration value="Student is in a charter school managed by the same local education agency"/>
 *     &lt;enumeration value="Completed with a state-recognized equivalency certificate"/>
 *     &lt;enumeration value="Removed by Child Protective Services"/>
 *     &lt;enumeration value="Transferred to a private school in the state"/>
 *     &lt;enumeration value="Graduated outside of state prior to enrollment"/>
 *     &lt;enumeration value="Completed equivalency certificate outside of state"/>
 *     &lt;enumeration value="Enrolled in University High School Diploma Program"/>
 *     &lt;enumeration value="Court ordered to a GED program, has not earned a GED"/>
 *     &lt;enumeration value="Incarcerated in a state jail or federal penitentiary as an adult"/>
 *     &lt;enumeration value="Graduated from another state under Interstate Compact on Educational Opportunity for Military Children"/>
 *     &lt;enumeration value="Dropout"/>
 *     &lt;enumeration value="End of school year"/>
 *     &lt;enumeration value="Invalid enrollment"/>
 *     &lt;enumeration value="No show"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExitWithdrawType")
@XmlEnum
public enum ExitWithdrawType {

    @XmlEnumValue("Student is in a different public school in the same local education agency")
    STUDENT_IS_IN_A_DIFFERENT_PUBLIC_SCHOOL_IN_THE_SAME_LOCAL_EDUCATION_AGENCY("Student is in a different public school in the same local education agency"),
    @XmlEnumValue("Transferred to a public school in a different local education agency in the same state")
    TRANSFERRED_TO_A_PUBLIC_SCHOOL_IN_A_DIFFERENT_LOCAL_EDUCATION_AGENCY_IN_THE_SAME_STATE("Transferred to a public school in a different local education agency in the same state"),
    @XmlEnumValue("Transferred to a public school in a different state")
    TRANSFERRED_TO_A_PUBLIC_SCHOOL_IN_A_DIFFERENT_STATE("Transferred to a public school in a different state"),
    @XmlEnumValue("Transferred to a private, non-religiously-affiliated school in the same local education agency")
    TRANSFERRED_TO_A_PRIVATE_NON_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_THE_SAME_LOCAL_EDUCATION_AGENCY("Transferred to a private, non-religiously-affiliated school in the same local education agency"),
    @XmlEnumValue("Transferred to a private, non-religiously-affiliated school in a different local education agency in the same state")
    TRANSFERRED_TO_A_PRIVATE_NON_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_A_DIFFERENT_LOCAL_EDUCATION_AGENCY_IN_THE_SAME_STATE("Transferred to a private, non-religiously-affiliated school in a different local education agency in the same state"),
    @XmlEnumValue("Transferred to a private, non-religiously-affiliated school in a different state")
    TRANSFERRED_TO_A_PRIVATE_NON_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_A_DIFFERENT_STATE("Transferred to a private, non-religiously-affiliated school in a different state"),
    @XmlEnumValue("Transferred to a private, religiously-affiliated school in the same local education agency")
    TRANSFERRED_TO_A_PRIVATE_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_THE_SAME_LOCAL_EDUCATION_AGENCY("Transferred to a private, religiously-affiliated school in the same local education agency"),
    @XmlEnumValue("Transferred to a private, religiously-affiliated school in a different local education agency in the same state")
    TRANSFERRED_TO_A_PRIVATE_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_A_DIFFERENT_LOCAL_EDUCATION_AGENCY_IN_THE_SAME_STATE("Transferred to a private, religiously-affiliated school in a different local education agency in the same state"),
    @XmlEnumValue("Transferred to a private, religiously-affiliated school in a different state")
    TRANSFERRED_TO_A_PRIVATE_RELIGIOUSLY_AFFILIATED_SCHOOL_IN_A_DIFFERENT_STATE("Transferred to a private, religiously-affiliated school in a different state"),
    @XmlEnumValue("Transferred to a school outside of the country")
    TRANSFERRED_TO_A_SCHOOL_OUTSIDE_OF_THE_COUNTRY("Transferred to a school outside of the country"),
    @XmlEnumValue("Transferred to an institution")
    TRANSFERRED_TO_AN_INSTITUTION("Transferred to an institution"),
    @XmlEnumValue("Transferred to home schooling")
    TRANSFERRED_TO_HOME_SCHOOLING("Transferred to home schooling"),
    @XmlEnumValue("Transferred to a charter school")
    TRANSFERRED_TO_A_CHARTER_SCHOOL("Transferred to a charter school"),
    @XmlEnumValue("Graduated with regular, advanced, International Baccalaureate, or other type of diploma")
    GRADUATED_WITH_REGULAR_ADVANCED_INTERNATIONAL_BACCALAUREATE_OR_OTHER_TYPE_OF_DIPLOMA("Graduated with regular, advanced, International Baccalaureate, or other type of diploma"),
    @XmlEnumValue("Completed school with other credentials")
    COMPLETED_SCHOOL_WITH_OTHER_CREDENTIALS("Completed school with other credentials"),
    @XmlEnumValue("Died or is permanently incapacitated")
    DIED_OR_IS_PERMANENTLY_INCAPACITATED("Died or is permanently incapacitated"),
    @XmlEnumValue("Withdrawn due to illness")
    WITHDRAWN_DUE_TO_ILLNESS("Withdrawn due to illness"),
    @XmlEnumValue("Expelled or involuntarily withdrawn")
    EXPELLED_OR_INVOLUNTARILY_WITHDRAWN("Expelled or involuntarily withdrawn"),
    @XmlEnumValue("Reached maximum age for services")
    REACHED_MAXIMUM_AGE_FOR_SERVICES("Reached maximum age for services"),
    @XmlEnumValue("Discontinued schooling")
    DISCONTINUED_SCHOOLING("Discontinued schooling"),
    @XmlEnumValue("Completed grade 12, but did not meet all graduation requirements")
    COMPLETED_GRADE_12_BUT_DID_NOT_MEET_ALL_GRADUATION_REQUIREMENTS("Completed grade 12, but did not meet all graduation requirements"),
    @XmlEnumValue("Enrolled in a postsecondary early admission program, eligible to return")
    ENROLLED_IN_A_POSTSECONDARY_EARLY_ADMISSION_PROGRAM_ELIGIBLE_TO_RETURN("Enrolled in a postsecondary early admission program, eligible to return"),
    @XmlEnumValue("Not enrolled, unknown status")
    NOT_ENROLLED_UNKNOWN_STATUS("Not enrolled, unknown status"),
    @XmlEnumValue("Student is in the same local education agency and receiving education services, but is not assigned to a particular school")
    STUDENT_IS_IN_THE_SAME_LOCAL_EDUCATION_AGENCY_AND_RECEIVING_EDUCATION_SERVICES_BUT_IS_NOT_ASSIGNED_TO_A_PARTICULAR_SCHOOL("Student is in the same local education agency and receiving education services, but is not assigned to a particular school"),
    @XmlEnumValue("Enrolled in an adult education or training program")
    ENROLLED_IN_AN_ADULT_EDUCATION_OR_TRAINING_PROGRAM("Enrolled in an adult education or training program"),
    @XmlEnumValue("Completed a state-recognized vocational education program")
    COMPLETED_A_STATE_RECOGNIZED_VOCATIONAL_EDUCATION_PROGRAM("Completed a state-recognized vocational education program"),
    @XmlEnumValue("Not enrolled, eligible to return")
    NOT_ENROLLED_ELIGIBLE_TO_RETURN("Not enrolled, eligible to return"),
    @XmlEnumValue("Enrolled in a foreign exchange program, eligible to return")
    ENROLLED_IN_A_FOREIGN_EXCHANGE_PROGRAM_ELIGIBLE_TO_RETURN("Enrolled in a foreign exchange program, eligible to return"),
    @XmlEnumValue("Withdrawn from school, under the age for compulsory attendance; eligible to return")
    WITHDRAWN_FROM_SCHOOL_UNDER_THE_AGE_FOR_COMPULSORY_ATTENDANCE_ELIGIBLE_TO_RETURN("Withdrawn from school, under the age for compulsory attendance; eligible to return"),
    @XmlEnumValue("Exited")
    EXITED("Exited"),
    @XmlEnumValue("Student is in a charter school managed by the same local education agency")
    STUDENT_IS_IN_A_CHARTER_SCHOOL_MANAGED_BY_THE_SAME_LOCAL_EDUCATION_AGENCY("Student is in a charter school managed by the same local education agency"),
    @XmlEnumValue("Completed with a state-recognized equivalency certificate")
    COMPLETED_WITH_A_STATE_RECOGNIZED_EQUIVALENCY_CERTIFICATE("Completed with a state-recognized equivalency certificate"),
    @XmlEnumValue("Removed by Child Protective Services")
    REMOVED_BY_CHILD_PROTECTIVE_SERVICES("Removed by Child Protective Services"),
    @XmlEnumValue("Transferred to a private school in the state")
    TRANSFERRED_TO_A_PRIVATE_SCHOOL_IN_THE_STATE("Transferred to a private school in the state"),
    @XmlEnumValue("Graduated outside of state prior to enrollment")
    GRADUATED_OUTSIDE_OF_STATE_PRIOR_TO_ENROLLMENT("Graduated outside of state prior to enrollment"),
    @XmlEnumValue("Completed equivalency certificate outside of state")
    COMPLETED_EQUIVALENCY_CERTIFICATE_OUTSIDE_OF_STATE("Completed equivalency certificate outside of state"),
    @XmlEnumValue("Enrolled in University High School Diploma Program")
    ENROLLED_IN_UNIVERSITY_HIGH_SCHOOL_DIPLOMA_PROGRAM("Enrolled in University High School Diploma Program"),
    @XmlEnumValue("Court ordered to a GED program, has not earned a GED")
    COURT_ORDERED_TO_A_GED_PROGRAM_HAS_NOT_EARNED_A_GED("Court ordered to a GED program, has not earned a GED"),
    @XmlEnumValue("Incarcerated in a state jail or federal penitentiary as an adult")
    INCARCERATED_IN_A_STATE_JAIL_OR_FEDERAL_PENITENTIARY_AS_AN_ADULT("Incarcerated in a state jail or federal penitentiary as an adult"),
    @XmlEnumValue("Graduated from another state under Interstate Compact on Educational Opportunity for Military Children")
    GRADUATED_FROM_ANOTHER_STATE_UNDER_INTERSTATE_COMPACT_ON_EDUCATIONAL_OPPORTUNITY_FOR_MILITARY_CHILDREN("Graduated from another state under Interstate Compact on Educational Opportunity for Military Children"),
    @XmlEnumValue("Dropout")
    DROPOUT("Dropout"),
    @XmlEnumValue("End of school year")
    END_OF_SCHOOL_YEAR("End of school year"),
    @XmlEnumValue("Invalid enrollment")
    INVALID_ENROLLMENT("Invalid enrollment"),
    @XmlEnumValue("No show")
    NO_SHOW("No show"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    ExitWithdrawType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExitWithdrawType fromValue(String v) {
        for (ExitWithdrawType c: ExitWithdrawType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
