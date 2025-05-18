package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class Event implements ObservableEvent{
    /* enumeration due to observer design pattern*/
    public enum EventState {
        PROGRAMMED, CANCELED
    }

    /* attributes given by System class diagram */
    protected String id;
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
    public String getId() {
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
