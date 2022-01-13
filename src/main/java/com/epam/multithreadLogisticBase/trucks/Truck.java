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
        base.getLock().lock();
        try {
            base.getTerminals().acquire();
            base.getLock().unlock();
            System.out.printf("Truck:[%s] STARTS servicing in terminal. Truck is loaded:%s.\n", id, (loaded? "YES" : "NO"));
            TimeUnit.MILLISECONDS.sleep(500);
            setLoaded(false);
            System.out.printf("Truck: %s was serviced in terminal. Truck is loaded:%s.\n", id, (loaded? "YES" : "NO"));
            base.getTerminals().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public String toString() {
        return "Truck[" +
                "id:" + id +
                ",load:" + loaded + ']';
    }
}
