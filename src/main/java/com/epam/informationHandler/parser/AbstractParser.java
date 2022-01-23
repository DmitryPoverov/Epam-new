package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    public AbstractParser() {
        successor = null;
    }
    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected Composite parseByTemplate(String text, String regExDelimiter) {
        Composite result = new Composite();
        String[] parsedText = text.split(regExDelimiter);
        for (String textElement : parsedText) {
            Component textPart = getSuccessor().parse(textElement);
            result.add(textPart);
        }
        return result;
    }
}
