package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

public abstract class Event extends PersisObject implements ObservableEvent{

    /* attributes given by System class diagram */
    protected LocalDateTime date;
    protected String location;
    protected int maxCapacity;

    /* attribute due to observer design pattern */
    protected EventState state;

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
