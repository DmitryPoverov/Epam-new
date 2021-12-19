package com.epam.task2.geometry.entities;

import com.epam.task2.geometry.director.ConeCreator;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    private static final String VALID_DATA = "4 4 1 2 3";
    private final ConeCreator creator = new ConeCreator();

    @Test
    public void testCreateShouldCreateAConeWhenDataIsValid() {
        //given
        Cone expectedCone = new Cone (new Point(1, 2, 3), 4, 4);
        //when
        Cone createdCone = creator.create(VALID_DATA);
        //then
        Assert.assertEquals(expectedCone, createdCone);
    }
}
