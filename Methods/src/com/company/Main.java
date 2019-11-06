package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main executed");

        // Simple Method testing
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 800;
        int scoreOne = calculateScore(gameOver, score, levelCompleted, bonus);
        int scoreTwo = calculateScore(true, 10000, 8, 200);

        // Challenge
        displayHighScorePosition("David", 1);
        System.out.println("Highest is " + calculateHighScorePosition(1500));
        System.out.println("Second Highest is " + calculateHighScorePosition(900));
        System.out.println("Third Highest is " + calculateHighScorePosition(400));
        System.out.println("Lowest is " + calculateHighScorePosition(50));

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        }
        return -1;
    };

    public static void displayHighScorePosition(String player, int position) {
        System.out.println(player + " got into positon " + position + " on the high score table");
    }

    public static int calculateHighScorePosition(int score) {
         if (score >= 1000 ) return 1;
         if (score >= 500 && score < 1000 ) return 2;
         if (score >= 100 && score < 500 ) return 3;
         return 4;
    };
}
