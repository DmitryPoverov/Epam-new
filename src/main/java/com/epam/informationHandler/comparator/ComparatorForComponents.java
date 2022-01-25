package com.epam.informationHandler.comparator;

import com.epam.informationHandler.component.Composite;

import java.util.Comparator;

public class ComparatorForComponents implements Comparator<Composite> {

    @Override
    public int compare(Composite compositeOne, Composite compositeTwo) {
        return compositeOne.getNumberOfChildren() - compositeTwo.getNumberOfChildren();
    }
}
