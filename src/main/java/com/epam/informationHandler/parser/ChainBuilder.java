package com.epam.informationHandler.parser;

public class ChainBuilder {

    public Parser build() {
        //TODO add WordParser class
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
