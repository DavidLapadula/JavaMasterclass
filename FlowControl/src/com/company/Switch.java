package com.company;

public class Switch {
    public static void basicSwitch() {
            int switchValue = 1;

            switch (switchValue) {
                case 1:
                    System.out.println("Case is 1");
                    break;
                case 2:
                    System.out.println("Case is 2");
                    break;
                default:
                    System.out.println("Not anything");
                    break;
            }
    }

    public static void charSwitch() {
        char switchValue = 'A';

        switch (switchValue) {
            case 'A':
                System.out.println("Case is A");
                break;
            case 'B':
                System.out.println("Case is B");
                break;
            default:
                System.out.println("Neither A nor B");
                break;
        }
    }

    public static void printNumberInWord(int number) {
        switch (number) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }

    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;

        if (year >= 1 && year <= 9999) {
            isLeapYear =  (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        };

        return isLeapYear;
    }

    public static int getDaysInMonth(int month, int year) {
        int daysInMonth = -1;

        if((month >= 1 && month <= 12) && (year >= 1 && year <= 9999)) {
            switch (month) {
                case 1:
                    daysInMonth = 31;
                    break;
                case 2:
                    if (isLeapYear(year)) {
                        daysInMonth = 29;
                    } else {
                        daysInMonth = 28;
                    }
                    break;
                case 3:
                    daysInMonth = 31;
                    break;
                case 4:
                    daysInMonth = 30;
                    break;
                case 5:
                    daysInMonth = 31;
                    break;
                case 6:
                    daysInMonth = 30;
                    break;
                case 7:
                    daysInMonth = 31;
                    break;
                case 8:
                    daysInMonth = 31;
                    break;
                case 9:
                    daysInMonth = 30;
                    break;
                case 10:
                    daysInMonth = 31;
                    break;
                case 11:
                    daysInMonth = 30;
                    break;
                case 12:
                    daysInMonth = 31;
            }
        }

        return daysInMonth;
    }
}
