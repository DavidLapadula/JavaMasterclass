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

        // Equal Sum Checker
        System.out.println("Equal Sum Challenge");
        System.out.println(EqualSumChecker.hasEqualSum(1, 1, 1));
        System.out.println(EqualSumChecker.hasEqualSum(1, 1, 2));
        System.out.println(EqualSumChecker.hasEqualSum(1, -1, 0));
        System.out.println("--------------------------------");

        // Teen Number Checker
        System.out.println("Teen Number Challenge");
        System.out.println(TeenNumberChecker.hasTeen(9, 19, 99));
        System.out.println(TeenNumberChecker.hasTeen(23, 15, 42));
        System.out.println(TeenNumberChecker.hasTeen(22, 23, 34));
        System.out.println("--------------------------------");

        // Seconds and Minutes challenge
        System.out.println("Seconds and minutes Challenge");
        System.out.println(SecondsAndMinutes.getDurationString(-5, 30));
        System.out.println(SecondsAndMinutes.getDurationString(180, -5));
        System.out.println(SecondsAndMinutes.getDurationString(180, 180));
        System.out.println(SecondsAndMinutes.getDurationString(65, 30));
        System.out.println(SecondsAndMinutes.getDurationString(135, 40));
        System.out.println(SecondsAndMinutes.getDurationString(195, 50));
        System.out.println(SecondsAndMinutes.getDurationString(-5));
        System.out.println(SecondsAndMinutes.getDurationString(3600));
        System.out.println(SecondsAndMinutes.getDurationString(5000));
        System.out.println("--------------------------------");

        // Area Calculator Challenge
        System.out.println("Area Calculator Challenge");
        System.out.println(AreaCalculator.area(5.0));
        System.out.println(AreaCalculator.area(-1));
        System.out.println(AreaCalculator.area(5.0, 4.0));
        System.out.println(AreaCalculator.area(-1.0, 4.0));
        System.out.println("--------------------------------");

        // Minutes to years and days Challenge
        System.out.println("Minutes to years and days Challenge");
        MinutesToYearsDaysCalculator.printYearsAndDays(-5);
        MinutesToYearsDaysCalculator.printYearsAndDays(525600);
        MinutesToYearsDaysCalculator.printYearsAndDays(1051200);
        MinutesToYearsDaysCalculator.printYearsAndDays(561600);
        System.out.println("--------------------------------");

        // Equality Challenge
        System.out.println("Equality Challenge");
        IntEqualityPrinter.printEqual(-5, 0, 0);
        IntEqualityPrinter.printEqual(1, 1, 1);
        IntEqualityPrinter.printEqual(1, 1, 2);
        IntEqualityPrinter.printEqual(-1, -1, -1);
        IntEqualityPrinter.printEqual(1, 2, 3);
        System.out.println("--------------------------------");

        //Playing Cat
        System.out.println("Playing Cat Challenge");
        System.out.println(PlayingCat.isCatPlaying(true, 10));
        System.out.println(PlayingCat.isCatPlaying(false, 36));
        System.out.println(PlayingCat.isCatPlaying(false, 35));
        System.out.println("--------------------------------");


    }
}
