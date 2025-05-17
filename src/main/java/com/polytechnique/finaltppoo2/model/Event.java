package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;

public abstract class Event implements ObservableEvent{
    /* enumeration due to observer design pattern*/
    public enum EventState {
        PROGRAMMED, CANCELED
    }

    /* final attributes */
    protected final int NAME_LENGHT = 25; 
    protected final int LOCATION_LENGHT = 50;

    /* attributes given by System class diagram */
    protected int id;
    protected String name;
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
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

}
