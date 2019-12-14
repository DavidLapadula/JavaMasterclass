package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal(1, 1, 1, 5, "Animal");
        Dog dog = new Dog(5, 50, "Yorkie", 2, 4, 1, 20, "Silky");

        dog.eat();
        dog.move();
    }
}
