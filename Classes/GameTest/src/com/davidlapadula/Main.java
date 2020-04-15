package com.davidlapadula;

import com.example.game.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 /*
	    - Build artifact by File>Project Structure>Artifacts>Add>JAR>From module with dependencies
	    - To bring that file into a new project, File>Libraries>Java>...
	        - Will then be added to external libraries directory of new project
	  */
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
