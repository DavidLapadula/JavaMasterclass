package com.company;

public class Main {

    public static void main(String[] args) {
        // Speed Converter Challenge

        System.out.println("Speed Converter Test");
        long miles = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles " + miles);
        SpeedConverter.printConversion(10.5);
        System.out.println("--------------------------------");

        // KB to MD Challenge
        System.out.println("KB to MB Challenge");
        MegabytesConverter.printMegaBytesAndKiloBytes(2500);
        MegabytesConverter.printMegaBytesAndKiloBytes(0);
        MegabytesConverter.printMegaBytesAndKiloBytes(-5);
        System.out.println("--------------------------------");

        // Barking Dog Challenge
        System.out.println("Barking Dog Challenge");
        System.out.println(BarkingDog.shouldWakeUp(true, 1));
        System.out.println(BarkingDog.shouldWakeUp(false, 2));
        System.out.println(BarkingDog.shouldWakeUp(true, 8));
        System.out.println(BarkingDog.shouldWakeUp(true, -1));
        System.out.println("--------------------------------");
    }
}
