package com.company;

public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes) {
        String value = "Invalid Value";

        if (minutes >= 0) {
            long daysfromMinutes = minutes / 1440;
            long years = (int) daysfromMinutes / 365;
            long days = (int) daysfromMinutes % 365;

            value = minutes +  " min = " + years + " y and " + days + " d";
        };

        System.out.println(value);
    };
}
