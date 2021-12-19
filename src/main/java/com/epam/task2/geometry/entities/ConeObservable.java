package com.epam.task2.geometry.entities;

import com.epam.task2.geometry.observer.Observable;
import com.epam.task2.geometry.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConeObservable extends Cone implements Observable<ConeObservable> {

    private final Integer id;
    private final List<Observer<ConeObservable>> observerList = new ArrayList<>();

    public ConeObservable(Integer id, Point center, double coneRadius, double сoneHeight) {
        super(center, coneRadius, сoneHeight);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setCenter(Point center) {
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setConeRadius(double coneRadius) {
        super.setConeRadius(coneRadius);
        notifyObservers();
    }

    @Override
    public void setConeHeight(double coneHeight) {
        super.setConeHeight(coneHeight);
        notifyObservers();
    }

    @Override
    public void attach(Observer<ConeObservable> observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer<ConeObservable> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<ConeObservable> observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "ConeObservable{" +
                "id=" + id +
                ", observerList=" + observerList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ConeObservable that = (ConeObservable) o;

        if (!id.equals(that.id)) {
            return false;
        }
        return observerList.equals(that.observerList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + observerList.hashCode();
        return result;
    }
}
