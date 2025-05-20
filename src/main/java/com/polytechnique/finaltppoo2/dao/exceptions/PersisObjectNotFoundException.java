package com.polytechnique.finaltppoo2.dao.exceptions;

public class PersisObjectNotFoundException extends RuntimeException{ 

    public PersisObjectNotFoundException(String eventClassName, String id) {
        super(String.format("%s of id %s do not exists", eventClassName, id)); 
    }
    
}
