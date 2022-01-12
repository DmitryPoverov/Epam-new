package com.epam.multithreadLogisticBase.base;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Base instance;
    private final Semaphore semaphore;
    private final Lock lock = new ReentrantLock();

    public Base(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static Base getInstance(Semaphore semaphore) {
        if (instance == null) {
            instance = new Base(semaphore);
        }
        return instance;
    }

    public Lock getLock() {
        return lock;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
