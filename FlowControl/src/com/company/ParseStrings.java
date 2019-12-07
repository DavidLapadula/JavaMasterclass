package com.company;

public class ParseStrings {

    public static void main(String[] args) {
        String numberAsString = "2020";
        System.out.println("Num as string "  + numberAsString);

        int number = Integer.parseInt(numberAsString);
        System.out.println("Num as number " + number);

        numberAsString += 1;
        number += 1;

        System.out.println("Concat num " + numberAsString);
        System.out.println("Reg num add " + number);

    }
}
