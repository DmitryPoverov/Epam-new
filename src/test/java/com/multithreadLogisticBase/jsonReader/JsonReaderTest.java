package com.multithreadLogisticBase.jsonReader;

import com.epam.multithreadLogisticBase.jsonReader.JsonReader;
import com.epam.multithreadLogisticBase.jsonReader.exception.JsonContentException;
import com.epam.multithreadLogisticBase.jsonReader.exception.JsonPathException;
import com.epam.multithreadLogisticBase.trucks.Truck;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JsonReaderTest {

    private static final String VALID_PATH = "src/test/resources/truckTest.json";
    private static final String INVALID_FILE = "src/test/resources/wrongTruckTest.json";
    private static final String JSON_FILE_WRONG_PATH = "src/main/res/tru.json";

    @Test
    public void testShouldParseFileWhenFileIsCorrect() throws JsonContentException, JsonPathException {
        //given
        JsonReader reader = new JsonReader();
        Truck truck1 = new Truck(101, true);
        Truck truck2 = new Truck(202, false);
        List<Truck> expected = Arrays.asList(truck1, truck2);
        //when
        List<Truck> actual = reader.getTrucks(VALID_PATH);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShouldParseWithSecondVersionMethodFileWhenFileIsCorrect() {
        //given
        JsonReader reader = new JsonReader();
        Truck truck1 = new Truck(101, true);
        Truck truck2 = new Truck(202, false);
        List<Truck> expected = Arrays.asList(truck1, truck2);
        //when
        List<Truck> actual = reader.getTruckList(VALID_PATH);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = JsonContentException.class)
    public void testShouldNotParseFileWhenFileIsNotCorrect() throws JsonPathException, JsonContentException {
        //given
        JsonReader reader = new JsonReader();
        //when
        reader.getTrucks(INVALID_FILE);
        //then
    }

    @Test(expected = JsonPathException.class)
    public void testShouldNotParseFileWhenPathIsNotCorrect() throws JsonPathException, JsonContentException {
        //given
        JsonReader reader = new JsonReader();
        //when
        reader.getTrucks(JSON_FILE_WRONG_PATH);
        //then
    }
}
