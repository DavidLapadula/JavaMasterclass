package com.davidlapadula;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StackCallTrace {
    public static void main(String[] args) {

        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e) { // Can catch multiple here; more elegant
            System.out.println(e.toString());
            System.out.println("Cant perform division");
        }
    }

    private static int divide() {
        int x;
        int y;

        try {
            x = getInt();
            y = getInt();
            return x / y;
        } catch (NoSuchElementException e ){
            throw new NoSuchElementException("Improper Input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by 0");
        }

    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");

        while(true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a number from 0-9: ");
            }
        }
    }
}
