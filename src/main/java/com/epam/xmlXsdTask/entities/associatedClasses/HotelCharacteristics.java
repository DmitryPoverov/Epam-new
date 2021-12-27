package com.epam.xmlXsdTask.entities.associatedClasses;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "HotelCharacteristics", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCharacteristics", propOrder = {"numOfStars", "mealsIncluded", "roomType"})
public class HotelCharacteristics {
    @XmlElement(name = "numberOfStars", namespace = "test")
    private int numOfStars;
    @XmlElement(name = "mealsIncluded", namespace = "test")
    private MealsIncluded mealsIncluded;
    @XmlElement(name = "roomType", namespace = "test")
    private RoomType roomType;

    public HotelCharacteristics() {
    }

    public HotelCharacteristics(int numOfStars, MealsIncluded mealsIncluded, RoomType roomType) {
        this.numOfStars = numOfStars;
        this.mealsIncluded = mealsIncluded;
        this.roomType = roomType;
    }

    public void setNumOfStars(int numOfStars) {
        this.numOfStars = numOfStars;
    }
    public void setMealsIncluded(MealsIncluded mealsIncluded) {
        this.mealsIncluded = mealsIncluded;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumOfStars() {
        return numOfStars;
    }
    public MealsIncluded getMealsIncluded() {
        return mealsIncluded;
    }
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return  "\t\t[HotelCharacteristics: \n" +
                "\t\tnumOfStars = " + numOfStars + ", \n" +
                mealsIncluded + ", \n" +
                "\t\troomType = " + roomType.toString().toLowerCase() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelCharacteristics that = (HotelCharacteristics) o;

        if (numOfStars != that.numOfStars) return false;
        if (!mealsIncluded.equals(that.mealsIncluded)) return false;
        return roomType == that.roomType;
    }

    @Override
    public int hashCode() {
        int result = numOfStars;
        result = 31 * result + mealsIncluded.hashCode();
        result = 31 * result + roomType.hashCode();
        return result;
    }
}
