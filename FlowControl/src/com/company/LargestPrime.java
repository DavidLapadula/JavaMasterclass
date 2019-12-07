package com.company;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        int largestPrime;

        if (number >= 2) {
            int copyOfInput = number;

            for (largestPrime = 2; largestPrime <= copyOfInput; largestPrime++) {
                // Prime factors either fully divide the number being checked, or produce another prime factor
                // in either case the loop divides the number by a number that leaves no remainder. This happens until the number and largest prime are equal, making 'copyOfInput' == 1
                // And the largest prime will always be greater than that. 
                if (copyOfInput % largestPrime == 0) {
                    copyOfInput /= largestPrime;
                    largestPrime--;
                }
            }
        } else {
           largestPrime = -1;
        };

        return largestPrime;
    };
}
