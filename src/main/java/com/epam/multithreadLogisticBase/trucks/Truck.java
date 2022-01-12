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
            System.out.printf("Track with ID:%s STARTS servicing in terminal. State:%s\n", id, loaded);
            TimeUnit.SECONDS.sleep(1);
            setLoaded(false);
            System.out.printf("Track with ID:%s FINISHED servicing in terminal. State:%s\n", id, loaded);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
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
