package com.company;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
       return reverseNumber(number) == Math.abs(number);
    };

    public static int reverseNumber(int number) {
        int reversedNumber = 0;

        number = Math.abs(number);

        while (number > 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }

        return reversedNumber;
    }

}
