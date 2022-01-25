package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;

public class TextParser extends AbstractParser {

    private static final String REGEX_FOR_PARAGRAPH = "\\n\\t";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        return parseByTemplate(text, REGEX_FOR_PARAGRAPH);
    }
}
