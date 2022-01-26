package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;

public class SentenceParser extends AbstractParser {

    private static final String REGEX_FOR_LEXEME = "\\s(?=\\[)|(?<=])\\s";
    private static final String REGEX_FOR_WORDS = "\\s";

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] lexemes = text.split(REGEX_FOR_LEXEME);
        for (String lexeme : lexemes) {
            if (lexeme.contains("[")) {
                composite.add(Lexeme.expression(lexeme));
            } else {
                String[] splitWords = lexeme.split(REGEX_FOR_WORDS);
                for (String word : splitWords) {
                    composite.add(Lexeme.word(word));
                }
            }
        }
        return composite;
    }
}
