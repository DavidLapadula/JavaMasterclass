package com.davidlapadula;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        // this only returns true if comparing against the same object in memory
        if (this == obj) return true;

        // All instances including subclass will return true here
        if(obj instanceof Dog) {
            // If object being compared is instance of dog, compare the name of the class to this class to determine if they are the same
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }
}
