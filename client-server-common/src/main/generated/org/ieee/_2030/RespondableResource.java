//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.25 at 08:56:47 PM CET 
//


package org.ieee._2030;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A Resource to which a Response can be requested.
 * 
 * <p>Java class for RespondableResource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespondableResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ieee.org/2030.5}Resource"&gt;
 *       &lt;attribute name="replyTo" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="responseRequired" type="{http://ieee.org/2030.5}HexBinary8" default="00" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespondableResource")
@XmlSeeAlso({
    RespondableIdentifiedObject.class,
    RespondableSubscribableIdentifiedObject.class
})
public class RespondableResource
    extends Resource
{

    @XmlAttribute(name = "replyTo")
    @XmlSchemaType(name = "anyURI")
    protected String replyTo;
    @XmlAttribute(name = "responseRequired")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] responseRequired;

    /**
     * Gets the value of the replyTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * Sets the value of the replyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyTo(String value) {
        this.replyTo = value;
    }

    /**
     * Gets the value of the responseRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getResponseRequired() {
        if (responseRequired == null) {
            return new HexBinaryAdapter().unmarshal("00");
        } else {
            return responseRequired;
        }
    }

    /**
     * Sets the value of the responseRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseRequired(byte[] value) {
        this.responseRequired = value;
    }

}
