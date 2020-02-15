package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Challenge {
    private String name;
    private String artist;
    private SongList songs;

    // Initialize ArrayList in constructor when new objects are made
    public Challenge(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public void addSong(String title, double duration) {
        this.songs.add(new Song(title, duration));
    }

    public boolean addtoPlaylist(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addtoPlaylist(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("Song called " + title + " not in this playlist");
        return false;
    }

    /*
        Use inner class to house methods related to a song list
     */
    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        // For each version in java; creates variable for every entry in array list
        // Method used to ensure there are no duplicates in the list
        private Song findSong(String title) {
            for (Song checkedSong : this.songs)
            {
                if (checkedSong.getTitle().equals(title))
                {
                    return checkedSong;
                }
            }
            return null;

        }

        public Song findSong (int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index < songs.size())){
                return songs.get(index);
            }
            return null;
        }
    }

}
