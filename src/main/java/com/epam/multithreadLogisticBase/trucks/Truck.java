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
        if (loaded) {
            try {
                base.getTerminals().acquire();
                base.getLock().unlock();
                System.out.printf("Truck:[%s] is STARTING service in terminal. Truck is loaded:%s. [%s]\n", id, (loaded ? "YES" : "NO"), Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                setLoaded(false);
                System.out.printf("Truck: %s was serviced in terminal. Truck is loaded:%s.\n", id, (loaded ? "YES" : "NO"));
                base.getTerminals().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.printf("Truck: %s is empty.\n", id);
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
