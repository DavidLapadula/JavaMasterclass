package com.company;

public class Main {

    public static void main(String[] args) {
        // Switch methods
        System.out.println("Basic Challenges");
	    Switch.basicSwitch();
	    Switch.charSwitch();
        System.out.println("---------------------------");

        // Number in Word challenge
        System.out.println("Number in Word challenge");
	    Switch.printNumberInWord(1);
        Switch.printNumberInWord(2);
        Switch.printNumberInWord(3);
        Switch.printNumberInWord(-1);
        System.out.println("---------------------------");

        // Leap Year challenge
        System.out.println("Leap Year Challenge");
        System.out.println(Switch.isLeapYear(-1600));
        System.out.println(Switch.isLeapYear(1600));
        System.out.println(Switch.isLeapYear(2017));
        System.out.println(Switch.isLeapYear(2000));
        System.out.println("---------------------------");

        // Days in Month Challenge
        System.out.println("Days in month challenge");
        System.out.println(Switch.getDaysInMonth(1, 2020));
        System.out.println(Switch.getDaysInMonth(2, 2020));
        System.out.println(Switch.getDaysInMonth(2, 2018));
        System.out.println(Switch.getDaysInMonth(-1, 2020));
        System.out.println(Switch.getDaysInMonth(1, -2020));
        System.out.println("---------------------------");

        // Number Palidrome Challenge
        System.out.println("Number palindrome challenge");
        System.out.println(NumberPalindrome.isPalindrome(-1221));
        System.out.println(NumberPalindrome.isPalindrome(707));
        System.out.println(NumberPalindrome.isPalindrome(11212));
        System.out.println("---------------------------");

        // First and last digit sum challenge
        System.out.println("First and last digit sum challenge");
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(252));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(257));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(0));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(5));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(-10));
        System.out.println("---------------------------");

        // Even Digit Sum Challenge
        System.out.println("First and last digit sum challenge");
        System.out.println(EvenDigitSum.getEvenDigitSum(123456789));
        System.out.println(EvenDigitSum.getEvenDigitSum(252));
        System.out.println(EvenDigitSum.getEvenDigitSum(-22));
        System.out.println("---------------------------");

        // Flour Pack Problem
        System.out.println("Flour pack problem challenge");
        System.out.println(FlourPack.canPack(1, 0, 4));
        System.out.println(FlourPack.canPack(1, 0, 5));
        System.out.println(FlourPack.canPack(0, 5 , 4));
        System.out.println(FlourPack.canPack(2, 2, 11));
        System.out.println(FlourPack.canPack(-3, 2, 12));
        System.out.println(FlourPack.canPack(4, 18, 19));
        System.out.println("---------------------------");

        // Get Largest Prime Challenge
        System.out.println("Flour pack problem challenge");
        System.out.println(LargestPrime.getLargestPrime(21));
        System.out.println(LargestPrime.getLargestPrime(217));
        System.out.println(LargestPrime.getLargestPrime(0));
        System.out.println(LargestPrime.getLargestPrime(45));
        System.out.println(LargestPrime.getLargestPrime(-1));
        System.out.println("---------------------------");

        // Diagonal Star Challenge
        System.out.println("Diagonal Star Challenge");
        DiagonalStar.printSquareStar(4); 
        DiagonalStar.printSquareStar(5); 
        DiagonalStar.printSquareStar(8); 
        System.out.println("---------------------------");


    }
}
