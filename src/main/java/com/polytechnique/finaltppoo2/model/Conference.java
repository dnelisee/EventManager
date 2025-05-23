package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public class Conference extends Event {

    /* attributes given by System class diagram */
    private String theme;

    
    public Conference() {
    }

    /* normal constructor */
    public Conference(String id, String name, LocalDateTime date, String location, int maxCapacity, String theme) {
        if (!ValidatableField.NAME.validate(name)) {
            throw new LengthException(ValidatableField.NAME);
        } else if (!ValidatableField.LOCATION.validate(location)) {
            throw new LengthException(ValidatableField.LOCATION);
        } else if (!ValidatableField.THEME.validate(theme)) {
            throw new LengthException(ValidatableField.THEME);
        } else {
            this.id = id;
            this.name = name;
            this.date = date;
            this.location = location;
            this.maxCapacity = maxCapacity;
            this.state = EventState.PROGRAMMED;
            this.theme = theme;
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

    public String getTheme() {
        return theme;
    }
}
