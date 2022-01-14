package com.epam.multithreadLogisticBase.jsonReader;

import com.epam.multithreadLogisticBase.jsonReader.exception.JsonContentException;
import com.epam.multithreadLogisticBase.jsonReader.exception.JsonPathException;
import com.epam.multithreadLogisticBase.trucks.Truck;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// I don't know: to make this class as util class with private constructor and static methods or with non-static methods
public class JsonReader {
    private static final Logger LOGGER = LogManager.getLogger(JsonReader.class);

    private JsonReader() {
    }

    private static String readJson (String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bR = new BufferedReader (new FileReader(path))) {
            int ch;
            while ((ch = bR.read()) != -1) {
                builder.append((char)ch);
            }
        }
        return builder.toString();
    }

// Version with throwing of exceptions
    public static List<Truck> getTrucks(String path) throws JsonContentException, JsonPathException {
        ObjectMapper mapper = new ObjectMapper();
        Truck[] trucks;
        try {
            trucks = mapper.readValue(readJson(path), Truck[].class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Parsing error. File CONTENT is wrong. File: " + path);
            throw new JsonContentException("Content is wrong");
        } catch (IOException e) {
            LOGGER.error("Parsing error. File PATH is wrong. File: " + path);
            throw new JsonPathException("Path is wrong");
        }
        return new ArrayList<>(Arrays.asList(trucks));
    }

// Version without throwing of exceptions
    public static List<Truck> getTruckList(String path) {
        ObjectMapper mapper = new ObjectMapper();
        Truck[] trucks = new Truck[0];
        try {
            trucks = mapper.readValue(readJson(path), Truck[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(Arrays.asList(trucks));
    }
}