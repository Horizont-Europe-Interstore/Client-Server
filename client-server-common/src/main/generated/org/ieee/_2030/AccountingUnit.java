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
 * Unit for accounting; use either 'energyUnit' or 'currencyUnit' to specify the unit for 'value'.
 * 
 * <p>Java class for AccountingUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountingUnit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="energyUnit" type="{http://ieee.org/2030.5}RealEnergy" minOccurs="0"/&gt;
 *         &lt;element name="monetaryUnit" type="{http://ieee.org/2030.5}CurrencyCode"/&gt;
 *         &lt;element name="multiplier" type="{http://ieee.org/2030.5}PowerOfTenMultiplierType"/&gt;
 *         &lt;element name="value" type="{http://ieee.org/2030.5}Int32"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountingUnit", propOrder = {
    "energyUnit",
    "monetaryUnit",
    "multiplier",
    "value"
})
public class AccountingUnit {

    protected RealEnergy energyUnit;
    @XmlElement(required = true)
    protected CurrencyCode monetaryUnit;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType multiplier;
    protected int value;

    /**
     * Gets the value of the energyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link RealEnergy }
     *     
     */
    public RealEnergy getEnergyUnit() {
        return energyUnit;
    }

    /**
     * Sets the value of the energyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEnergy }
     *     
     */
    public void setEnergyUnit(RealEnergy value) {
        this.energyUnit = value;
    }

    /**
     * Gets the value of the monetaryUnit property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getMonetaryUnit() {
        return monetaryUnit;
    }

    /**
     * Sets the value of the monetaryUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setMonetaryUnit(CurrencyCode value) {
        this.monetaryUnit = value;
    }

    /**
     * Gets the value of the multiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setMultiplier(PowerOfTenMultiplierType value) {
        this.multiplier = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}