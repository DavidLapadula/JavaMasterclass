package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Feet to Centimeters");
        System.out.println(calcFeetAndInchesToCentimeters(157));
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed Player " + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name or score");
        return 0;
    }

    // Overloading challenges
    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || inches < 0 || inches > 12) {
            return -1;
        }
        feet = feet * 12;
        return (feet + inches) * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }
        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;

        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

}
