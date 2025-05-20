package com.polytechnique.finaltppoo2.model;

import java.util.List;

public class Participant extends Person implements EventObserver {

    public Participant(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void update(String eventId, EventState newState) {
        for(Event event : events) {
            if(event.getId() == eventId) {
                event.setState(newState);
            }
        }
    }

    public List<Event> getparticipatedEvents() {
        return events;
    }
}
