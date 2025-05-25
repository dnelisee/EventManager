package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class Event extends PersisObject implements ObservableEvent{

    /* attributes given by System class diagram */
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

    public void setState(EventState state) {
        this.state = state;
    }

    @Override
    public Map<String, String> getAllAttributes() {
        Map<String, String> map = super.getAllAttributes();

        map.put("name", name); 
        map.put("date", date.toString());
        map.put("location", location);
        map.put("max capacity", String.valueOf(maxCapacity));

        return map;
    }

}
