package com.epam.task1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final double DELTA = 0.00000001;


    @Test
    public void testShouldAddAndReturnEightWhenSixAndTwo() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.add(6, 2);
        //then
        Assert.assertEquals(result, 8, DELTA);
    }

    @Test
    public void testShouldAddAndReturnMinusThreeWhenMinusThreeAndMinusTwo() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.add(-3, -2);
        //then
        Assert.assertEquals(result, -5, DELTA);
    }

    @Test
    public void testShouldSubtractAndReturnOneWhenThreeAndTwo() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.subtract(3, 2);
        //then
        Assert.assertEquals(result, 1, DELTA);
    }

    @Test
    public void testShouldSubtractAndReturnOneWhenThirteenAndTen() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.subtract(13, 10);
        //then
        Assert.assertEquals(result, 3, DELTA);
    }

    @Test
    public void testShouldMultiplyAndReturnSixWhenTwoAndThree() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.multiply(2, 3);
        //then
        Assert.assertEquals(result, 6, DELTA);
    }

    @Test
    public void testShouldMultiplyAndReturnSixteenWhenTwoAndEight() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.multiply(2, 8);
        //then
        Assert.assertEquals(result, 16, DELTA);
    }

    @Test
    public void testShouldDivideWhenInputIsCorrectAndReturnFiveWhenTenAndTwo() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.divide(10, 2);
        //then
        Assert.assertEquals(result, 5, DELTA);
    }

    @Test
    public void testShouldDivideWhenInputIsCorrectAndReturnMinusThreeWhenTwelveAndMinusFour() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.divide(-12, 4);
        //then
        Assert.assertEquals(result, -3, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenSecondOperandIs0() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.divide(4, 0);
        //then
        //I don't know what's the "then" here.
    }
}