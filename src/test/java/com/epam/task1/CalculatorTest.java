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
    public void shouldAddAndReturnMinusThreeWhenMinusOneAndMinusTwo() {
        double result = calculator.add(-1, -2);
        Assert.assertEquals(result, -3, DELTA);
    }

    @Test
    public void shouldSubtractAndReturnOneWhenThreeAndTwo() {
        double result = calculator.subtract(3, 2);
        Assert.assertEquals(result, 1, DELTA);
    }

    @Test
    public void shouldDivideWhenInputIsCorrect() {
        double result = calculator.divide(10, 2);
        Assert.assertEquals(result, 5, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSecondIs0() {
        double result = calculator.divide(4, 0);
    }
}