package com.davidlapadula;

public class DogMain {

    public static void main(String[] args) {
       Labrador rover = new Labrador("Rover");
       Dog rover2 = new Dog("Rover");

       // Subclass instance of parent, but parent is not instance of subclass
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }

}
