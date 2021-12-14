package com.epam.task1;

public class Calculator {

    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double divide(int firstOperand, int secondOperand) {

        if (secondOperand == 0) {
            throw new IllegalArgumentException("It's not possible dividing by 0");
        }
        return (double)firstOperand / secondOperand;
    }
}
