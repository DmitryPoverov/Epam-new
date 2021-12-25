package com.epam.xmlXsdTask.handler;

import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import com.epam.xmlXsdTask.entities.associatedClasses.tags.Tags;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.tags.Tags.*;

public class SaxParserHandler extends DefaultHandler {

    private final List<Voucher> vouchers = new ArrayList<>();
    private final HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
    private final MealsIncluded mealsIncluded = new MealsIncluded();
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
            if (currentTagName.equals(Tags.getData(TAG_FAMILY_VOUCHER))) {
                currentVoucher = new FamilyVoucher();
                currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
                insideFamilyVoucherTag = true;
            } else if (currentTagName.equals(getData(TAG_BUSINESS_VOUCHER))) {
                currentVoucher = new BusinessVoucher();
                currentVoucher.setId(Integer.parseInt(attributes.getValue("id")));
                insideBusinessVoucherTag = true;
            } else if (currentTagName.equals(getData(TAG_MEALS_INCLUDED))) {
                mealsIncluded.setAvailable(Boolean.parseBoolean(attributes.getValue("available")));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        String data = new String(ch, start, length);

        if (currentTagName != null) {
            processingCommonTags(currentTagName, data);

            if (insideFamilyVoucherTag) {
                FamilyVoucher familyVoucher = (FamilyVoucher) currentVoucher;
                if (currentTagName.equals(getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
                    familyVoucher.setNumOfFamilyMembers(Integer.parseInt(data));
                }
            } else if (insideBusinessVoucherTag) {
                BusinessVoucher businessVoucher = (BusinessVoucher) currentVoucher;
                if (currentTagName.equals(getData(TAG_NUMBER_OF_MEETINGS))) {
                    businessVoucher.setNumOfMeetings(Integer.parseInt(data));
                }
            }
        }
    }

    private void processingCommonTags(String currentTagName, String data) {

        if (currentTagName.equals(getData(TAG_TYPE))) {
            currentVoucher.setType(Type.valueOf(data.toUpperCase()));
        } else if (currentTagName.equals(getData(TAG_COUNTRY))) {
            currentVoucher.setCountry(data);
        } else if (currentTagName.equals(getData(TAG_NUMBER_OF_DAYS))) {
            currentVoucher.setNumberOfDays(Integer.parseInt(data));
        } else if (currentTagName.equals(getData(TAG_TRANSPORT))) {
            currentVoucher.setTransport(data);
        } else if (currentTagName.equals(getData(TAG_NUMBER_OF_STARS))) {
            hotelCharacteristics.setNumOfStars(Integer.parseInt(data));
        } else if (currentTagName.equals(getData(TAG_MEAL_TYPE))) {
            mealsIncluded.setMealType(MealType.valueOf(data.toUpperCase()));
            hotelCharacteristics.setMealsIncluded(mealsIncluded);
        } else if (currentTagName.equals(getData(TAG_ROOM_TYPE))) {
            hotelCharacteristics.setRoomType(RoomType.valueOf(data.toUpperCase()));
        } else if (!currentTagName.equals(getData(TAG_TOURIST_VOUCHERS))) {
            currentVoucher.setHotelCharacteristics(hotelCharacteristics);
        } else if (currentTagName.equals(getData(TAG_COST))) {
            currentVoucher.setCost(Integer.parseInt(data));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName != null) {
            if (qName.equals(getData(TAG_FAMILY_VOUCHER))) {
                insideFamilyVoucherTag = false;
                vouchers.add(currentVoucher);
            } else if (qName.equals(getData(TAG_BUSINESS_VOUCHER))) {
                insideBusinessVoucherTag = false;
                vouchers.add(currentVoucher);
            }
            currentTagName = null;
        }
    }
}
