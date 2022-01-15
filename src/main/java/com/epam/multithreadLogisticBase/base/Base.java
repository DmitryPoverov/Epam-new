package com.epam.multithreadLogisticBase.base;

import com.epam.multithreadLogisticBase.trucks.Truck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static final Logger LOGGER = LogManager.getLogger(Base.class);
    private static final int QUANTITY_OF_TERMINALS_ON_THE_BASE = 2;
    private static final Lock STATIC_LOCK = new ReentrantLock();
    private static Base instance;

    private final Semaphore terminals = new Semaphore(QUANTITY_OF_TERMINALS_ON_THE_BASE);
    private final Lock lock = new ReentrantLock();

    private Base() {
    }

    public static Base getInstance() {
        Base temporalInstance = instance;
        if (temporalInstance == null) {
            STATIC_LOCK.lock();
            temporalInstance = instance;
            if (temporalInstance == null) {
                instance = temporalInstance = new Base();
            }
            STATIC_LOCK.unlock();
        }
        LOGGER.info("Instance of the Base was returned");
        return temporalInstance;
    }

    public void unloadTruck(Truck truck) {
        try {
            lock.lock();
            terminals.acquire();
            lock.unlock();
            System.out.printf("Truck: %d is %s\n", truck.getId(), (truck.isLoaded() ? "+ loaded." : "- empty."));
            TimeUnit.SECONDS.sleep(1);
            truck.setLoaded(!truck.isLoaded());
            System.out.printf("Truck: %d is %s\n", truck.getId(), (truck.isLoaded() ? "+ loaded." : "- unloaded."));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            terminals.release();
        }
    }
}
