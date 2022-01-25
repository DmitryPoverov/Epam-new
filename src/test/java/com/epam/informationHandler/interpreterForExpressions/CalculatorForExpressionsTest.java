package com.epam.informationHandler.interpreterForExpressions;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorForExpressionsTest {

    private static final String EXPRESSION_FOR_DIVIDING = "[ 2 8 / ]";
    private static final int ANSWER_FOR_DIVIDING = 4;
    private static final String EXPRESSION_FOR_SUBTRACTION = "[ 2 8 - ]";
    private static final int ANSWER_FOR_SUBTRACTION = 6;
    private static final String EXPRESSION_FOR_MULTIPLYING = "[ 2 8 * ]";
    private static final int ANSWER_FOR_MULTIPLYING = 16;
    private static final String EXPRESSION_FOR_ADDING = "[ 2 8 + ]";
    private static final int ANSWER_FOR_ADDING = 10;

    @Test
    public void testCalculateShouldDivideValuesFromExpression() {
        //given.
        String expression = EXPRESSION_FOR_DIVIDING;
        CalculatorForExpression calculator = new CalculatorForExpression(expression);
        Integer expected = ANSWER_FOR_DIVIDING;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldMinusValuesFromExpression() {
        //given.
        String expression = EXPRESSION_FOR_SUBTRACTION;
        CalculatorForExpression calculator = new CalculatorForExpression(expression);
        Integer expected = ANSWER_FOR_SUBTRACTION;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldMultiplyValues() {
        //given.
        String expression = EXPRESSION_FOR_MULTIPLYING;
        CalculatorForExpression calculator = new CalculatorForExpression(expression);
        Integer expected = ANSWER_FOR_MULTIPLYING;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldAddValuesFromExpression() {
        //given.
        String expression = EXPRESSION_FOR_ADDING;
        CalculatorForExpression calculator = new CalculatorForExpression(expression);
        Integer expected = ANSWER_FOR_ADDING;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }
}
