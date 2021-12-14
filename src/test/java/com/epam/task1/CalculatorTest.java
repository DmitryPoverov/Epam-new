package com.epam.task1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final double DELTA = 0.00000001;
    private Calculator calculator = new Calculator();

    @Test
    public void shouldAddAndReturnThreeWhenOneAndTwo() {
        double result = calculator.add(1, 2);
        Assert.assertEquals(result, 3, DELTA);
    }

    @Test
    public void shouldAddAndReturnEightWhenSixAndTwo() {
        double result = calculator.add(6, 2);
        Assert.assertEquals(result, 8, DELTA);
    }

    @Test
    public void shouldAddAndReturnMinusThreeWhenMinusOneAndMinusTwo() {
        double result = calculator.add(-1, -2);
        Assert.assertEquals(result, -3, DELTA);
    }
    @Test
    public void shouldAddAndReturnMinusThreeWhenMinusThreeAndMinusTwo() {
        double result = calculator.add(-3, -2);
        Assert.assertEquals(result, -5, DELTA);
    }

    @Test
    public void shouldSubtractAndReturnOneWhenThreeAndTwo() {
        double result = calculator.subtract(3, 2);
        Assert.assertEquals(result, 1, DELTA);
    }

    @Test
    public void shouldSubtractAndReturnOneWhenThirteenAndTen() {
        double result = calculator.subtract(13, 10);
        Assert.assertEquals(result, 3, DELTA);
    }

    @Test
    public void shouldMultiplyAndReturnSixWhenTwoAndThree() {
        double result = calculator.multiply(2, 3);
        Assert.assertEquals(result, 6, DELTA);
    }

    @Test
    public void shouldMultiplyAndReturnSixteenWhenTwoAndEight() {
        double result = calculator.multiply(2, 8);
        Assert.assertEquals(result, 16, DELTA);
    }

    @Test
    public void shouldDivideWhenInputIsCorrectAndReturnFiveWhenTenAndTwo() {
        double result = calculator.divide(10, 2);
        Assert.assertEquals(result, 5, DELTA);
    }

    @Test
    public void shouldDivideWhenInputIsCorrectAndReturnMinusThreeWhenTwelveAndMinusFour() {
        double result = calculator.divide(-12, 4);
        Assert.assertEquals(result, -3, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSecondIs0() {
        double result = calculator.divide(4, 0);
    }
}