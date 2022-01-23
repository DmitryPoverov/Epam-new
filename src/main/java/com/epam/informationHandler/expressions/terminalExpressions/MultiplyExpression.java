package com.epam.informationHandler.expressions.terminalExpressions;

import com.epam.informationHandler.expressions.MathExpression;
import com.epam.informationHandler.expressions.ContextWrapper;

public class MultiplyExpression extends MathExpression {
    @Override
    public void interpret(ContextWrapper context) {
        context.addToQueueValue(context.getAndDeleteValue() * context.getAndDeleteValue());
    }
}
