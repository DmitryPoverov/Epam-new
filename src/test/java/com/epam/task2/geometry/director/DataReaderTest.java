package com.epam.task2.geometry.director;

import com.epam.task2.geometry.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final DataReader reader = new DataReader();

    @Test
    public void testReadShouldReadStringsWhenFileHasMultipleStrings() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1 2 3 4 5", "1 2 3z 4 5", "1 2 3 0 0", "100000000");
        //when
        List<String> actualLines = reader.read("src/test/resources/inputData.txt");
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }

    @Test(expected = DataException.class)
    public void testShouldThrowDataExceptionWhenFileNotFound() throws DataException {
        //given
        //when
        reader.read("wrongFileExample");
        //then
    }
}
