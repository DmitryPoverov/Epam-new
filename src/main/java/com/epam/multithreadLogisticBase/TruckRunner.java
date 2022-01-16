package com.epam.multithreadLogisticBase;

import com.epam.multithreadLogisticBase.jsonReader.JsonReader;
import com.epam.multithreadLogisticBase.trucks.Truck;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TruckRunner {

    private static final String JSON_FILE_PATH = "src/main/resources/truck.json";

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(6);

        List<Truck> trucks =  JsonReader.getTruckList(JSON_FILE_PATH);

        for (Truck truck : trucks) {
            threadPool.submit(truck);
            try {
                TimeUnit.MILLISECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();

/* I don't know: it's normal to throw in parser exceptions and then catch its in the main()?
       try {
            List<Truck> trucks =  JsonReader.getTrucks(JSON_FILE_PATH);
            trucks.stream()
                    .peek(truck -> truck.setBase(base))
                    .map(threadPool::submit)
                    .collect(Collectors.toList());
            threadPool.shutdown();
        } catch (JsonContentException | JsonPathException e) {
            e.printStackTrace();
        }*/
    }
}

