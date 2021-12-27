package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags.*;

public class XmlSaxParserHandler extends DefaultHandler {
    public List<Voucher> vouchers = new ArrayList<>();
    private HotelCharacteristics hotelCharacteristics = null;
    private MealsIncluded mealsIncluded = new MealsIncluded();
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

        if (currentTagName != null) {
            if(currentTagName.equals(Tags.getData(TAG_FAMILY_VOUCHER))) {
                currentVoucher = new FamilyVoucher();
                currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
                insideFamilyVoucherTag = true;
            } else if (currentTagName.equals(Tags.getData(TAG_BUSINESS_VOUCHER))) {
                currentVoucher = new BusinessVoucher();
                currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
                insideBusinessVoucherTag = true;
            } else if (currentTagName.equals(Tags.getData(TAG_MEALS_INCLUDED))) {
                mealsIncluded.setAvailable(Boolean.parseBoolean(attributes.getValue("available")));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName != null) {
            if (qName.equals(Tags.getData(TAG_FAMILY_VOUCHER))) {
                insideFamilyVoucherTag = false;
                vouchers.add(currentVoucher);
            } else if (qName.equals(Tags.getData(TAG_BUSINESS_VOUCHER))) {
                insideBusinessVoucherTag = false;
                vouchers.add(currentVoucher);
            }
            currentTagName = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String tagData = new String (ch, start, length);

        if (currentTagName != null) {

            processingCommonTags(currentTagName, tagData);

            if (insideFamilyVoucherTag && currentTagName.equals(Tags.getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
                FamilyVoucher familyVoucher = (FamilyVoucher) currentVoucher;
                familyVoucher.setNumOfFamilyMembers(Integer.parseInt(tagData));
            } else if (insideBusinessVoucherTag && currentTagName.equals(Tags.getData(TAG_NUMBER_OF_MEETINGS))) {
                BusinessVoucher businessVoucher = (BusinessVoucher) currentVoucher;
                businessVoucher.setNumOfMeetings(Integer.parseInt(tagData));
            }
        }
    }

    private void processingCommonTags(String currentTagName, String tagData) {
        if (currentTagName.equals(Tags.getData(TAG_TYPE))) {
            currentVoucher.setType(Type.valueOf(tagData.toUpperCase()));
        } else if (currentTagName.equals(Tags.getData(TAG_COUNTRY))) {
            currentVoucher.setCountry(tagData);
        } else if (currentTagName.equals(Tags.getData(TAG_NUMBER_OF_DAYS))) {
            currentVoucher.setNumberOfDays(Integer.parseInt(tagData));
        } else if (currentTagName.equals(Tags.getData(TAG_TRANSPORT))) {
            currentVoucher.setTransport(tagData);
        } else if (insideBusinessVoucherTag && currentTagName.equals(Tags.getData(TAG_HOTEL_CHARACTERISTICS))) {
            hotelCharacteristics = new HotelCharacteristics();
        } else if (insideFamilyVoucherTag && currentTagName.equals(Tags.getData(TAG_HOTEL_CHARACTERISTICS))) {
            hotelCharacteristics = new HotelCharacteristics();
        } else if (currentTagName.equals(Tags.getData(TAG_NUMBER_OF_STARS))) {
            hotelCharacteristics.setNumOfStars(Integer.parseInt(tagData));
        }else if (insideFamilyVoucherTag && currentTagName.equals(Tags.getData(TAG_MEAL_TYPE))) {
            MealsIncluded finalMealsIncluded = new MealsIncluded();
            finalMealsIncluded.setAvailable(mealsIncluded.getAvailable());
            finalMealsIncluded.setMealType(MealType.valueOf(tagData.toUpperCase()));
            mealsIncluded = finalMealsIncluded;
        } else if (insideBusinessVoucherTag && currentTagName.equals(Tags.getData(TAG_MEAL_TYPE))) {
            MealsIncluded finalMealsIncluded = new MealsIncluded();
            finalMealsIncluded.setAvailable(mealsIncluded.getAvailable());
            finalMealsIncluded.setMealType(MealType.valueOf(tagData.toUpperCase()));
            mealsIncluded = finalMealsIncluded;
        } else if (currentTagName.equals(Tags.getData(TAG_ROOM_TYPE))) {
            hotelCharacteristics.setRoomType(RoomType.valueOf(tagData.toUpperCase()));
            hotelCharacteristics.setMealsIncluded(mealsIncluded);
            currentVoucher.setHotelCharacteristics(hotelCharacteristics);
        } else if (currentTagName.equals(Tags.getData(TAG_COST))) {
            currentVoucher.setCost(Integer.parseInt(tagData));
        }
    }
}
