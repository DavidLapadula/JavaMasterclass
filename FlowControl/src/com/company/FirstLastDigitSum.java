package com.company;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
       int returnValue = 0;

       if (number < 0) {
           returnValue = -1;
       } else {
           int lastDigit = number % 10;
           int firstDigit = getFirstDigit(number);
           returnValue = lastDigit + firstDigit;
       }


       return returnValue;
    };

    private static int getFirstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }
}


