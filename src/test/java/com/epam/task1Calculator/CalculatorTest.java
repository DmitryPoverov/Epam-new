package com.epam.task1Calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculatorGlobal;
    private static final double DELTA = 0;

    @Before
    public void beforeTestInitialisation() {
        calculatorGlobal = new Calculator();
    }

    @Test
    public void testShouldAddWhenSixAndTwoThenReturnEight() {
        //given
        //this is а full writing of "given" block, without of @before method.
        Calculator calculatorLocal = new Calculator();
        int firstOperand = 6;
        int secondOperand = 2;
        //when
        double result = calculatorLocal.add(firstOperand, secondOperand);
        //then
        Assert.assertEquals(result, 8, DELTA);
    }

    @Test
    public void testShouldAddWhenMinusThreeAndMinusTwoThenReturnMinusFive() {
        //given
        //this is also a full writing of "given" block, without the @before method.
        Calculator calculatorLocal = new Calculator();
        int firstOperand = -3;
        int secondOperand = -2;
        //when
        double result = calculatorLocal.add(firstOperand, secondOperand);
        //then
        Assert.assertEquals(result, -5, DELTA);
    }

    @Test
    public void testShouldSubtractWhenThreeAndTwoThenReturnOne() {
        //given
        //this is a shorter writing of "given" block, calculatorGlobal was initialized here, without the @before method.
        calculatorGlobal = new Calculator();
        //when
        double result = calculatorGlobal.subtract(3, 2);
        //then
        Assert.assertEquals(result, 1, DELTA);
    }

    @Test
    public void testShouldSubtractWhenThirteenAndTenThenReturnOne() {
        //given
        //this is also a shorter writing of "given" block, calculatorGlobal was initialized here, without the @before method.
        calculatorGlobal = new Calculator();
        //when
        double result = calculatorGlobal.subtract(13, 10);
        //then
        Assert.assertEquals(result, 3, DELTA);
    }

    @Test
    public void testShouldMultiplyWhenTwoAndThreeThenReturnSix() {
        //given
        //this is the shortest writing of "given" block, calculatorGlobal was initialized in the @before method.
        //when
        double result = calculatorGlobal.multiply(2, 3);
        //then
        Assert.assertEquals(result, 6, DELTA);
    }

    @Test
    public void testShouldMultiplyWhenTwoAndEightThenReturnSixteen() {
        //given
        //this is also the shortest writing of "given" block, calculatorGlobal was initialized in the @before method.
        //when
        double result = calculatorGlobal.multiply(2, 8);
        //then
        Assert.assertEquals(result, 16, DELTA);
    }

    @Test
    public void testShouldDivideWhenTenAndTwoThenReturnFive() {
        //given
        //this is also the shortest writing of "given" block, calculatorGlobal was initialized in the @before method.
        //when
        double result = calculatorGlobal.divide(10, 2);
        //then
        Assert.assertEquals(result, 5, DELTA);
    }

    @Test
    public void testShouldDivideWhenMinusTwelveAndFourThenReturnMinusThree() {
        //given
        //this is also the shortest writing of "given" block, calculatorGlobal was initialized in the @before method.
        //when
        double result = calculatorGlobal.divide(-12, 4);
        //then
        Assert.assertEquals(result, -3, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenSecondOperandIsZero() {
        //given
        //this is also the shortest writing of "given" block, calculatorGlobal was initialized in the @before method.
        //when
        calculatorGlobal.divide(4, 0);
        //then
        //I don't know what's the "then" here.
    }
}