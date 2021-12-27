package com.epam.xmlXsdTask.entities.associatedClasses.enums;

public enum Tags {

    TAG_TOURIST_VOUCHERS("touristVouchers"),
    TAG_FAMILY_VOUCHER("familyVoucher"),
    TAG_BUSINESS_VOUCHER("businessVoucher"),
    TAG_TYPE("type"),
    TAG_COUNTRY("country"),
    TAG_NUMBER_OF_DAYS("numberOfDays"),
    TAG_TRANSPORT("transport"),
    TAG_HOTEL_CHARACTERISTICS("hotelCharacteristics"),
    TAG_NUMBER_OF_STARS("numberOfStars"),
    TAG_MEALS_INCLUDED("mealsIncluded"),
    TAG_MEAL_TYPE("mealType"),
    TAG_ROOM_TYPE("roomType"),
    TAG_COST("cost"),
    TAG_NUMBER_OF_FAMILY_MEMBERS("numOfFamilyMembers"),
    TAG_NUMBER_OF_MEETINGS("numOfMeetings");

    private final String data;

    Tags(String data) {
        this.data = data;
    }

    public static String getData(Tags data) {
        return data.getData();
    }

    public String getData() {
        return data;
    }
}
