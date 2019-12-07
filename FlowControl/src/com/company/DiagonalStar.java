package com.company;

public class DiagonalStar {

    public static void printSquareStar(int number) {
        if (number >= 5) {
            for (int col = 0; col < number; col ++) {
                 for (int row = 0; row < number; row ++) {
                     if (
                         (row == 0 || row == number - 1) ||
                         (col == 0 || col == number - 1) ||
                         (row == col) ||
                         (col == (number - (row + 1)))
                     )
                     {
                         System.out.print("*");
                     } else {
                         System.out.print(" ");
                     };
                 };
                System.out.println();
            };
        } else {
            System.out.println("Invalid Value");
        }
    };
}
