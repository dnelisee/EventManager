package com.polytechnique.finaltppoo2.model;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Event implements ObservableEvent{

    /* enumeration due to observer design pattern*/
    public enum EventState {
        PROGRAMMED, CANCELED
    }

    /* attributes given by System class diagram */
    private String id;
    private String name;
    private LocalDateTime date;
    private String location;
    private int maxCapacity;

    /* attribute due to observer design pattern */
    private EventState state;
    private List<Participant> participants;

    /* abstract methods */
    public abstract void displayDetails();

    /* non-abstract methods */
    public void cancel() {
        this.state = EventState.CANCELED;
    }



}
