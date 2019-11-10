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

        // Leap Year Calculator
        System.out.println("Leap Year Challenge");
        System.out.println(LeapYear.isLeapYear(-1600));
        System.out.println(LeapYear.isLeapYear(1600));
        System.out.println(LeapYear.isLeapYear(2017));
        System.out.println(LeapYear.isLeapYear(2000));
        System.out.println("--------------------------------");

        //Decimal Operator
        System.out.println("Decimal Operator Challenge");
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.175,3.176));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.0,3.0));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.123,3.123));
        System.out.println("--------------------------------");

    }
}
