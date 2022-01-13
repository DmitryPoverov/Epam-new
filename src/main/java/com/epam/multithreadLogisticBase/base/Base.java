package com.epam.multithreadLogisticBase.base;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Base instance;
    private static final Lock STATIC_LOCK = new ReentrantLock();
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
        return instance;
    }

    public Lock getLock() {
        return lock;
    }

    public Semaphore getTerminals() {
        return terminals;
    }
}
