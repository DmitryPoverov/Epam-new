package com.epam.xmlXsdTask.handler;

import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.TouristVouchers;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import com.epam.xmlXsdTask.entities.associatedClasses.tags.Tags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.tags.Tags.*;

public class SaxParserHandler extends DefaultHandler {

    private boolean isFamilyVoucher;
    private boolean isBusinessVoucher;
    private TouristVouchers touristVouchers = new TouristVouchers();
    private FamilyVoucher familyVoucher = new FamilyVoucher();
    private BusinessVoucher businessVoucher = new BusinessVoucher();
    private String currentTagName; // хранит текущий тег, чтобы знать в каком теге мы сейчас
    private List<Voucher> vouchers = new ArrayList<>();
    HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
    MealsIncluded mealsIncluded = new MealsIncluded();

    public TouristVouchers getTouristVouchers() {
        return touristVouchers;
    }

    @Override
    public void startDocument() throws SAXException {
        //System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;

        if (currentTagName == null) {
            return;
        }
        if (currentTagName.equals(Tags.getData(TAG_FAMILY_VOUCHER))) {
            familyVoucher.setId(Integer.parseInt(attributes.getValue("id")));
            System.out.println(familyVoucher.getId());
            isFamilyVoucher = true;

        } else if (currentTagName.equals(Tags.getData(TAG_BUSINESS_VOUCHER))) {
            businessVoucher.setId(Integer.parseInt(attributes.getValue("id")));
            System.out.println(businessVoucher.getId());
            isBusinessVoucher = true;
        }
        if (currentTagName.equals(Tags.getData(TAG_MEALS_INCLUDED))) {
            mealsIncluded.setAvailable(Boolean.parseBoolean(attributes.getValue("available")));
            hotelCharacteristics.setMealsIncluded(mealsIncluded);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTagName == null) {
            return;
        }
        if (currentTagName.equals(Tags.getData(TAG_FAMILY_VOUCHER))) {
            isFamilyVoucher = false;
        } else if (currentTagName.equals(Tags.getData(TAG_BUSINESS_VOUCHER))){
            isBusinessVoucher = false;
        }
        currentTagName = null;
    }

    // дает содержимое тега, вызывается для всех элементов
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) {
            return;
        }
        if (isFamilyVoucher) {
            if (currentTagName.equals(Tags.getData(TAG_TYPE))) {
                familyVoucher.setType(Type.valueOf(new String(ch, start, length)));
            }
            if (currentTagName.equals(Tags.getData(TAG_COUNTRY))) {
                familyVoucher.setCountry(new String(ch, start, length));
            }
            if (currentTagName.equals(Tags.getData(TAG_NUMBER_OF_DAYS))) {
                familyVoucher.setNumberOfDays(Integer.parseInt(new String(ch, start, length)));
            }
            if (currentTagName.equals(getData(TAG_TRANSPORT))) {
                familyVoucher.setTransport(new String(ch, start, length));
            }
            if (currentTagName.equals(Tags.getData(TAG_HOTEL_CHARACTERISTICS))) {
                if (currentTagName.equals(Tags.getData(TAG_NUMBER_OF_STARS))) {
                    hotelCharacteristics.setNumOfStars(Integer.parseInt(new String(ch, start, length)));
                }
                if (currentTagName.equals(Tags.getData(TAG_MEAL_TYPE))) {
                    mealsIncluded.setMealType(MealType.valueOf(new String(ch, start, length)));
                    hotelCharacteristics.setMealsIncluded(mealsIncluded);
                }
                if (currentTagName.equals(Tags.getData(TAG_ROOM_TYPE))) {
                    hotelCharacteristics.setRoomType(RoomType.valueOf(new String(ch, start, length)));
                }
                familyVoucher.setHotelCharacteristics(hotelCharacteristics);
                hotelCharacteristics = new HotelCharacteristics();
            }
            if (currentTagName.equals(Tags.getData(TAG_COST))) {
                familyVoucher.setCost(Integer.parseInt(new String(ch, start, length)));
            }
            if (currentTagName.equals((Tags.getData(TAG_NUMBER_OF_FAMILY_MEMBERS)))) {
                familyVoucher.setNumOfFamilyMembers(Integer.parseInt(new String(ch, start, length)));
            }
        } else if (isBusinessVoucher) {
            if (currentTagName.equals(Tags.getData(TAG_BUSINESS_VOUCHER))) {

            }
        }
    }
}
