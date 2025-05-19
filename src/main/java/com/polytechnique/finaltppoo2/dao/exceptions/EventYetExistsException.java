package com.polytechnique.finaltppoo2.dao.exceptions;

public class EventYetExistsException extends RuntimeException{
    public EventYetExistsException(String eventClassName, String id) {
        super(String.format("the event of type \"%s\" with id \"%s\" yet exists", eventClassName, id));
    }
}
