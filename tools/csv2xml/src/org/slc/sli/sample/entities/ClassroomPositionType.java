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
 * <p>Java class for ClassroomPositionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClassroomPositionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Teacher of Record"/>
 *     &lt;enumeration value="Assistant Teacher"/>
 *     &lt;enumeration value="Support Teacher"/>
 *     &lt;enumeration value="Substitute Teacher"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClassroomPositionType")
@XmlEnum
public enum ClassroomPositionType {

    @XmlEnumValue("Teacher of Record")
    TEACHER_OF_RECORD("Teacher of Record"),
    @XmlEnumValue("Assistant Teacher")
    ASSISTANT_TEACHER("Assistant Teacher"),
    @XmlEnumValue("Support Teacher")
    SUPPORT_TEACHER("Support Teacher"),
    @XmlEnumValue("Substitute Teacher")
    SUBSTITUTE_TEACHER("Substitute Teacher");
    private final String value;

    ClassroomPositionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClassroomPositionType fromValue(String v) {
        for (ClassroomPositionType c: ClassroomPositionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
