package com.company;

public class IntEqualityPrinter {

    public static void printEqual(int num1, int num2, int num3) {
            String message = "";

            if (num1 < 0 || num2 < 0 || num3 < 0) {
                message = "Invalid Value";
            } else if ((num1 == num2) && (num2 == num3)) {
                message = "All numbers are equal";
            } else if ((num1 != num2) && (num2 != num3) && (num1 != num3)) {
                message = "All numbers are different";
            } else {
                message = "Neither all are equal or different";
            }

        System.out.println(message);
    };
}
