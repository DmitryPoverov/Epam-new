package com.epam.multithreadLogisticBase;

import com.epam.multithreadLogisticBase.base.Base;
import com.epam.multithreadLogisticBase.jsonReader.JsonReader;
import com.epam.multithreadLogisticBase.trucks.Truck;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class TruckRunner {
    public static void main(String[] args) {

        Semaphore terminals = new Semaphore(2, true);
        Base base = Base.getInstance(terminals);

// It is a queue from json for going to the base
        List<Truck> trucks = JsonReader.getShips("src/main/resources/truck.json");

        List<Thread> threads = trucks.stream()
                .peek(truck -> truck.setBase(base))
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
    }
}

