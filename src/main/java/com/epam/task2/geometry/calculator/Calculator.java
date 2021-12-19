package com.epam.task2.geometry.calculator;

import com.epam.task2.geometry.entities.Cone;
import com.epam.task2.geometry.entities.Point;

public class Calculator {

    public static double calculateConeSurFaceArea (Cone cone) {
        final double coneRadius = cone.getConeRadius();
        final double coneHeight = cone.getConeHeight();
        double surfaceArea = Math.PI * coneRadius * (Math.sqrt(Math.pow(coneRadius, 2) + Math.pow(coneHeight, 2)) + coneRadius);
        return formatCalculationResult(surfaceArea);
    }

    private static double formatCalculationResult(double input) {
        String surfaceAreaRounding = String.format("%.0f", input);
        return Double.parseDouble(surfaceAreaRounding);
    }

    public static double calculateConeVolume (Cone cone) {
        final double coneRadius = cone.getConeRadius();
        final double coneHeight = cone.getConeHeight();
        double volume = 1/3.0 * Math.PI * Math.pow(coneRadius, 2) * coneHeight;
        return formatCalculationResult(volume);
    }

    public static double calculateConeVolumesRatio(double secantHeight, Cone cone) {
        double сtg = cone.getConeRadius() / cone.getConeHeight();
        double toppedConeUpperRadius = cone.getConeRadius() - secantHeight * сtg;
        double toppedConeHeight = secantHeight;
        double toppedConeBaseRadius = cone.getConeRadius();
        double toppedConeVolume = (1/3) * Math.PI * toppedConeHeight
                * (Math.pow(toppedConeBaseRadius, 2)
                + toppedConeBaseRadius * toppedConeUpperRadius
                + Math.pow(toppedConeUpperRadius, 2));

        double smallConeVolume = calculateConeVolume(cone) - toppedConeVolume;

        double result;
        if (toppedConeVolume >= smallConeVolume) {
            result = toppedConeVolume / smallConeVolume;
        } else {
            result = smallConeVolume / toppedConeVolume;
        }
        return result;
    }

    public static boolean isConeOnTheCoordinatePlane(Cone cone) {
        Point point = cone.getCenter();
        return point.getZ()==0;
    }
}
