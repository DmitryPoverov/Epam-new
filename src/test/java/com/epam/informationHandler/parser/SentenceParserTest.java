package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    private static final String SENTENCE_FOR_TEST = "Lorem [ 8 2 / ] ipsum dolor sit amet!";

    @Test
    public void testSentenceParseShouldParseSentenceWithExpression() {
        //given
        Component expected = new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.expression("[ 8 2 / ]"),
                Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit"), Lexeme.word("amet!")));
        SentenceParser sentenceParser = new SentenceParser();
        //when
        Component actualSentenceComposite = sentenceParser.parse(SENTENCE_FOR_TEST);
        //then
        Assert.assertEquals(expected, actualSentenceComposite);
    }
}
