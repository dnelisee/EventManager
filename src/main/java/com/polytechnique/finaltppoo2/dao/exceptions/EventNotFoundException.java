package com.polytechnique.finaltppoo2.dao.exceptions;

public class EventNotFoundException extends RuntimeException{ 

    public EventNotFoundException(String id) {
        super(String.format("Event of id %s do not exists", id)); 
    }
    
}
