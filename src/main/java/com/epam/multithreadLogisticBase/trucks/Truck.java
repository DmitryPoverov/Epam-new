package com.epam.multithreadLogisticBase.trucks;

public class Truck implements Runnable {

    private int id;
    private boolean loaded;

    public Truck() {
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

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "Truck[" +
                "id: " + id +
                ", load: " + loaded + ']';
    }
}
