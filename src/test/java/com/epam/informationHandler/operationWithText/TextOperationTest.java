package com.epam.informationHandler.operationWithText;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;
import com.epam.informationHandler.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void testSortBySentencesQuantityShouldSortSentences() throws TextException {
        //given

        List<Component> expectedText =
                Arrays.asList(FOURTH_PARAGRAPH_COMPOSITE, THIRD_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE, FIRST_PARAGRAPH_COMPOSITE);
        //when
        List<Component> actual = SERVICE.sortBySentencesQuantity(testText);
        //then
        Assert.assertEquals(expectedText, actual);
    }

    @Test
    public void testSortWordsInSentenceByLongShouldSortWords() throws TextException {
        //given
        Component testSentence = new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos")));
        List<Component> expectedSentence = Arrays.asList(Lexeme.word("At"), Lexeme.word("eos"), Lexeme.word("vero"));
        //when
        List<Component> actual = SERVICE.sortWordsInSentenceByLong(testSentence);
        //then
        Assert.assertEquals(expectedSentence, actual);
    }

    @Test
    public void testRestoreTextFromComponentShouldReturnRestoredText() throws TextException {
        //given
        Component testText = new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit")));
        String expected = "Lorem ipsum dolor sit";
        //when
        String actual = SERVICE.restoreTextFromComponent(testText);
        //then
        Assert.assertEquals(expected, actual);
    }
}
