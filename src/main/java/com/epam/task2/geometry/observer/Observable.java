package com.epam.task2.geometry.observer;

public interface Observable<T> {

    void attach(Observer<T> observer);

    void detach(Observer<T> observer);

    void notifyObservers();
}
