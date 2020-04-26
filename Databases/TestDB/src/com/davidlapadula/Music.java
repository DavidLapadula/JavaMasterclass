package com.davidlapadula;

import com.davidlapadula.model.*;

import java.util.List;

public class Music {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Cant open");
            return;
        }
        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("Mo artists");
            return;
        }
        for (Artist artist: artists) {
            System.out.println(artist.getId() + "-" + artist.getName() + "-"  +artist.getName());
        }

        List <String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
        for (String album: albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistForSong("Heartless", DataSource.ORDER_BY_ASC);
        if (songArtists != null) {
            for (SongArtist artist: songArtists) {
                System.out.println(artist.getArtistName() + "-" + artist.getAlbumName() + "-"  + artist.getTrack());
            }
        } else {
            return;
        }

        songArtists = dataSource.querySongInfoView("Go Your Own Way");
         if (songArtists.isEmpty()) {
             System.out.println("Could not find artists");
        }

        for (SongArtist artist: songArtists) {
            System.out.println(artist.getArtistName() + "-" + artist.getAlbumName() + "-"  + artist.getTrack());
        }

        dataSource.insertSong("Touch of Grey", "Grateful dead", "In The Dark", 1);

        dataSource.close();
    }
}
