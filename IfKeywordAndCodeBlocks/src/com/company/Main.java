package com.company;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;
	    int score = 5000;
	    int levelCompleted = 5;
	    int bonus = 100;

	    if (score == 5000) {
            System.out.println("Your score was 5000");
        } else {
            System.out.println("Your score was not 5000");
        };

	    // if will catch the line after it even without the braces
	    if (score == 500)
            System.out.println("Your score was 5000");

	    if (gameOver) {
	        int finalScore = score + (levelCompleted * bonus);
            System.out.println("Final score is " + finalScore);
        };



    }
}
