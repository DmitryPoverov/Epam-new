package com.epam.informationHandler.expressionCalculateOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {

    private static final String REGEXP = "\\p{Blank}+";

    private final List<AbstractMathExpression> listExpressions;

    public ExpressionCalculator(String expression) {
        this.listExpressions = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(REGEXP)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpressions.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpressions.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpressions.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpressions.add(new NonTerminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }
    public Integer calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
