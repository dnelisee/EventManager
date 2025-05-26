package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public class Concert extends Event {
    private String artist;
    private String musicalGenre;

    public Concert(String id, String name, LocalDateTime date, String location, int maxCapacity, String artist,
            String musicalGenre) {
        super(id, name, date, location, maxCapacity);

        if (!ValidatableField.MUSICAL_GENRE.validate(musicalGenre)) {
            throw new LengthException(ValidatableField.MUSICAL_GENRE);
        } else {
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
}
