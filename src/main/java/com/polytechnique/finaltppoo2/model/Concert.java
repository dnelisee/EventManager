package com.polytechnique.finaltppoo2.model;

public class Concert extends Event{
    private String artist;
    private String musicalGenre;

    /*  
    * this default constructor is for (de)serialization by jackson
    */
    public Concert() {}

    @Override
    public void displayDetails() {
        // .. 
    }

    @Override
    public void addObserver(EventObserver observer) {
        // .. 
    }

    @Override
    public void removeObserver(EventObserver observer) {
        // .. 
    }

    @Override
    public void notifyObserver() {
        // .. 
    }

    public String getArtist() {
        return artist;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }
}
