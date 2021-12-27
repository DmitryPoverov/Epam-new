package com.epam.xmlXsdTask.entities;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "FamilyVoucher", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyVoucher", propOrder = {"numOfFamilyMembers"})
public class FamilyVoucher extends Voucher {
    @XmlElement(name = "numOfFamilyMembers", namespace = "test")
    private int numOfFamilyMembers;

    public FamilyVoucher() {
    }

    public void setNumOfFamilyMembers(int numOfFamilyMembers) {
        this.numOfFamilyMembers = numOfFamilyMembers;
    }

    public int getNumOfFamilyMembers() {
        return numOfFamilyMembers;
    }

    @Override
    public String toString() {
        return "[FamilyTrip object: \n" +
                super.toString() + " \n" +
                "numOfMeetings=" + numOfFamilyMembers + "]";
    }
}
