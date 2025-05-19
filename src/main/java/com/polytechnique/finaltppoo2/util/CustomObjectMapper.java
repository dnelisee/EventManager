package com.polytechnique.finaltppoo2.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CustomObjectMapper {

    private CustomObjectMapper() {
        throw new IllegalStateException("utility class");
    }

    public static ObjectMapper get() {
        ObjectMapper mapper = new ObjectMapper(); 
        mapper.registerModule(new JavaTimeModule()); // for LocalDateTime 
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); 
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        return mapper;
    }
    
}
