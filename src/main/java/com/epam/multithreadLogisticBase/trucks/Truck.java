package com.epam.multithreadLogisticBase.trucks;

import com.epam.multithreadLogisticBase.base.Base;

import java.util.concurrent.TimeUnit;

public class Truck implements Runnable {

    private Base base;
    private int id;
    private boolean loaded;

    public Truck() {
    }
    public Truck(int id, boolean loaded) {
        this.id = id;
        this.loaded = loaded;
    }

    public int getId() {
        return id;
    }
    public boolean isLoaded() {
        return loaded;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
    public void setBase(Base base) {
        this.base = base;
    }

    @Override
    public void run() {
        try {
            base.getLock().lock();
            base.getSemaphore().acquire();
            System.out.println(base.getSemaphore().availablePermits());
            System.out.printf("%s is START servicing in %s\n", this, Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s FINISHED %s\n", this, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(base.getSemaphore().availablePermits());
            base.getSemaphore().release();
            base.getLock().unlock();
        }
    }

    @Override
    public String toString() {
        return "Truck[" +
                "id:" + id +
                ",load:" + loaded + ']';
    }
}
