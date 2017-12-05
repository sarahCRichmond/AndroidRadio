package com.example.pchan.mysqldemo;

public class Music {
    private String name ;
    private String artist;
    private int song;
    private String publisher;
    private int year;
    private String length;
    private int art;
    public Music(String name, String artist, int song,String publisher,int year,String length,int art) {
        this.name = name;
        this.artist = artist;
        this.song = song;
        this.publisher = publisher;
        this.year = year;
        this.length = length;
        this.art=art;
    }
    public String getLength (){return length;}
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public int getArt(){return art;}
    public int getSong() {
        return song;
    }
    public int getYear(){return year;}
    public String getPublisher(){return publisher;}

}
