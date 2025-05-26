package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public abstract class Event extends PersisObject implements ObservableEvent{

    /* attributes given by System class diagram */
    protected LocalDateTime date;
    protected String location;
    protected int maxCapacity;

    /* attribute due to observer design pattern */
    protected EventState state;

    /**
     * for (de) serialization 
     */
    protected Event() {
        
    }

    protected Event(String id, String name, LocalDateTime date, String location, int maxCapacity) {
        if (!ValidatableField.NAME.validate(name)) {
            throw new LengthException(ValidatableField.NAME);
        } else if (!ValidatableField.LOCATION.validate(location)) {
            throw new LengthException(ValidatableField.LOCATION);
        } else {
             this.id = id;
            this.name = name;
            this.date = date;
            this.location = location;
            this.maxCapacity = maxCapacity;
        }
    }

    /* abstract methods */
    public abstract void displayDetails();

    /* non-abstract methods */
    public void cancel() {
        this.state = EventState.CANCELED;
    }

    /* getters */
    public LocalDateTime getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public EventState getState() {
        return state;
    }

    public void setState(EventState state) {
        this.state = state;
    }
}
