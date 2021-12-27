package com.epam.xmlXsdTask.validator;

import com.epam.xmlXsdTask.exceptoin.ParserException;
import org.junit.Assert;
import org.junit.Test;

public class VouchersValidatorTest {
    private static final String VALID_XML_FILE = "src/main/resources/vouchers.xml";
    private static final String VALID_XSD_FILE = "src/main/resources/vouchersSchema.xsd";
    private static final String INVALID_XML_FILE = "src/main/resources/vouchersInvalid.xml";
    private static final String EMPTY_PATH = "";

    @Test
    public void testIsValidShouldReturnTrueWhenFileIsValid() throws ParserException {
        //given
        VouchersValidator validator = new VouchersValidator();
        //when
        boolean actual = validator.isValid(VALID_XML_FILE, VALID_XSD_FILE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFileIsNotValid() throws ParserException {
        //given
        VouchersValidator validator = new VouchersValidator();
        //when
        boolean actual = validator.isValid(INVALID_XML_FILE, VALID_XSD_FILE);
        //then
        Assert.assertFalse(actual);
    }

    //then
    @Test(expected = ParserException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsEmpty() throws ParserException {
        //given
        VouchersValidator validator = new VouchersValidator();
        //when
        boolean actual = validator.isValid(EMPTY_PATH, EMPTY_PATH);
    }

    //then
    @Test(expected = ParserException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsNull() throws ParserException {
        //given
        VouchersValidator validator = new VouchersValidator();
        //when
        boolean actual = validator.isValid(null, null);
    }
}

