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

public class XmlDomParserTest {

    private static final String VALID_PATH = "src/main/resources/vouchers.xml";

    @Test
    public void TestParseShouldParseFileWhenPathIsValid() throws ParserException {
        //given
        MealsIncluded mealsFV = new MealsIncluded(true, MealType.AI);
        HotelCharacteristics charactersFV = new HotelCharacteristics(5, mealsFV, RoomType.TRIPLE);
        FamilyVoucher familyVoucher = new FamilyVoucher(1, Type.WEEKEND, "Mexico", 10, "bus", charactersFV, 500, 3);

        MealsIncluded mealsBV = new MealsIncluded(true, MealType.BB);
        HotelCharacteristics charactersBV = new HotelCharacteristics(4, mealsBV, RoomType.DOUBLE);
        BusinessVoucher businessVoucher = new BusinessVoucher(2, Type.BUSINESS, "USA", 2, "airplane", charactersBV, 1000, 2);

        XmlDomParser xmlDomParser = new XmlDomParser();
        List<Voucher> expected = Arrays.asList(familyVoucher, businessVoucher);
        //when
        List<Voucher> actual = xmlDomParser.parse(VALID_PATH);
        //then
        Assert.assertEquals(expected, actual);



    }
}