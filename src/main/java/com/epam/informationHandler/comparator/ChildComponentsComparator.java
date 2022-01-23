package com.epam.informationHandler.comparator;

import com.epam.informationHandler.component.Composite;

import java.util.Comparator;

public class ChildComponentsComparator implements Comparator<Composite> {
    @Override
    public int compare(Composite o1, Composite o2) {
        return o1.getChildrenQuantity() - o2.getChildrenQuantity();
    }
}
