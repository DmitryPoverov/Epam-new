package com.epam.task2.geometry.repository;

import com.epam.task2.geometry.entities.ConeObservable;

public interface ConeSpecification {

    boolean specified(ConeObservable coneObservable);
}