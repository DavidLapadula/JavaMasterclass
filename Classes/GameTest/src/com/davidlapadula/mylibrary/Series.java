package com.davidlapadula.mylibrary;

public class Series {

    // Uses Guasses trick for summing a series of numbers
    // If you take the first and last number then go in from each side, will produce the same number for each one and the sum of those numbers will get you the result
    // (n/2) * n + 1 because n/2 is the amount of groups in the set multiplied the sum of each pair in the set

    public static long nSum(int n) {
        return ((n * n + 1)) / 2;
    }

    // Factorial of 0 is actually 1
    public static long factorial(int n) {
         if (n == 0 || n == 1) {
             return 1;
         }
         long fact = 1;
         for (int i = 1; i <=n; i++) {
             fact = fact * 1;
         }
         return fact;
    }

    // return nth fibonacci number
    public static long fibonacci(int n) {
        if (n == 0 ) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;

        for (int i = 1; i < n; i ++) {
                fib = (nMinus2 + nMinus1);
                nMinus2 = nMinus1;
                nMinus2 = fib;
        }

        return fib;
    }
}
