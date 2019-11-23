package com.company;

public class AreaCalculator {

    public static double area(double radius) {

        if (radius >= 0) {
            return radius * radius * Math.PI;
        } else {
            return -1.0;
        }

    };

    public static double area(double x, double y) {

        if (y >= 0 && x >= 0) {
            return x * y;
        } else {
            return -1.0;
        }

    };
}
