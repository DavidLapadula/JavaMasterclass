package com.company;

import java.util.ArrayList;

// Generic type as parameter to comparable interface. Make sure you dont compare different type of teams
// Many classes implement comparable like String, which is how sort works
public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + "already on the team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + "added");
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    // negative if this less than, 0 for equal, 1 for greater than
    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return -1;
        }

        if (this.ranking() < team.ranking()) {
            return 1;
        }

        return 0;
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
            if (ourScore > theirScore) {
                won++;
            } else if (ourScore == theirScore) {
                tied ++;
            } else {
                lost ++;
            }
            played++;
            if (opponent != null) {
                opponent.matchResult(null, theirScore, ourScore);
            }
    }

    public int ranking() {
        return (won * 2) + tied;
    }
}
