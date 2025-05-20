package com.polytechnique.finaltppoo2.dao.exceptions;


public class PersisObjectLoadingException extends RuntimeException{
    public PersisObjectLoadingException(String persisObjectClassName) {
        super(String.format("Cannot load persisObject(s) of type %s", persisObjectClassName));
    }
}
