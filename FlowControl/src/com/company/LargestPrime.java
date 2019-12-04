package com.company;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        int largestPrime;

        if (number >= 2) {
            int copyOfInput = number;

            for (largestPrime = 2; largestPrime <= copyOfInput; largestPrime++) {
                if (copyOfInput % largestPrime == 0) {
                    copyOfInput /= largestPrime;
                    largestPrime--;
                }
                System.out.println(largestPrime);
                System.out.println(copyOfInput);
            }
        } else {
           largestPrime = -1;
        };

        return largestPrime;
    };
}
