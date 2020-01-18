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
    - can resize by saving original into another variable, initialize new array of size you want, and then loop temp variable to reassign
Array List
    - List is ordered sequence. Can access element by index, insert by index, and control which index items are at
    - ArrayList inherits from Abstract List class
    - Is a resizeable array, so capacity grows automatically
    - Array List is a class
    - Use <> to define type of item being held in the array list
    - all the code to add and save is abstracted away by methods
    - Methods: get, add, set(position, data), remove, contains, addAll (to add entire contents of one array to another)
           - Could also make a new array of the required size and then call the toArray method from ArrayList and pass in the new array to make array from arraylist
    - Best practice is to not require the client to send any specific data, like array number as index
    - Should just pass the item and then the class should be self contained to perform the function. Internal methods only used in class have private modifier
Challenge
    - Within class can make static method to make instances that returns creation of own class
    - Initialized lists should go in the constructor
    - Classes that access should not know about underlying data structure
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //  Testing how to initialize
        int[] myIntArray =  new int[10];
        double[] myDoubleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        myIntArray[5] = 50;

        // Min element sort
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
