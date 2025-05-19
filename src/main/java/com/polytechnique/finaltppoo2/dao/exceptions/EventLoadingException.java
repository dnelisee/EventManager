package com.polytechnique.finaltppoo2.dao.exceptions;


public class EventLoadingException extends RuntimeException{
    public EventLoadingException(String eventClassName) {
        super(String.format("Cannot load event(s) of type %s", eventClassName));
    }
}
