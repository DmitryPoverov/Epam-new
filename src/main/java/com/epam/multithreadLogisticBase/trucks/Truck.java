package com.epam.multithreadLogisticBase.trucks;

import com.epam.multithreadLogisticBase.base.Base;

public class Truck implements Runnable {

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

    public int getId() {
        return id;
    }
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public void run() {
        Base base = Base.getInstance();
        base.unloadTruck(this);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Truck truck = (Truck) object;

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
