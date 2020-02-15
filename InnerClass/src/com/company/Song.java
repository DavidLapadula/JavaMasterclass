package com.company;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    /*
        All objects have toString(), so must be overridden. Default behaviour is to print out memory location
        This will print items of object out as a string
     */
    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
