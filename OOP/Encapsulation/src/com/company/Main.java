package com.company;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "David";
        player.health = 5;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health is " + player.healthRemaining());

        damage = 11;
        player.loseHealth(damage);
        System.out.println("Remaining health is " + player.healthRemaining());

        EnhancedPlayer Eplayer = new EnhancedPlayer("David", 50, "Knife");
        System.out.println("Eplayer health is " + Eplayer.getHealth());
    }
}
