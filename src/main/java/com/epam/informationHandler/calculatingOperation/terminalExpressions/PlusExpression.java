package com.epam.informationHandler.calculatingOperation.terminalExpressions;

import com.epam.informationHandler.calculatingOperation.AbstractMathExpression;
import com.epam.informationHandler.calculatingOperation.Context;

public class PlusExpression extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
