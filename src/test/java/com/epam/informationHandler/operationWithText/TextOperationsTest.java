package com.epam.informationHandler.operationWithText;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;
import com.epam.informationHandler.operationsWithText.TextOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextOperationsTest {

    private static final Composite COMPOSITE_SENTENCE_ONE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum.")));
    private static final Composite COMPOSITE_SENTENCE_TWO =
            new Composite(Arrays.asList(Lexeme.word("Dolor"), Lexeme.word("sit"), Lexeme.word("amet!")));
    private static final Composite COMPOSITE_SENTENCE_THREE =
            new Composite(Arrays.asList(Lexeme.word("Aenean"), Lexeme.word("ligula.")));
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
    public void testSortParagraphBySentencesQuantityShouldSortSentences() {
        //given
        List<Component> expected = Arrays.asList(COMPOSITE_PARAGRAPH_TWO, COMPOSITE_PARAGRAPH_ONE, COMPOSITE_PARAGRAPH_THREE);
        //when
        List<Component> actual= TextOperations.sortParagraphBySentencesQuantity(COMPOSITE_WHOLE_TEXT);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsInSentenceByWordLengthShouldSortWords() {
        //given
        List<Component> expected = Arrays.asList(Lexeme.word("sit"), Lexeme.word("amet!"), Lexeme.word("Dolor"));
        //when
        List<Component> actual = TextOperations.sortWordsInSentenceByWordLength(COMPOSITE_SENTENCE_TWO);
        //then
    }

    @Test
    public void testRestoreStartTextShouldReturnRestoredText() {
        //given
        String expected = "Dolor sit amet!";
        //when
        String actual = TextOperations.restoreStartText(COMPOSITE_SENTENCE_TWO);
        //then
        Assert.assertEquals(expected, actual);
    }
}
