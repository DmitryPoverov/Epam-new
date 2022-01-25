package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;

public class ParagraphParser extends AbstractParser {

    public static final String REGEX_FOR_SENTENCE_DELIMITER = "(?<=[\\.?!]){3}[\\n\\s]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        return parseByTemplate(text, REGEX_FOR_SENTENCE_DELIMITER);
    }
}
