//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.16 at 01:39:34 PM EST 
//


package org.slc.sli.test.edfi.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides alternative references for class periods during interchange. Use XML IDREF to reference a course record that is included in the interchange
 * 
 * <p>Java class for ClassPeriodReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassPeriodReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ReferenceType">
 *       &lt;sequence>
 *         &lt;element name="ClassPeriodIdentity" type="{http://ed-fi.org/0100}ClassPeriodIdentityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassPeriodReferenceType", propOrder = {
    "classPeriodIdentity"
})
public class ClassPeriodReferenceType
    extends ReferenceType
{

    @XmlElement(name = "ClassPeriodIdentity")
    protected ClassPeriodIdentityType classPeriodIdentity;

    /**
     * Gets the value of the classPeriodIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link ClassPeriodIdentityType }
     *     
     */
    public ClassPeriodIdentityType getClassPeriodIdentity() {
        return classPeriodIdentity;
    }

    /**
     * Sets the value of the classPeriodIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassPeriodIdentityType }
     *     
     */
    public void setClassPeriodIdentity(ClassPeriodIdentityType value) {
        this.classPeriodIdentity = value;
    }

}
