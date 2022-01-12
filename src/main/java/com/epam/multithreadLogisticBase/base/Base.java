package com.epam.multithreadLogisticBase.base;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Base instance;
    private final Semaphore terminals;
    private final Lock lock = new ReentrantLock();

    public Base(Semaphore semaphore) {
        this.terminals = semaphore;
    }

    public static Base getInstance(Semaphore terminals) {
        if (instance == null) {
            instance = new Base(terminals);
        }
        return instance;
    }

    public Lock getLock() {
        return lock;
    }

    public Semaphore getTerminals() {
        return terminals;
    }
}
