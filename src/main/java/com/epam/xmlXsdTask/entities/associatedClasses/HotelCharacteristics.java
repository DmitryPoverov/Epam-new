package com.epam.xmlXsdTask.entities.associatedClasses;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;

public class HotelCharacteristics {
    private int numOfStars;
    private MealsIncluded mealsIncluded;
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
        return  "   	[HotelCharacteristicsData: \n" +
                "	numOfStars=" + numOfStars + ", \n" +
                "	mealsIncluded: \n" + mealsIncluded.toString() + ", \n" +
                "	roomType=" + roomType + "]";
    }
}
