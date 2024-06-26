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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Response object is the generic response data repository which is extended for specific function sets.
 * 
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ieee.org/2030.5}Resource"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="createdDateTime" type="{http://ieee.org/2030.5}TimeType" minOccurs="0"/&gt;
 *         &lt;element name="endDeviceLFDI" type="{http://ieee.org/2030.5}HexBinary160"/&gt;
 *         &lt;element name="status" type="{http://ieee.org/2030.5}UInt8" minOccurs="0"/&gt;
 *         &lt;element name="subject" type="{http://ieee.org/2030.5}mRIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "createdDateTime",
    "endDeviceLFDI",
    "status",
    "subject"
})
@XmlSeeAlso({
    DERControlResponse.class,
    FlowReservationResponseResponse.class,
    DrResponse.class,
    PriceResponse.class,
    TextResponse.class
})
public class Response
    extends Resource
{

    protected TimeType createdDateTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] endDeviceLFDI;
    @XmlSchemaType(name = "unsignedByte")
    protected Short status;
    @XmlElement(required = true)
    protected MRIDType subject;

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreatedDateTime(TimeType value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the endDeviceLFDI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getEndDeviceLFDI() {
        return endDeviceLFDI;
    }

    /**
     * Sets the value of the endDeviceLFDI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDeviceLFDI(byte[] value) {
        this.endDeviceLFDI = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setStatus(Short value) {
        this.status = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link MRIDType }
     *     
     */
    public MRIDType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRIDType }
     *     
     */
    public void setSubject(MRIDType value) {
        this.subject = value;
    }

}
