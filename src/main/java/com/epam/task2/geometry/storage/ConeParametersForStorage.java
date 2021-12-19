package com.epam.task2.geometry.storage;

public class ConeParametersForStorage {

    private final double volume;
    private final double surfaceArea;

    public ConeParametersForStorage(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

}
