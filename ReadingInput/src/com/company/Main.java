package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    // Name gathering
        System.out.println("Enter your name : ");
        String name = scanner.nextLine();

        // Birthday gathering
        System.out.println("Enter your birth year: ");
        int yearOfBirth = scanner.nextInt();
        int age = 2019 - yearOfBirth;

        System.out.println("Hello " + name + " You were born in " + yearOfBirth + ". Making you " + age + " years old." );

        scanner.close();


    }
}
