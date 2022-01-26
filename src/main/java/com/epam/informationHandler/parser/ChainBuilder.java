package com.epam.informationHandler.parser;

public class ChainBuilder {

    public Parser build() {

        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
