package com.company;

import java.sql.SQLOutput;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog( int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
        super(1, 1, size, weight, name);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog chew called");
    };

    @Override
    public void eat() {
        System.out.println("Dog.eat called");
        chew();
        super.eat();
    }

    public void walk() {
        move(5);
        System.out.println("Dog Walking");
    }

    public void run() {
        move(10);
        System.out.println("Dog running");
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move called");
        moveLegs(speed);
        super.move(speed);
    }
}
