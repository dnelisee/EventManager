package com.polytechnique.finaltppoo2.model;

import java.util.ArrayList;
import java.util.List;

import com.polytechnique.finaltppoo2.model.exceptions.LengthException;
import com.polytechnique.finaltppoo2.model.exceptions.ValidatableField;

public abstract class Person extends PersisObject{

    /* attributes given by System class diagram */
    
    protected String email;
    
    protected List<Event> events; 

    protected Person(String id, String name, String email) {
        if (!ValidatableField.NAME.validate(name)) {
            throw new LengthException(ValidatableField.NAME);
        } else if (!ValidatableField.EMAIL.validate(email)) {
            throw new LengthException(ValidatableField.EMAIL);
        } else {
            this.id = id; 
            this.name = name; 
            this.email = email;
            events = new ArrayList<>();
        }
    }
    
    public String getEmail() {
        return email;
    } 

}
