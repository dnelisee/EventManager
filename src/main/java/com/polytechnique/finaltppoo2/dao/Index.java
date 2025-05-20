package com.polytechnique.finaltppoo2.dao;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Index {
    private Map<String, String> persisObjectTypes; // ID -> Object

    private LocalDateTime lastUpdated;

    public Index() {
        persisObjectTypes = new HashMap<>(); 
        lastUpdated = LocalDateTime.now(); 
    }

    public void display() {
        for(Entry<String, String> entry : persisObjectTypes.entrySet())
            System.out.println(String.format("\"%s\" : \"%s\"",entry.getKey(), entry.getValue()));

        System.out.println(lastUpdated.toString());
    }

    public Map<String, String> getPersisObjectTypes() {
        return persisObjectTypes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    } 
    
}
