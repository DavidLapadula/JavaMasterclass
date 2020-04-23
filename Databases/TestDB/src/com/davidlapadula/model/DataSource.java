package com.davidlapadula.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONN_STRING = "jdbc:sqlite:C:\\Users\\DavidLapadula\\Downloads\\" + DB_NAME;
    private Connection conn;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONN_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not open DB");
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException e) {
            System.out.println("Could not close DB");
            e.printStackTrace();
        }
    }

    

}
