//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.31 at 09:35:49 AM EDT 
//


package org.slc.sli.test.edfi.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PopulationServedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PopulationServedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Regular Students"/>
 *     &lt;enumeration value="Bilingual Students"/>
 *     &lt;enumeration value="Compensatory/Remedial Education Students"/>
 *     &lt;enumeration value="Gifted and Talented Students"/>
 *     &lt;enumeration value="Career and Technical Education Students"/>
 *     &lt;enumeration value="Special Education Students"/>
 *     &lt;enumeration value="ESL Students"/>
 *     &lt;enumeration value="Adult Basic Education Students"/>
 *     &lt;enumeration value="Honors Students"/>
 *     &lt;enumeration value="Migrant Students"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PopulationServedType")
@XmlEnum
public enum PopulationServedType {

    @XmlEnumValue("Regular Students")
    REGULAR_STUDENTS("Regular Students"),
    @XmlEnumValue("Bilingual Students")
    BILINGUAL_STUDENTS("Bilingual Students"),
    @XmlEnumValue("Compensatory/Remedial Education Students")
    COMPENSATORY_REMEDIAL_EDUCATION_STUDENTS("Compensatory/Remedial Education Students"),
    @XmlEnumValue("Gifted and Talented Students")
    GIFTED_AND_TALENTED_STUDENTS("Gifted and Talented Students"),
    @XmlEnumValue("Career and Technical Education Students")
    CAREER_AND_TECHNICAL_EDUCATION_STUDENTS("Career and Technical Education Students"),
    @XmlEnumValue("Special Education Students")
    SPECIAL_EDUCATION_STUDENTS("Special Education Students"),
    @XmlEnumValue("ESL Students")
    ESL_STUDENTS("ESL Students"),
    @XmlEnumValue("Adult Basic Education Students")
    ADULT_BASIC_EDUCATION_STUDENTS("Adult Basic Education Students"),
    @XmlEnumValue("Honors Students")
    HONORS_STUDENTS("Honors Students"),
    @XmlEnumValue("Migrant Students")
    MIGRANT_STUDENTS("Migrant Students");
    private final String value;

    PopulationServedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PopulationServedType fromValue(String v) {
        for (PopulationServedType c: PopulationServedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
