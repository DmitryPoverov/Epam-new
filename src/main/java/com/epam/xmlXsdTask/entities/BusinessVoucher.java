package com.epam.xmlXsdTask.entities;

public class BusinessVoucher extends Voucher {
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
        return "BusinessVoucher object: \n" +
                super.toString() + " \n" +
                "numOfMeetings=" + numOfMeetings;
    }
}
