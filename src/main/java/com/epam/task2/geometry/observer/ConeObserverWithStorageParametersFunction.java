package com.epam.task2.geometry.observer;

import com.epam.task2.geometry.calculator.Calculator;
import com.epam.task2.geometry.entities.ConeObservable;
import com.epam.task2.geometry.storage.ConeParametersForStorage;

import java.util.HashMap;
import java.util.Map;

public class ConeObserverWithStorageParametersFunction implements Observer<ConeObservable> {

    private static ConeObserverWithStorageParametersFunction INSTANCE;
    private final Map<Integer, ConeParametersForStorage> parameters = new HashMap<>();

    private ConeObserverWithStorageParametersFunction() {
    }

    @Override
    public void update (ConeObservable cone) {
        double volume = Calculator.calculateConeVolume(cone);
        double surfaceArea = Calculator.calculateConeSurFaceArea(cone);
        parameters.put(cone.getId(), new ConeParametersForStorage(volume, surfaceArea));
    }

    public ConeParametersForStorage getDataById (int id) {
        return parameters.get(id);
    }

    public static ConeObserverWithStorageParametersFunction getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConeObserverWithStorageParametersFunction();
        }
        return INSTANCE;
    }
}