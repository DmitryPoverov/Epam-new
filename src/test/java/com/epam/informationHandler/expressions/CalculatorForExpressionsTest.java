package com.epam.informationHandler.expressions;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorForExpressionsTest {

    private static final String EXPRESSION_FOR_DIVIDING = "[ 2 8 / ]";
    private static final int ANSWER_FOR_DIVIDING = 4;
    private static final String EXPRESSION_FOR_SUBTRACTION = "[ 2 8 - ]";
    private static final int ANSWER_FOR_SUBTRACTION = 6;
    private static final String EXPRESSION_FOR_MULTIPLYING = "[ 2 8 * ]";
    private static final int ANSWER_FOR_MULTIPLYING = 16;
    private static final String EXPRESSION_FOR_ADDITION = "[ 2 8 + ]";
    private static final int ANSWER_FOR_ADDITION = 10;



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
    public void testCalculateShouldMultiplyValuesFromExpression() {
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
        String expression = EXPRESSION_FOR_ADDITION;
        CalculatorForExpression calculator = new CalculatorForExpression(expression);
        Integer expected = ANSWER_FOR_ADDITION;
        //when
        Integer actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }
}
