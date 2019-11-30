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



    }
}
