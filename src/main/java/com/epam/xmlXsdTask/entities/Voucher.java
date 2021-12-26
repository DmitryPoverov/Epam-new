package com.epam.xmlXsdTask.entities;

import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Voucher", propOrder = {"id", "type", "country", "numberOfDays", "transport", "hotelCharacteristics", "cost"})
@XmlSeeAlso({FamilyVoucher.class, BusinessVoucher.class})
public abstract class Voucher {
    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(namespace = "test")
    private Type type;
    @XmlElement(namespace = "test")
    private String country;
    @XmlElement(namespace = "test")
    private int numberOfDays;
    @XmlElement(namespace = "test")
    private String transport;
    @XmlElement(namespace = "test")
    private HotelCharacteristics hotelCharacteristics;
    @XmlElement(namespace = "test")
    private int cost;

        public Voucher() {
        }

        public int getId() {
            return id;
        }
        public Type getType() {
            return type;
        }
        public String getCountry() {
            return country;
        }
        public int getNumberOfDays() {
            return numberOfDays;
        }
        public String getTransport() {
            return transport;
        }
        public HotelCharacteristics getHotelCharacteristics() {
            return hotelCharacteristics;
        }
        public int getCost() {
            return cost;
        }

        public void setId(int id) {
            this.id = id;
        }
        public void setType(Type type) {
            this.type = type;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setNumberOfDays(int numberOfDays) {
            this.numberOfDays = numberOfDays;
        }
        public void setTransport(String transport) {
            this.transport = transport;
        }
        public void setHotelCharacteristics(HotelCharacteristics hotelCharacteristics) {
            this.hotelCharacteristics = hotelCharacteristics;
        }
        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return  "\tid = " + id + ", \n" +
                    "\ttype = " + type + ", \n" +
                    "\tcountry = " + country + ", \n" +
                    "\tnumberOfDays = " + numberOfDays + ", \n" +
                    "\ttransport = " + transport + ", \n" +
                    hotelCharacteristics + ", \n" +
                    "\tcost = " + cost;
        }
    }
