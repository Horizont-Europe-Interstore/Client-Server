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
 * A set of Readings of the ReadingType indicated by the parent MeterReading.
 * 
 * <p>Java class for ReadingSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingSet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ieee.org/2030.5}ReadingSetBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReadingListLink" type="{http://ieee.org/2030.5}ReadingListLink" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingSet", propOrder = {
    "readingListLink"
})
public class ReadingSet
    extends ReadingSetBase
{

    @XmlElement(name = "ReadingListLink")
    protected ReadingListLink readingListLink;

    /**
     * Gets the value of the readingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingListLink }
     *     
     */
    public ReadingListLink getReadingListLink() {
        return readingListLink;
    }

    /**
     * Sets the value of the readingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingListLink }
     *     
     */
    public void setReadingListLink(ReadingListLink value) {
        this.readingListLink = value;
    }

}
