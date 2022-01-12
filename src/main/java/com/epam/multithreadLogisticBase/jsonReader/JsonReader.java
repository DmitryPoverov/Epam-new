package com.epam.multithreadLogisticBase.jsonReader;

import com.epam.multithreadLogisticBase.trucks.Truck;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

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

    public static List<Truck> getShips(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Truck> shipList;
        Truck[] trucks = new Truck[0];
        try {
            trucks = mapper.readValue(readJson(path), Truck[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        shipList = Arrays.asList(trucks);
        return shipList;
    }
}
