package com.davidlapadula;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adventure {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(1, new Location(1, "Location 1"));
        locations.put(2, new Location(2, "Location 2"));
        locations.put(3, new Location(3, "Location 3"));

        int loc = 1;

        while(true){
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) break;

            loc = scanner.nextInt();
            if (!locations.containsKey(loc)) {
                System.out.println("Wrong direction");
            }
        }

    }
}
