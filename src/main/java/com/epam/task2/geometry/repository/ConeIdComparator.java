package com.epam.task2.geometry.repository;

import com.epam.task2.geometry.entities.ConeObservable;

import java.util.Comparator;

public class ConeIdComparator implements Comparator<ConeObservable> {

    @Override
    public int compare(ConeObservable firstCone, ConeObservable secondCone) {
        Integer firstConeId = firstCone.getId();
        Integer secondConeId = secondCone.getId();
        return firstConeId.compareTo(secondConeId);
    }
}
