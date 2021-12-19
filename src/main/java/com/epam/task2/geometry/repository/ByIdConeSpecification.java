package com.epam.task2.geometry.repository;

import com.epam.task2.geometry.entities.ConeObservable;

public class ByIdConeSpecification implements ConeSpecification {

    private final int id;

    public ByIdConeSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(ConeObservable coneObservable) {
        int currentConeId = coneObservable.getId();
        if (currentConeId == id) {
            return true;
        } else {
            return false;
        }
    }
}
