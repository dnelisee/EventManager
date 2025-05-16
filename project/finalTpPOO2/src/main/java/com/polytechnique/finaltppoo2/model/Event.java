package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Event implements ObservableEvent{

    public enum EventState {
        PROGRAMMED, CANCELED
    }

    private String id;
    private String name;
    private LocalDateTime date;
    private String location;
    private int capacityMax;
    private EventState state;
    private List<Participant> participants;

    public abstract void displayDetails();

    public void cancel() {
        this.state = EventState.CANCELED;
    }



}
