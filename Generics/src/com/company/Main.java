package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    /*
	        Generics
	            - Arraylist is generic type, should not use raw types because not safe if different types passed in
	            - Use to prevent errors that occur at compile time
	            - Parameterized type, specify type of generic with <> in declaration.
	            - Use T in class declaration to what type you want to enforce, this gets replaced with the type
	            - The assign generic class the type to enforce what type of data can be passed in
	            - Can also use bounded types: to prevent what types are used in the generic and can be passed into the class
                    - Make <T extends Player> in class definition extend a type of class to restrict the type of class can be passed in instantiation
                    - Argument passed to typo parameter can be a class or an interface
                    - Interface them self can also specify type parameter; interface will only be able to act on specific instances
                - Java allows for multiple bounds but normals rules of inheritance is allows (class must be first)
                - Static sort method of Collections class: can be used to sort objects. Uses compareTo function to sort the objects
	     */

	    // Basic Array List test
	    ArrayList<Integer> items = new ArrayList<>();
	    items.add(1);
	    items.add(2);
	    items.add(3);
	    items.add(4);
	    printDoubled(items);

	    // Own player generic made
        FootballPlayer joe = new FootballPlayer("joe");
        BaseballPlayer pat = new BaseballPlayer("pat");
        SoccerPlayer steve = new SoccerPlayer("steve");

        Team<FootballPlayer> toronto = new Team<>("Toronto");
        Team<BaseballPlayer> montreal = new Team<>("Montreal");
        toronto.addPlayer(joe);
        montreal.addPlayer(pat);
//        toronto.addPlayer(steve);

        System.out.println(toronto.numPlayers());

        System.out.println("Rankings");
        System.out.println(toronto.ranking());

    }

    private static void printDoubled(ArrayList<Integer> n) {
        for (int i : n) {
            // Need to tell Java what type is being stored in ArrayList
            // Problem if want to store different types in the Arraylist
            System.out.println(i * 2);
        }
    }
}
