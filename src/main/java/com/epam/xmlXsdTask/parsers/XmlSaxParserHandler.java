package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags.*;

public class XmlSaxParserHandler extends DefaultHandler {

    public List<Voucher> vouchers = new ArrayList<>();

    HotelCharacteristics hotelCharacteristics = null;
    MealsIncluded mealsIncluded = new MealsIncluded();

    private Voucher currentVoucher;
    private boolean insideFamilyVoucherTag;
    private boolean insideBusinessVoucherTag;
    private String currentTagName;

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        currentTagName = qName;

        if (currentTagName == null) {
            return;
        }

        if(currentTagName.equals(getData(TAG_FAMILY_VOUCHER))) {
            currentVoucher = new FamilyVoucher();
            currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
            insideFamilyVoucherTag = true;
        }

        if (currentTagName.equals(getData(TAG_BUSINESS_VOUCHER))) {
            currentVoucher = new BusinessVoucher();
            currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
            insideBusinessVoucherTag = true;
        }

        if (currentTagName.equals(getData(TAG_MEALS_INCLUDED))) {
            mealsIncluded.setAvailable(Boolean.parseBoolean(attributes.getValue("available")));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        String endOfTheTag = qName;

        if (endOfTheTag == null) {
            return;
        }

        if (endOfTheTag.equals(getData(TAG_FAMILY_VOUCHER))) {
            insideFamilyVoucherTag = false;
            vouchers.add(currentVoucher);

        }

        if (endOfTheTag.equals(getData(TAG_BUSINESS_VOUCHER))) {
            insideBusinessVoucherTag = false;
            vouchers.add(currentVoucher);
        }

        currentTagName = null;

    }//endElement

    @Override
    public void characters(char[] ch, int start, int length) {

        String tagData = new String (ch, start, length);

        if (currentTagName == null) {
            return;
        }

        processingCommonTags(currentTagName, tagData);

        if (insideFamilyVoucherTag && currentTagName.equals(getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
            FamilyVoucher familyVoucher = (FamilyVoucher) currentVoucher;
            familyVoucher.setNumOfFamilyMembers(Integer.parseInt(tagData));

        }

        if (insideBusinessVoucherTag && currentTagName.equals(getData(TAG_NUMBER_OF_MEETINGS))) {
            BusinessVoucher businessVoucher = (BusinessVoucher) currentVoucher;
            businessVoucher.setNumOfMeetings(Integer.parseInt(tagData));

        }

    }//characters

    private void processingCommonTags(String currentTagName, String tagData) {

        //HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();

        if (currentTagName.equals(getData(TAG_TYPE))) {
            currentVoucher.setType(Type.valueOf(tagData.toUpperCase()));
        }

        if (currentTagName.equals(getData(TAG_COUNTRY))) {
            currentVoucher.setCountry(tagData);
        }

        if (currentTagName.equals(getData(TAG_NUMBER_OF_DAYS))) {
            currentVoucher.setNumberOfDays(Integer.parseInt(tagData));
        }

        if (currentTagName.equals(getData(TAG_TRANSPORT))) {
            currentVoucher.setTransport(tagData);
        }

        /*Костылик временный*/
        if (insideBusinessVoucherTag && currentTagName.equals(getData(TAG_HOTEL_CHARACTERISTICS))) {
            hotelCharacteristics = new HotelCharacteristics();
        }

        if (insideFamilyVoucherTag && currentTagName.equals(getData(TAG_HOTEL_CHARACTERISTICS))) {
            hotelCharacteristics = new HotelCharacteristics();
        }

        if (currentTagName.equals(getData(TAG_NUMBER_OF_STARS))) {
            hotelCharacteristics.setNumOfStars(Integer.parseInt(tagData));
        }

        if (insideFamilyVoucherTag && currentTagName.equals(getData(TAG_MEAL_TYPE))) {
            MealsIncluded finalmealsIncluded = new MealsIncluded();
            finalmealsIncluded.setAvailable(mealsIncluded.getAvailable());
            finalmealsIncluded.setMealType(MealType.valueOf(tagData.toUpperCase()));
            mealsIncluded = finalmealsIncluded;
        }

        if (insideBusinessVoucherTag && currentTagName.equals(getData(TAG_MEAL_TYPE))) {
            MealsIncluded finalmealsIncluded = new MealsIncluded();
            finalmealsIncluded.setAvailable(mealsIncluded.getAvailable());
            finalmealsIncluded.setMealType(MealType.valueOf(tagData.toUpperCase()));
            mealsIncluded = finalmealsIncluded;
        }



        if (currentTagName.equals(getData(TAG_ROOM_TYPE))) {
            hotelCharacteristics.setRoomType(RoomType.valueOf(tagData.toUpperCase()));
            hotelCharacteristics.setMealsIncluded(mealsIncluded);
            currentVoucher.setHotelCharacteristics(hotelCharacteristics);
        }

        if (currentTagName.equals(getData(TAG_COST))) {
            currentVoucher.setCost(Integer.parseInt(tagData));
        }

    }//processingCommonTags


}//SaxParserHandler
