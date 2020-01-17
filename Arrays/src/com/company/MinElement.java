package com.company;

import java.util.Scanner;

public class MinElement {

    // private fields encapsulate data
    private static Scanner scanner = new Scanner(System.in);

    public static int[] readIntegers(int count) {
       int[] array = new int[count];

       for(int i = 0; i < array.length; i++) {
           System.out.println("Enter a number");
           int number = scanner.nextInt();
           scanner.nextLine();
           array[i] = number;
       };

       return array;
    };

    private static int findMin(int[] array) {
       int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++) {
          int value = array[i];
          if (value < min) {
             min = value;
          };
        };

        return min;
    };
}
