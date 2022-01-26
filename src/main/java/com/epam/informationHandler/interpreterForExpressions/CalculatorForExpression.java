package com.epam.informationHandler.interpreterForExpressions;

import com.epam.informationHandler.interpreterForExpressions.terminalExpressions.DivideExpression;
import com.epam.informationHandler.interpreterForExpressions.terminalExpressions.MinusExpression;
import com.epam.informationHandler.interpreterForExpressions.terminalExpressions.MultiplyExpression;
import com.epam.informationHandler.interpreterForExpressions.terminalExpressions.PlusExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorForExpression {

    private static final String REGEX_FOR_EXPRESSIONS = "\\s+";

    private final List<MathExpression> expressionList;

    public CalculatorForExpression(String expression) {
        this.expressionList = new ArrayList<>();
        parseExpression(expression);
    }

    private void parseExpression(String expression) {
        for (String lexeme : expression.split(REGEX_FOR_EXPRESSIONS)) {
            if (!lexeme.isEmpty()) {
                char tempCharacter = lexeme.charAt(0);
                switch (tempCharacter) {
                    case '+':
                        expressionList.add(new PlusExpression());
                        break;
                    case '-':
                        expressionList.add(new MinusExpression());
                        break;
                    case '*':
                        expressionList.add(new MultiplyExpression());
                        break;
                    case '/':
                        expressionList.add(new DivideExpression());
                        break;
                    default:
                        Scanner scanner = new Scanner(lexeme);
                        if (scanner.hasNextInt()) {
                            expressionList.add(new NonTerminalExpressionWithNumber(scanner.nextInt()));
                        }
                }
            }
        }
    }

    public Integer calculate() {
        ContextWrapper context = new ContextWrapper();
        for (MathExpression expression : expressionList) {
            expression.interpret(context);
        }
        return context.getAndDeleteValue();
    }
}
