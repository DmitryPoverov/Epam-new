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
                System.out.printf("Truck:[%s] is STARTING service in terminal. Truck is loaded:%s.\n", id, (loaded ? "YES" : "NO"));
                TimeUnit.SECONDS.sleep(1);
                setLoaded(false);
                System.out.printf("Truck: %s was serviced in terminal. Truck is unloaded:%s.\n", id, (loaded ? "NO" : "YES"));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (id != truck.id) return false;
        return loaded == truck.loaded;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (loaded ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Truck[" +
                "id:" + id +
                ",load:" + loaded + ']';
    }
}
