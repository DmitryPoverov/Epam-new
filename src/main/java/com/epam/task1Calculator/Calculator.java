package com.epam.task1Calculator;

public class Calculator {

    public double add(double first, double second) {
        return first + second;
    }

    public double subtract(double first, double second) {
        return first - second;
    }

    public double multiply(double first, double second) {
        return first * second;
    }

    public double divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("It's not possible dividing by 0");
        }
        return (double) first / second;
    }
}
