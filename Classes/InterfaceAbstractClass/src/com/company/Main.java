package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
     - Interface: methods that class that implements must implement
            - Abstract: no actual code, just name and parameter. Code still goes in the class
            - Common behaviour for all class that implements them
            - Commitment that method signatures and variables are not going to change
            - Access modifiers in interface are redundant; those are for the class, so in interface do not need them
            - Methods will be overridden in class that implements because making specific behaviour in the class
            - When making a new class that implements I - name of I is the type, but new called on class that implements it
                - Interface is for which methods are valid (cannot be instantiated)
                - The implementation is the specific type that implements it
            - Datatype being Interface allows for reassignment to another type of class that implements the same interface
            - Interface guarantees which methods are going to be implements, will not fall back to base class like inheritance
            - Declare it using interface unless reason to be more generic
            - Abstract what from the how
                - Can have private methods for when other methods in class have common code
            - Use when: 
                - Specify behaviour without implementation
                - Implemeted by many unrelated classes
     */

    public static void main(String[] args) {

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        /*
            If the interface is the datatype, need to cast the actual class to run methods
                - Declare variable that can hold different types, need to be the generic interface
                - Want to implement methods, than should be declared as the class
         */
        ((Monster) werewolf).getStrength();
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int index = 0;
        System.out.println("Choose \n" +
                   "1 to enter a string \n" +
                    "0 to quit"
        );

        while (!quit) {
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    break;
            }
        }
        return values;
    }

    /*
        Passing interface as parameter, can use any object that implements the interface
     */
    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
