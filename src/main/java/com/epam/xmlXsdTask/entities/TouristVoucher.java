package com.epam.xmlXsdTask.entities;

import com.epam.xmlXsdTask.entities.associtedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associtedClasses.enums.Type;

public class TouristVoucher {
    private int id;
    private Type type;
    private String country;
    private int numberOfDays;
    private String transport;
    private HotelCharacteristics hotelCharacteristics;
    private int cost;
}
