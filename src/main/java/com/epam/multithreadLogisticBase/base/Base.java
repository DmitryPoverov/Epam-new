package com.epam.multithreadLogisticBase.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static final Logger LOGGER = LogManager.getLogger(Base.class);
    private static final Lock STATIC_LOCK = new ReentrantLock();
    private static Base instance;
    private final Semaphore terminals;
    private final Lock lock = new ReentrantLock();

    public Base(Semaphore semaphore) {
        this.terminals = semaphore;
    }

    public static Base getInstance(Semaphore terminals) {
        if (instance == null) {
            STATIC_LOCK.lock();
            instance = new Base(terminals);
            STATIC_LOCK.unlock();
        }
        LOGGER.info("Instance of Base was returned");
        return instance;
    }

    public Lock getLock() {
        return lock;
    }

    public Semaphore getTerminals() {
        return terminals;
    }
}
