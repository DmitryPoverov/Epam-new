package com.epam.xmlXsdTask.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessVoucher", propOrder = {"numOfMeetings"})
public class BusinessVoucher extends Voucher{
    @XmlElement(name = "numOfMeetings", namespace = "test")
    private int numOfMeetings;

    public BusinessVoucher() {
    }

    public int getNumOfMeetings() {
        return numOfMeetings;
    }

    public void setNumOfMeetings(int numOfMeetings) {
        this.numOfMeetings = numOfMeetings;
    }

    @Override
    public String toString() {
        return "[BusinessVoucher object: \n" +
                super.toString() + " \n" +
                "numOfMeetings=" + numOfMeetings + "]";
    }
}
