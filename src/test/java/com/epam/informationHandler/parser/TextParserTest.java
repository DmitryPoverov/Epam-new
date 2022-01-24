package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class TextParserTest {

    private static final String PARAGRAPH_ONE = "Lorem [ 8 2 / ] ipsum. Dolor sit amet!";
    private static final String PARAGRAPH_TWO = "Aenean [ 8 2 + ] ligula.";
    private static final String PARAGRAPH_THREE = "Nulla consequat. Massa quis. Enim.";

    private static final String WHOLE_TEXT = PARAGRAPH_ONE + "\n\t" + PARAGRAPH_TWO + "\n\t" + PARAGRAPH_THREE + "\n\t";

    private static final Composite COMPOSITE_SENTENCE_ONE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.expression("[ 8 2 / ]"), Lexeme.word("ipsum.")));
    private static final Composite COMPOSITE_SENTENCE_TWO =
            new Composite(Arrays.asList(Lexeme.word("Dolor"), Lexeme.word("sit"), Lexeme.word("amet!")));
    private static final Composite COMPOSITE_SENTENCE_THREE =
            new Composite(Arrays.asList(Lexeme.word("Aenean"), Lexeme.expression("[ 8 2 + ]"), Lexeme.word("ligula.")));
    private static final Composite COMPOSITE_SENTENCE_FOUR =
            new Composite(Arrays.asList(Lexeme.word("Nulla"), Lexeme.word("consequat")));
    private static final Composite COMPOSITE_SENTENCE_FIVE =
            new Composite(Arrays.asList(Lexeme.word("Massa"), Lexeme.word("quis.")));
    private static final Composite COMPOSITE_SENTENCE_SIX =
            new Composite(Collections.singletonList(Lexeme.word("Enim.")));

    private static final Composite COMPOSITE_PARAGRAPH_ONE =
            new Composite(Arrays.asList(COMPOSITE_SENTENCE_ONE, COMPOSITE_SENTENCE_TWO));
    private static final Composite COMPOSITE_PARAGRAPH_TWO =
            new Composite(Collections.singletonList(COMPOSITE_SENTENCE_THREE));
    private static final Composite COMPOSITE_PARAGRAPH_THREE =
            new Composite(Arrays.asList(COMPOSITE_SENTENCE_FOUR, COMPOSITE_SENTENCE_FIVE, COMPOSITE_SENTENCE_SIX));

    private static final Composite COMPOSITE_WHOLE_TEXT =
            new Composite(Arrays.asList(COMPOSITE_PARAGRAPH_ONE, COMPOSITE_PARAGRAPH_TWO, COMPOSITE_PARAGRAPH_THREE));

    @Test
    public void testTextParserShouldParseTextWhenTextGiven() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(PARAGRAPH_ONE))
                .thenReturn(COMPOSITE_PARAGRAPH_ONE);
        Mockito.when(paragraphParser.parse(PARAGRAPH_TWO))
                .thenReturn(COMPOSITE_PARAGRAPH_TWO);
        Mockito.when(paragraphParser.parse(PARAGRAPH_THREE))
                .thenReturn(COMPOSITE_PARAGRAPH_THREE);

        TextParser textParser = new TextParser(paragraphParser);

        //when
        Composite actualCompositeWholeText = (Composite) textParser.parse(WHOLE_TEXT);

        //then
        Assert.assertEquals(COMPOSITE_WHOLE_TEXT, actualCompositeWholeText);
        Mockito.verify(paragraphParser, Mockito.times(1))
                .parse(PARAGRAPH_ONE);
        Mockito.verify(paragraphParser, Mockito.times(1))
                .parse(PARAGRAPH_TWO);
        Mockito.verify(paragraphParser, Mockito.times(1))
                .parse(PARAGRAPH_THREE);
        Mockito.verifyNoMoreInteractions(paragraphParser);
    }

}
