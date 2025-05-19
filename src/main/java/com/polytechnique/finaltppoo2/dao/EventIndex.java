package com.polytechnique.finaltppoo2.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class EventIndex {
    private HashMap<String, String> eventTypes; // ID -> "conference" or "concert" ... 

    private LocalDateTime lastUpdated;

    public EventIndex() {
        eventTypes = new HashMap<>(); 
        lastUpdated = LocalDateTime.now(); 
    }

    public void displayEvents() {
        Logger logger = Logger.getLogger(getClass().getName()); 

        for(Entry<String, String> entry : eventTypes.entrySet())
            logger.info(String.format("\"%s\" : \"%s\"",entry.getKey(), entry.getValue()));
    }

    public HashMap<String, String> getEventTypes() {
        return eventTypes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    } 
    
}
