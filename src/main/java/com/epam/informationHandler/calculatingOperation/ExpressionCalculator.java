package com.epam.informationHandler.calculatingOperation;

import com.epam.informationHandler.calculatingOperation.terminalExpressions.DivideExpression;
import com.epam.informationHandler.calculatingOperation.terminalExpressions.MinusExpression;
import com.epam.informationHandler.calculatingOperation.terminalExpressions.MultiplyExpression;
import com.epam.informationHandler.calculatingOperation.terminalExpressions.PlusExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {

    private static final String REGEX_FOR_EXPRESSIONS = "\\p{Blank}+";

    private final List<AbstractMathExpression> expressionList;

    public ExpressionCalculator(String expression) {
        this.expressionList = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(REGEX_FOR_EXPRESSIONS)) {
            if (lexeme.isEmpty()) {
                continue;
            }
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
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        expressionList.add(new NonTerminalExpression(scan.nextInt()));
                    }
            }
        }
    }

    public Integer calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : expressionList) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
