package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class ParagraphParserTest {

    private static final String WHOLE_PARAGRAPH = "Lorem [ 8 2 / ] ipsum. Dolor sit amet!";
    private static final String SENTENCE_ONE = "Lorem [ 8 2 / ] ipsum.";
    private static final String SENTENCE_TWO = "Dolor sit amet!";

    private static final Composite COMPOSITE_SENTENCE_ONE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.expression("[ 8 2 / ]"), Lexeme.word("ipsum.")));
    private static final Composite COMPOSITE_SENTENCE_TWO =
            new Composite(Arrays.asList(Lexeme.word("Dolor"), Lexeme.word("sit"), Lexeme.word("amet!")));

    private static final Component COMPOSITE_WHOLE_PARAGRAPH =
            new Composite(new ArrayList<>(Arrays.asList(COMPOSITE_SENTENCE_ONE, COMPOSITE_SENTENCE_TWO)));

    @Test
    public void testParagraphParserShouldParseParagraphWhenParagraphGiven() {
        // given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);

        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        Mockito.when(sentenceParser.parse(SENTENCE_ONE))
                .thenReturn(COMPOSITE_SENTENCE_ONE);
        Mockito.when(sentenceParser.parse(SENTENCE_TWO))
                .thenReturn(COMPOSITE_SENTENCE_TWO);

        // when
        Composite actualParagraphComposite = (Composite) paragraphParser.parse(WHOLE_PARAGRAPH);

        // then
        Assert.assertEquals(COMPOSITE_WHOLE_PARAGRAPH, actualParagraphComposite);
        Mockito.verify(sentenceParser, Mockito.times(1))
                .parse(SENTENCE_ONE);
        Mockito.verify(sentenceParser, Mockito.times(1))
                .parse(SENTENCE_TWO);
        Mockito.verifyNoMoreInteractions(sentenceParser);
    }
}
