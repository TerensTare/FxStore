package models;

import java.io.Serializable;

public class Cd implements Serializable {
    private String title;
    private String artist;
    private String genre;
    private int year;
    private int id;
    private int price;

    public Cd(String title, String artist, String genre,
            int year, int id, int price) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.id = id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}