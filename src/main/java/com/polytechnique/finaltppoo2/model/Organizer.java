package com.polytechnique.finaltppoo2.model;

import java.util.List;

public class Organizer extends Person {

    public Organizer(String id, String name, String email) {
        super(id, name, email);
    }

    public List<Event> getOrganizedEvents() {
        return events;
    } 
}
