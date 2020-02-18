package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    /*
	        Generics
	            - Arraylist is generic type, should not use raw types because not safe if different types passed in
	            - Parameterized type, specify type of generic with <> in declaration.
	     */

	    ArrayList<Integer> items = new ArrayList<>();
	    items.add(1);
	    items.add(2);
	    items.add(3);
	    items.add(4);

	    printDoubled(items);
    }

    private static void printDoubled(ArrayList<Integer> n) {
        for (int i : n) {
            // Need to tell Java what type is being stored in ArrayList
            // Problem if want to store different types in the Arraylist
            System.out.println(i * 2);
        }
    }
}
