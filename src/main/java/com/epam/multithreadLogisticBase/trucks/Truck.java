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
            base.getTerminals().acquire();
            System.out.println(base.getTerminals().availablePermits());
            System.out.printf("%s STARTS servicing in terminal\n", this);
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s FINISHED servicing in terminal\n", this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(base.getTerminals().availablePermits());
            base.getTerminals().release();
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
