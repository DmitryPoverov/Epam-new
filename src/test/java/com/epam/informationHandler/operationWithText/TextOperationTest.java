package com.epam.informationHandler.operationWithText;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextOperationTest {

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

    private static final Component COMPOSITE_WHOLE_TEXT =
            new Composite(Arrays.asList(COMPOSITE_PARAGRAPH_ONE, COMPOSITE_PARAGRAPH_TWO, COMPOSITE_PARAGRAPH_THREE));

    @Test
    public void testSortBySentencesQuantityShouldSortSentences() {
        //given
        //when
        //then
    }

    @Test
    public void testSortWordsInSentenceByLongShouldSortWords() {
        //given
        //when
        //then
    }

    @Test
    public void testRestoreTextFromComponentShouldReturnRestoredText() {
        //given
        //when
        //then
    }
}
