package com.polytechnique.finaltppoo2.model;

import java.util.ArrayList;
import java.util.List;

public class Participant extends Person implements EventObserver {

    /**
     * for (de)serialization
     */
    public Participant() {

    }

    public Participant(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void update(String eventId, EventState newState) {
        for(Event event : events) {
            if(event.getId().equals(eventId)) {
                event.setState(newState);
            }
        }
    }

    public List<Event> getEventsParticipated() {
        return events;
    }

    public void setEventsParticipated(List<Event> eventsParticipated) {
        this.events = eventsParticipated != null ? eventsParticipated : new ArrayList<>();
    }

}
