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
 * -9 = nano=x10^-9
 * -6 = micro=x10^-6
 * -3 = milli=x10^-3
 *  0 = none=x1 (default, if not specified)
 *  1 = deca=x10
 *  2 = hecto=x100
 *  3 = kilo=x1000
 *  6 = Mega=x10^6
 *  9 = Giga=x10^9
 * This is not a complete list. Any integer between -9 and 9 SHALL be supported, indicating the power of ten multiplier for the units.
 * 
 * <p>Java class for PowerOfTenMultiplierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerOfTenMultiplierType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://ieee.org/2030.5&gt;Int8"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerOfTenMultiplierType", propOrder = {
    "value"
})
public class PowerOfTenMultiplierType {

    @XmlValue
    protected byte value;

    /**
     * Signed integer, min -128 max +127
     * 
     */
    public byte getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(byte value) {
        this.value = value;
    }

}