package com.epam.multithreadLogisticBase;

import com.epam.multithreadLogisticBase.base.Base;
import com.epam.multithreadLogisticBase.jsonReader.JsonReader;
import com.epam.multithreadLogisticBase.trucks.Truck;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class TruckRunner {

    private static final String JSON_FILE_PATH = "src/main/resources/truck.json";
    private static final int QUANTITY_OF_TERMINALS_ON_THE_BASE = 2;

    public static void main(String[] args) {

        Semaphore terminals = new Semaphore(QUANTITY_OF_TERMINALS_ON_THE_BASE);
        Base base = Base.getInstance(terminals);

        ExecutorService threadPool = Executors.newCachedThreadPool();

        List<Truck> trucks = JsonReader.getTrucks(JSON_FILE_PATH);

        trucks.stream()
                .peek(truck -> truck.setBase(base))
                .map(threadPool::submit)
                .collect(Collectors.toList());
        threadPool.shutdown();
    }
}

