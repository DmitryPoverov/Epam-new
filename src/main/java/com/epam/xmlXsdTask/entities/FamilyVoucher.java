package com.epam.xmlXsdTask.entities;

public class FamilyVoucher extends Voucher {
    private int numOfFamilyMembers;

    public FamilyVoucher() {
    }

    public int getNumOfFamilyMembers() {
        return numOfFamilyMembers;
    }

    public void setNumOfFamilyMembers(int numOfFamilyMembers) {
        this.numOfFamilyMembers = numOfFamilyMembers;
    }

    @Override
    public String toString() {
        return "FamilyTrip object: \n" +
                super.toString() + " \n" +
                "numOfMeetings=" + numOfFamilyMembers;
    }
}
