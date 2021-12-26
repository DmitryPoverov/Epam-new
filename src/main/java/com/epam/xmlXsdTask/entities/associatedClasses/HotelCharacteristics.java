package com.epam.xmlXsdTask.entities.associatedClasses;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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

    public int getNumOfStars() {
        return numOfStars;
    }
    public MealsIncluded getMealsIncluded() {
        return mealsIncluded;
    }
    public RoomType getRoomType() {
        return roomType;
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

    @Override
    public String toString() {
        return  "\t\t[HotelCharacteristics: \n" +
                "\t\tnumOfStars = " + numOfStars + ", \n" +
                mealsIncluded + ", \n" +
                "\t\troomType = " + roomType.toString().toLowerCase() + "]";
    }
}
