package com.epam.task2.geometry.calculator;

import com.epam.task2.geometry.entities.Cone;
import com.epam.task2.geometry.entities.Point;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final double DELTA=0.1;

    @Test
    public void testShouldCalculateSurfaceAreaWhenConeIsValid() {
        //given
        Cone cone = new Cone(new Point(0, 0, 0), 2, 10);
        //when
        double surfaceArea = Calculator.calculateConeSurFaceArea(cone);
        //then
        Assert.assertEquals(77, surfaceArea, DELTA);
    }

    @Test
    public void testShouldCalculateVolumeWhenBallIsValid() {
        //given
        Cone cone = new Cone(new Point(0, 0, 0), 8, 11);
        //when
        double volume = Calculator.calculateConeVolume(cone);
        //then
        Assert.assertEquals(737, volume, DELTA);
    }

    @Test
    public void testShouldAnswerIsConeOnCoordinatePlaneWhenZEqualsZero() {
        //given
        Cone cone = new Cone(new Point(10, 10, 0), 2, 10);
        //when
        boolean answer = Calculator.isConeOnTheCoordinatePlane(cone);
        //then
        Assert.assertEquals(Boolean.TRUE, answer);
    }
}
