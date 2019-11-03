package com.company;

public class Main {

    public static void main(String[] args) {

        // Char primitve type
            char myChar = 'D';
            char myUnicode = '\u0044';

            System.out.println(myChar);
            System.out.println(myUnicode);

        // Boolean primitive type
            boolean myTrueValue = true;
            boolean myFalseValue = false;

        //  String class
            String myString = "This is a string";
            System.out.println("My statement is " + myString);

            myString = myString + " and some other stuff";
            System.out.println("My statement is " + myString);

            String numberString = "205.55";
            numberString = numberString + "49.95"; // will not add anything, will only append it to the end

            String lastString = "10";
            int myInt = 50;
            lastString = lastString + myInt;
            System.out.println("Last String equal to " + lastString);


    }
}
