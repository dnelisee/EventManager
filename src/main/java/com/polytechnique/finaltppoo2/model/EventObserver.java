package com.polytechnique.finaltppoo2.model;

public interface EventObserver {
    void update(String eventId, EventState newState);
}
