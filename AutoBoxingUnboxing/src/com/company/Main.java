package com.company;

import java.util.ArrayList;

public class Main {

    /*
        - Cannot have Array list with primitive type as parameter
        - Needs to be passed a class for the parameter
        - Each primitive type has a wrapper class. Could pass this to array list
        - Autoboxing: Primitve type to wrapper (valueOf example)
            - Do not need to do valueOf, at compile time will do so to create correct class even with shortcut
        - AutoUnboxing: Wrapper to Primitive (intValue example)
            - Java will also go the other way, can make int equal to Integer value and reconvert the wrapper back to primitve class
     */

    public static void main(String[] args) {
        ArrayList<Integer>  intArrayList = new ArrayList<Integer>();

        for (var i = 0; i < 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        for (var i = 0; i < 10; i++) {
            System.out.println(i + "------------->" + intArrayList.get(i).intValue());
        }

        // Shortform Autoboxing and Unboxing
        Integer myIntValue = 787;
        int myInt = myIntValue;
    }
}
