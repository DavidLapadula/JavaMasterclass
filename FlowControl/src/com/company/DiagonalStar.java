package com.company;

public class DiagonalStar {

    public static void printSquareStar(int number) {
        if (number >= 5) {
            System.out.println(">>>>>>>>>>>>>>>>>>>");
            for (int col = 0; col < number; col++) {
                System.out.println("*");;
            };
        } else {
            System.out.println("Invalid Value");
        }
    };
}
