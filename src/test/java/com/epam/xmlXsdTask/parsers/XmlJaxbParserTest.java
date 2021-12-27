package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class XmlJaxbParserTest {

    private static final String VALID_PATH = "src/main/resources/vouchers.xml";

    @Test
    public void TestParseShouldParseFileWhenPathIsValid() throws ParserException {
        //given
        FamilyVoucher familyVoucher = new FamilyVoucher();
        familyVoucher.setId(1);
        familyVoucher.setType(Type.WEEKEND);
        familyVoucher.setCountry("Mexico");
        familyVoucher.setNumberOfDays(10);
        familyVoucher.setTransport("bus");

        MealsIncluded mealsIncluded = new MealsIncluded();
        mealsIncluded.setAvailable(true);
        mealsIncluded.setMealType(MealType.AI);

        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
        hotelCharacteristics.setNumOfStars(5);
        hotelCharacteristics.setMealsIncluded(mealsIncluded);
        hotelCharacteristics.setRoomType(RoomType.TRIPLE);

        familyVoucher.setHotelCharacteristics(hotelCharacteristics);
        familyVoucher.setCost(500);
        familyVoucher.setNumOfFamilyMembers(3);

        BusinessVoucher businessVoucher = new BusinessVoucher();
        businessVoucher.setId(2);
        businessVoucher.setType(Type.BUSINESS);
        businessVoucher.setCountry("USA");
        businessVoucher.setNumberOfDays(2);
        businessVoucher.setTransport("airplane");

        MealsIncluded mealsIncluded1 = new MealsIncluded();
        mealsIncluded1.setAvailable(true);
        mealsIncluded1.setMealType(MealType.BB);

        HotelCharacteristics hotelCharacteristics1 = new HotelCharacteristics();
        hotelCharacteristics1.setNumOfStars(4);
        hotelCharacteristics1.setMealsIncluded(mealsIncluded1);
        hotelCharacteristics1.setRoomType(RoomType.DOUBLE);

        businessVoucher.setHotelCharacteristics(hotelCharacteristics1);
        businessVoucher.setCost(1000);
        businessVoucher.setNumOfMeetings(2);

        XmlSaxParser xmlSaxParser = new XmlSaxParser();
        List<Voucher> expected = Arrays.asList(familyVoucher, businessVoucher);
        //when
        List<Voucher> actual = xmlSaxParser.parse(VALID_PATH);
        //then
        Assert.assertEquals(expected, actual);
    }
}

