package com.epam.informationHandler.calculatingOperation;

public class NonTerminalExpression extends AbstractMathExpression {

    private int number;

    public NonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
