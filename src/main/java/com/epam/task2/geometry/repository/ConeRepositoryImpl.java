package com.epam.task2.geometry.repository;

import com.epam.task2.geometry.entities.ConeObservable;
import java.util.*;

public class ConeRepositoryImpl implements ConeRepository{

    Map<Integer, ConeObservable> cones = new HashMap<>();

    @Override
    public void add(ConeObservable coneObservable) {
        cones.put(coneObservable.getId(), coneObservable);
    }

    @Override
    public void delete(ConeObservable coneObservable) {
        cones.remove(coneObservable.getId(), coneObservable);
    }

    @Override
    public void update(ConeObservable coneObservable) {
        cones.put(coneObservable.getId(), coneObservable);
    }

    @Override
    public List<ConeObservable> query(ConeSpecification coneSpecification) {
        List<ConeObservable> result = new ArrayList<>();
        for (ConeObservable cone : cones.values()) {
            if (coneSpecification.specified(cone)) {
                result.add(cone);
            }
        }
        return result;
    }

    @Override
    public List<ConeObservable> sort(Comparator<ConeObservable> comparator) {
        List<ConeObservable> result = new ArrayList<>(cones.values());
        result.sort(comparator);
        return result;
    }
}