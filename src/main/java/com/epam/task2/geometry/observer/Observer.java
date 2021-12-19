package com.epam.task2.geometry.observer;

public interface Observer<T> {

    void update(T event);
}
