package com.company;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {
        int returnValue;

        if (number > 0) {
            returnValue = 0;

            while (number > 9 ){
                int value = number % 10;
                if (value % 2 == 0) returnValue += value;
                number = number / 10;
            }

            if(number < 9 && number % 2 == 0) returnValue += number;

        } else {
            returnValue = number < 0 ? -1 : 0;
        }

        return returnValue;
    };
}
