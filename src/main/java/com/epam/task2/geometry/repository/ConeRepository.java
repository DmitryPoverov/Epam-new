package com.epam.task2.geometry.repository;

import com.epam.task2.geometry.entities.ConeObservable;

import java.util.Comparator;
import java.util.List;

public interface ConeRepository {

    void add(ConeObservable coneObservable);

    void delete(ConeObservable coneObservable);

    void update(ConeObservable coneObservable);

    List<ConeObservable> query(ConeSpecification coneSpecification);

    List<ConeObservable> sort(Comparator<ConeObservable> comparator);
}