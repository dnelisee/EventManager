package com.polytechnique.finaltppoo2.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.finaltppoo2.dao.exceptions.SerializeException;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

public class EventDeserializer {
    
    public Event deserialize(String json) {
        ObjectMapper mapper = CustomObjectMapper.get();
        try {
            return(mapper.readValue(json, Event.class));
        } catch (JsonProcessingException e) {
            throw new SerializeException("deserialize", e.getMessage());
        } 
    }
    
}
