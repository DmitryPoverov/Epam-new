package com.epam.task2.geometry.director;

import org.junit.Assert;
import org.junit.Test;

public class ConeValidatorTest {

    private static final String VALID_DATA = "1 2 3 4 5";
    private static final String INVALID_DATA = "1 2 3 0 -1";

    @Test
    public void testIsAValidShouldReturnTrueWhenConeIsValid() {
        //given
        ConeValidator coneValidator = new ConeValidator();
        //when
        boolean isValid = coneValidator.isValid(VALID_DATA);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsAValidShouldReturnFalseWhenConeIsNotValid() {
        //given
        ConeValidator coneValidator = new ConeValidator();
        //when
        boolean isValid = coneValidator.isValid(INVALID_DATA);
        //then
        Assert.assertFalse(isValid);
    }

}
