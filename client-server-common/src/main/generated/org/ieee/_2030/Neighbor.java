//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.25 at 08:56:47 PM CET 
//


package org.ieee._2030;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Contains 802.15.4 link layer specific attributes.
 * 
 * <p>Java class for Neighbor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Neighbor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ieee.org/2030.5}Resource"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="isChild" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="linkQuality" type="{http://ieee.org/2030.5}UInt8"/&gt;
 *         &lt;element name="shortAddress" type="{http://ieee.org/2030.5}UInt16"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Neighbor", propOrder = {
    "isChild",
    "linkQuality",
    "shortAddress"
})
public class Neighbor
    extends Resource
{

    protected boolean isChild;
    @XmlSchemaType(name = "unsignedByte")
    protected short linkQuality;
    @XmlSchemaType(name = "unsignedShort")
    protected int shortAddress;

    /**
     * Gets the value of the isChild property.
     * 
     */
    public boolean isIsChild() {
        return isChild;
    }

    /**
     * Sets the value of the isChild property.
     * 
     */
    public void setIsChild(boolean value) {
        this.isChild = value;
    }

    /**
     * Gets the value of the linkQuality property.
     * 
     */
    public short getLinkQuality() {
        return linkQuality;
    }

    /**
     * Sets the value of the linkQuality property.
     * 
     */
    public void setLinkQuality(short value) {
        this.linkQuality = value;
    }

    /**
     * Gets the value of the shortAddress property.
     * 
     */
    public int getShortAddress() {
        return shortAddress;
    }

    /**
     * Sets the value of the shortAddress property.
     * 
     */
    public void setShortAddress(int value) {
        this.shortAddress = value;
    }

}