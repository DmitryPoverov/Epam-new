package com.epam.task1Calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final double DELTA = 0.00000001;

    @Test
    public void testShouldAddWhenSixAndTwoThenReturnEight() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.add(6, 2);
        //then
        Assert.assertEquals(result, 8, DELTA);
    }

    @Test
    public void testShouldAddWhenMinusThreeAndMinusTwoThenReturnMinusFive() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.add(-3, -2);
        //then
        Assert.assertEquals(result, -5, DELTA);
    }

    @Test
    public void testShouldSubtractWhenThreeAndTwoThenReturnOne() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.subtract(3, 2);
        //then
        Assert.assertEquals(result, 1, DELTA);
    }

    @Test
    public void testShouldSubtractWhenThirteenAndTenThenReturnOne() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.subtract(13, 10);
        //then
        Assert.assertEquals(result, 3, DELTA);
    }

    @Test
    public void testShouldMultiplyWhenTwoAndThreeThenReturnSix() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.multiply(2, 3);
        //then
        Assert.assertEquals(result, 6, DELTA);
    }

    @Test
    public void testShouldMultiplyWhenTwoAndEightThenReturnSixteen() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.multiply(2, 8);
        //then
        Assert.assertEquals(result, 16, DELTA);
    }

    @Test
    public void testShouldDivideWhenTenAndTwoThenReturnFive() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.divide(10, 2);
        //then
        Assert.assertEquals(result, 5, DELTA);
    }

    @Test
    public void testShouldDivideWhenMinusTwelveAndFourThenReturnMinusThree() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result = calculator.divide(-12, 4);
        //then
        Assert.assertEquals(result, -3, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenSecondOperandIsZero() {
        //given
        Calculator calculator = new Calculator();
        //when
        calculator.divide(4, 0);
        //then
        //I don't know what's the "then" here.
    }
}