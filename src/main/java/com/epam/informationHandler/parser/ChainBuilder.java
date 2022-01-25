package com.epam.informationHandler.parser;

public class ChainBuilder {

    public Parser build() {
        //TODO add SentenceParser class
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
