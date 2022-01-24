package com.epam.informationHandler.operationsWithText;

import com.epam.informationHandler.comparator.ComparatorForComponents;
import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextOperations {

    public static List<Component> sortParagraphBySentencesQuantity(Component text) {
        List<Component> listOfParagraphs = text.getTextParts().stream()
                .map(Composite.class::cast)
                .sorted(new ComparatorForComponents())
                .collect(Collectors.toList());
        return listOfParagraphs;
    }

    public static List<Component> sortWordsInSentenceByWordLength(Composite text) {
        List<Component> listOfLexemes = new ArrayList<>(text.getTextParts());
        listOfLexemes.sort(Comparator.comparing(Component::getValue));
        return listOfLexemes;
    }

    public static String restoreStartText(Component text) {
        String startingText = text.getTextParts().stream()
                .map(Component::getValue)
                .collect(Collectors.joining(" "));
        return startingText;
    }
}
