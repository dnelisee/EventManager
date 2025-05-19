package com.polytechnique.finaltppoo2.dao;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class EventIndex {
    private Map<String, String> eventTypes; // ID -> "conference" or "concert" ... 

    private LocalDateTime lastUpdated;

    public EventIndex() {
        eventTypes = new HashMap<>(); 
        lastUpdated = LocalDateTime.now(); 
    }

    public void displayEvents() {
        for(Entry<String, String> entry : eventTypes.entrySet())
            System.out.println(String.format("\"%s\" : \"%s\"",entry.getKey(), entry.getValue()));
    }

    public Map<String, String> getEventTypes() {
        return eventTypes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    } 
    
}
