package com.epam.informationHandler.expressionCalculateOperation.terminalExpressions;

import com.epam.informationHandler.expressionCalculateOperation.AbstractMathExpression;
import com.epam.informationHandler.expressionCalculateOperation.Context;

public class DivideExpression extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() / context.popValue());
    }
}
