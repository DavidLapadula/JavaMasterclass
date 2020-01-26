package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;

    // Initialize ArrayList in constructor when new objects are made
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    // For each version in java; creates variable for every entry in array list
    // Method used to ensure there are no duplicates in the list
    private Song findSong(String title) {
        for (Song checkedSong: this.songs) {
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addtoPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addtoPlaylist(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("Song called " + title + " not in this playlist");
        return false;
    }

}
