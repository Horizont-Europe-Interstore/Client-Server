//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.25 at 08:56:47 PM CET 
//


package org.ieee._2030;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Distributed Energy Resource (DER) time/event-based control.
 * 
 * <p>Java class for DERControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERControl"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ieee.org/2030.5}RandomizableEvent"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DERControlBase" type="{http://ieee.org/2030.5}DERControlBase"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERControl", propOrder = {
    "derControlBase"
})
public class DERControl
    extends RandomizableEvent
{

    @XmlElement(name = "DERControlBase", required = true)
    protected DERControlBase derControlBase;

    /**
     * Gets the value of the derControlBase property.
     * 
     * @return
     *     possible object is
     *     {@link DERControlBase }
     *     
     */
    public DERControlBase getDERControlBase() {
        return derControlBase;
    }

    /**
     * Sets the value of the derControlBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERControlBase }
     *     
     */
    public void setDERControlBase(DERControlBase value) {
        this.derControlBase = value;
    }

}
