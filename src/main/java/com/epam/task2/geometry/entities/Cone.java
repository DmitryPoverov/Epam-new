package com.epam.task2.geometry.entities;

import java.util.Objects;

public class Cone {

    private Point center;
    private double coneRadius;
    private double coneHeight;

    public Cone() {
    }

    public Cone(Point center, double coneRadius, double coneHeight) {
        this.center = center;
        this.coneRadius = coneRadius;
        this.coneHeight = coneHeight;
    }

    public Point getCenter() {
        return center;
    }
    public double getConeRadius() {
        return coneRadius;
    }

    public double getConeHeight() {
        return coneHeight;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
    public void setConeRadius(double coneRadius) {
        this.coneRadius = coneRadius;
    }
    public void setConeHeight(double coneHeight) {
        this.coneHeight = coneHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cone cone = (Cone) o;

        if (Double.compare(cone.coneRadius, coneRadius) != 0) return false;
        if (Double.compare(cone.coneHeight, coneHeight) != 0) return false;
        return Objects.equals(center, cone.center);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center != null ? center.hashCode() : 0;
        temp = Double.doubleToLongBits(coneRadius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coneHeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "center=" + center +
                ", coneRadius=" + coneRadius +
                ", coneHeight=" + coneHeight +
                '}';
    }
}
