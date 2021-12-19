package com.epam.task2.geometry.observer;

import com.epam.task2.geometry.entities.ConeObservable;
import com.epam.task2.geometry.entities.Point;
import org.junit.Assert;
import org.junit.Test;

public class ConeObserverWithStorageFunctionTest {

    private static final double DELTA=0.001;

    @Test
    public void testUpdateShouldUpdateVolumeWhenConeChanged(){
        //given
        ConeObserverWithStorageParametersFunction coneStore = ConeObserverWithStorageParametersFunction.getInstance();
        ConeObservable firstConeObservable =new ConeObservable(2, new Point(0, 0, 0), 5, 5);
        firstConeObservable.attach(coneStore);
        firstConeObservable.notifyObservers();
        firstConeObservable.setConeRadius(4);
        firstConeObservable.notifyObservers();
        //when
        double actualVolume = coneStore.getDataById(2).getVolume();
        //then
        Assert.assertEquals(84, actualVolume, DELTA);
    }

    @Test
    public void testUpdateShouldUpdateSurfaceAreaWhenConeChanged(){
        //given
        ConeObserverWithStorageParametersFunction coneStore = ConeObserverWithStorageParametersFunction.getInstance();
        ConeObservable firstConeObservable =new ConeObservable(3, new Point(0, 0, 0), 5, 5);
        firstConeObservable.attach(coneStore);
        firstConeObservable.notifyObservers();
        firstConeObservable.setConeHeight(4);
        firstConeObservable.notifyObservers();
        //when
        double actualSurfaceArea = coneStore.getDataById(3).getSurfaceArea();
        //then
        Assert.assertEquals(179, actualSurfaceArea, DELTA);
    }
}
