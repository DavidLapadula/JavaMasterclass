package com.davidlapadula;

import java.util.*;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

//        System.out.println(squares.size() + " squares");
//        System.out.println(cubes.size() + " cubes");

        // New variable to prevent mutation because bulk operations are destructive
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        // Will remove duplicates
//        System.out.println("union size " + union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        // intersection will hold the duplicates that would be removed from a union
        intersection.retainAll(cubes);
        System.out.println("Intersection size " + intersection.size());

        for (int i: intersection) {
//            System.out.println("Square " + Math.sqrt(i));
//            System.out.println("Cube " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "One day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        // In built method from collections to make an array as list so can be stored as such
        words.addAll(Arrays.asList(arrayWords));

        for (String s: words) {
//            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "uknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "fogive", "is", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine: " );
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature : " );
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);


        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric Difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine)){
            System.out.println("divine subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection subset of nature");
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection subset of divine");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.println("\t");
        for (String s: set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
