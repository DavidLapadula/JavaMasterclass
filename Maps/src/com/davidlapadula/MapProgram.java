package com.davidlapadula;

import java.util.*;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "compiled, high level, OO, platform independant");
        languages.put("Python", "high level, interpreted, OO, dynamic semantics");
        languages.put("Algol", "algorithmic language");

        // Return value associated with the key
        System.out.println(languages.get("Java"));
        System.out.println(languages.get("Python"));
        System.out.println(languages.get("Algol"));
        if (languages.containsKey("Java")) {
            System.out.println("Java is here");
        }


        System.out.println("+==============================================");

        languages.remove("Algol");
        languages.replace("Python", "Good for data science");
        languages.replace("Go", "Compiles fast");
        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
