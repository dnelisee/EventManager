package com.polytechnique.finaltppoo2.model;

import com.polytechnique.finaltppoo2.model.Event.EventState;

public class Participant extends Person implements EventObserver {

    /* attribute due to observer design pattern */
    private EventState state;

    @Override
    public void update(Event.EventState state) {

    }
}
