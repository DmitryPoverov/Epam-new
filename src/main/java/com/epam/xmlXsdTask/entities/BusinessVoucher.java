package com.epam.xmlXsdTask.entities;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "BusinessVoucher", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessVoucher", propOrder = {"numOfMeetings"})
public class BusinessVoucher extends Voucher{
    @XmlElement(name = "numOfMeetings", namespace = "test")
    private int numOfMeetings;

    public BusinessVoucher() {
    }

    public void setNumOfMeetings(int numOfMeetings) {
        this.numOfMeetings = numOfMeetings;
    }

    public int getNumOfMeetings() {
        return numOfMeetings;
    }

    @Override
    public String toString() {
        return "[BusinessVoucher object: \n" +
                super.toString() + " \n" +
                "numOfMeetings=" + numOfMeetings + "]";
    }
}
