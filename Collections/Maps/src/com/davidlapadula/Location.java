package com.davidlapadula;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map <String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // create new map in constructor to make class immutable; otherwise removing it from the map passed in would also remove it from the class
        // Also cannot make new hashmap from null param so need to check it
        if (exits != null) {
            this.exits = new HashMap<>(exits);
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        // Initialize new object and put existing object in the constructor. Prevents anything outside class from changing exits
        return new HashMap<String, Integer>(exits);
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }
}
