package com.epam.multithreadLogisticBase.jsonReader;

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

// Util class
public class JsonReader {
    private static final Logger LOGGER = LogManager.getLogger(JsonReader.class);

    private JsonReader() {
    }

    private static String readJson (String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bR = new BufferedReader (new FileReader(path))) {
            int ch;
            while ((ch = bR.read()) != -1) {
                builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static List<Truck> getTrucks(String path) {
        ObjectMapper mapper = new ObjectMapper();
        Truck[] trucks = new Truck[0];
        try {
            trucks = mapper.readValue(readJson(path), Truck[].class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Parsing error" + path);
            e.printStackTrace();
        }
        return new ArrayList<>(Arrays.asList(trucks));
    }
}
