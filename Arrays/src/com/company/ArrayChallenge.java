package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayChallenge {
    private static Scanner scanner = new Scanner(System.in);

    int[] myIntegers = getIntegers(5);

    public static int[] getIntegers(int capacity) {
       int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values: \r");

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    };

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    };

    public static int[] sortIntegers(int[] array) {
        // Initialize a new array and then create a new one use java utils
        // Pass in the array and the length as the parameters
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;

        while (flag) {
            // If this doesnt get reset then automatically break the while loop
            flag = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    // Basic implementation of Selection sort, where values are swapped everytime there is a value in the wrong place
                    // Has a quadratic average run time because need to look at every element for each element
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;

                    flag = true;
                }
            }
        }

        return sortedArray;
    };
}
