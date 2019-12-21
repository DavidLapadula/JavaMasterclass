package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Using test class
	    Car porsche = new Car();
	    porsche.setModel("Carrera");

	    // Test account features
        Account davidAccount = new Account();
        davidAccount.withDrawal(100);

        Account otherAccount = new Account("123456", 0.00, "David", "david@email.com", "4165569985");
        System.out.println(otherAccount.getCustomerName());

        Account nextAccount = new Account();
        System.out.println(nextAccount.getCustomerName());

        // Points Challenge
        Point first = new Point(6,5);
        Point second = new Point(3,1);

        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        Point point = new Point();
        System.out.println("distance()= " + point.distance());

        // Complex Number challenge
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1, 1);

    }
}
