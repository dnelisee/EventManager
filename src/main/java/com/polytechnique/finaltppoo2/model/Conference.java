package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public class Conference extends Event {

    /* attributes given by System class diagram */
    private String theme;

    /* normal constructor */
    public Conference(String id, String name, LocalDateTime date, String location, int maxCapacity, String theme) {
        super(id, name, date, location, maxCapacity);

        if (!ValidatableField.THEME.validate(theme)) {
            throw new LengthException(ValidatableField.THEME);
        } else {
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
