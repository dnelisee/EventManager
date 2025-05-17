package com.polytechnique.finaltppoo2.dao.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String entityName) {
        super(String.format("%s not found in the database", entityName));
    }
}
