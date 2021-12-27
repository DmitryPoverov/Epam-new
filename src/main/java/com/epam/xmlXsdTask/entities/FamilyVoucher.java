package com.epam.xmlXsdTask.entities;

import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "FamilyVoucher", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyVoucher", propOrder = {"numOfFamilyMembers"})
public class FamilyVoucher extends Voucher {
    @XmlElement(name = "numOfFamilyMembers", namespace = "test")
    private int numOfFamilyMembers;

    public FamilyVoucher() {
    }

    public FamilyVoucher(int id, Type type, String country, int days, String transport, HotelCharacteristics characteristics, int cost, int members) {
        super(id, type, country, days, transport, characteristics, cost);
        this.numOfFamilyMembers = members;
    }

    public void setNumOfFamilyMembers(int numOfFamilyMembers) {
        this.numOfFamilyMembers = numOfFamilyMembers;
    }

    public int getNumOfFamilyMembers() {
        return numOfFamilyMembers;
    }

    @Override
    public String toString() {
        return "\t[FamilyTrip object: \n" +
                super.toString() + " \n" +
                "\tmembers = " + numOfFamilyMembers + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FamilyVoucher that = (FamilyVoucher) o;

        return numOfFamilyMembers == that.numOfFamilyMembers;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numOfFamilyMembers;
        return result;
    }
}
