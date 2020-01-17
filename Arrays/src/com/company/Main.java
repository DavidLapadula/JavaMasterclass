package com.company;
import java.util.Scanner;

/*
 Array notes
    - DS of piece of connected memory that can be accessed by index
    - Need to pass in amount and type
    - [] are array accessors
    - Use new operator to initialize arrays - int set to 0, String set to null, boolean set to false
    - Use {} to make anonymous array, implicitly set length and values
    - If use the wrong index then will give you out of bounds error
    - <= to avoid out of bounds error to last value in array because is zero indexed
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Testing
        int[] myIntArray =  new int[10];
        double[] myDoubleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        myIntArray[5] = 50;


        int[] returnedArray = MinElement.readIntegers(5);

    };

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values. \r");
        int[] values = new int [number];

        for (int i = 0; i < values.length; i++) {
            // Next int allows you to get the next value from being input into the console
            values[i] = scanner.nextInt();
        }
         return values;
    };

    public static double getAverage(int[] array) {
        int sum = 0;
       for (int i=0; i < array.length; i++) {
            sum += array[i];
       };
       return (double) sum/array.length;
    };

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    };
}
