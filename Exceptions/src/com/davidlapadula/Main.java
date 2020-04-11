package com.davidlapadula;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = getIntLBYL();
        System.out.println("X is: " + x);
    }

    private static int divide (int x, int y) {
        return x / y;
    }

    private static int divideLBLY(int x, int y) {
        // LBYL test condition first
        if (y != 0) {
            return x / y;
        }
        return 0;
    }

    private static int divideEAFP(int x, int y) {
        // EAFP, just do it than catch exception if goes wrong
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input below: ");
        return  scanner.nextInt();
    }

    private static int getIntLBYL() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter a number: ");
        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return Integer.parseInt(input);
        }

        return 0;

    }

    private static int getIntEAFP() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

}
