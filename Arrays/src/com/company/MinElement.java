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

    // Swapping elements, once reached half then already has been swapped
    // Store current item in temp variable
    // set surrent item to the maximum index minus the current item index (its mirror)
    // set the mirror to the temp that is stored
    public static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for(int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        };
    };
}
