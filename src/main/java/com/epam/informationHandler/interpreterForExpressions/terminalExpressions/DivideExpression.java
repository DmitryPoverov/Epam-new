package com.epam.informationHandler.interpreterForExpressions.terminalExpressions;

import com.epam.informationHandler.interpreterForExpressions.MathExpression;
import com.epam.informationHandler.interpreterForExpressions.ContextWrapper;

public class DivideExpression extends MathExpression {
    @Override
    public void interpret(ContextWrapper context) {
        context.addToQueueValue(context.getAndDeleteValue() / context.getAndDeleteValue());
    }
}
