package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public class Concert extends Event{
    private String artist;
    private String musicalGenre;

    
    public Concert() {
    }
    
    public Concert(String id, String name, LocalDateTime date, String location, int maxCapacity, String artist, String musicalGenre) {
        if (!ValidatableField.NAME.validate(name)) {
            throw new LengthException(ValidatableField.NAME);
        } else if (!ValidatableField.LOCATION.validate(location)) {
            throw new LengthException(ValidatableField.LOCATION);
        } else if (!ValidatableField.MUSICAL_GENRE.validate(musicalGenre)) {
            throw new LengthException(ValidatableField.MUSICAL_GENRE);
        } else {
            this.id = id;
            this.name = name;
            this.date = date;
            this.location = location;
            this.maxCapacity = maxCapacity;
            this.artist = artist;
            this.musicalGenre = musicalGenre;
            this.state = EventState.PROGRAMMED;
        }
    }

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

    @Override
    public Map<String, String> getAllAttributes() {
        Map<String, String> list = super.getAllAttributes();

        list.put("artist", artist);
        list.put("musical genre", musicalGenre);

        return list;
    }
}
