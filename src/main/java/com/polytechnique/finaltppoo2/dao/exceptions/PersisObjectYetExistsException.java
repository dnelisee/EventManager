package com.polytechnique.finaltppoo2.dao.exceptions;

public class PersisObjectYetExistsException extends RuntimeException{
    public PersisObjectYetExistsException(String persisObjectClassName, String id) {
        super(String.format("the %s with id \"%s\" yet exists", persisObjectClassName, id));
    }
}
