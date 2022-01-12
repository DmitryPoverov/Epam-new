package com.epam.multithreadLogisticBase;

import com.epam.multithreadLogisticBase.jsonReader.JsonReader;
import com.epam.multithreadLogisticBase.trucks.Truck;

import java.util.List;

public class TruckRunner {
    public static void main(String[] args) {

        List<Truck> truckList = JsonReader.getShips("src/main/resources/truck.json");

        for (Truck t : truckList) {
            System.out.println(t);
        }
    }
}

