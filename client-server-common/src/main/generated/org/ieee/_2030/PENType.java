//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.25 at 08:56:47 PM CET 
//


package org.ieee._2030;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * IANA Private Enterprise Number [PEN].
 * 
 * <p>Java class for PENType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PENType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://ieee.org/2030.5&gt;UInt32"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PENType", propOrder = {
    "value"
})
public class PENType {

    @XmlValue
    protected long value;

    /**
     * Unsigned integer, max inclusive 4294967295 (2^32-1)
     * 
     */
    public long getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(long value) {
        this.value = value;
    }

}