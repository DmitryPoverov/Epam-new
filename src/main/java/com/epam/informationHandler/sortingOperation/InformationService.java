package com.epam.informationHandler.sortingOperation;

import com.epam.informationHandler.component.Component;
import com.epam.informationHandler.component.Composite;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InformationService {

    public List<Component> sortParagraphBySentencesQuantity(Composite text) {
        return text.getChildren()
                .stream()
                .sorted(Comparator.comparing(paragraph -> paragraph.getChildren().stream().count()))
                .collect(Collectors.toList());
    }

    public List<Component> sortWordsByLongInSentence(Composite text) {
        return text.getChildren()
                .stream()
                .sorted(Comparator.comparing(sentence -> sentence.getChildren().stream().count()))
                .collect(Collectors.toList());
    }
}
