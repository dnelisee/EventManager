package com.polytechnique.finaltppoo2.model;

public class Participant extends Person implements EventObserver {

    /* attribute due to observer design pattern */
    private EventState state;

    @Override
    public void update(EventState state) {
        // ... 
    }

    public EventState getState() {
        return state;
    }
}
