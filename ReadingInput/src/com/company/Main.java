package com.company;

public class Main {

    public static void main(String[] args) {
//	    Scanner scanner = new Scanner(System.in);
//
//	    // Name gathering
//        System.out.println("Enter your name : ");
//        String name = scanner.nextLine();
//
//        // Birthday gathering
//        System.out.println("Enter your birth year: ");
//        int yearOfBirth = scanner.nextInt();
//        int age = 2019 - yearOfBirth;
//
//        System.out.println("Hello " + name + " You were born in " + yearOfBirth + ". Making you " + age + " years old." );
//
//        scanner.close();

        // Paint job challenge
        System.out.println("With Extra buckets param");
        System.out.println(PaintJob.getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(PaintJob.getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(PaintJob.getBucketCount(2.75, 3.25, 2.5, 1));
        System.out.println("---------------------------");
        System.out.println("No Extra buckets param");
        System.out.println(PaintJob.getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(PaintJob.getBucketCount(3.4, 2.1, 1.5));
        System.out.println(PaintJob.getBucketCount(7.25, 4.25, 2.35));
        System.out.println("---------------------------");
        System.out.println("Only area param");
        System.out.println(PaintJob.getBucketCount(-3.4, 1.5));
        System.out.println(PaintJob.getBucketCount(3.4, 1.5));
        System.out.println(PaintJob.getBucketCount(6.26, 2.2));
        System.out.println(PaintJob.getBucketCount(3.26, 0.75));
        System.out.println("---------------------------");

    }
}
