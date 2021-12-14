package com.epam.task1;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        double result = calculator.add(10, 20);
        System.out.println(result);

        result = calculator.subtract(10, 20);
        System.out.println(result);

        result = calculator.multiply(10, 20);
        System.out.println(result);

        result = calculator.divide(10, 20);
        System.out.println(result);

        try {
            result = calculator.divide(10, 0);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
