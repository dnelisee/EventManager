package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Conference;
import com.polytechnique.finaltppoo2.model.Event;

class EventSerializerTest {
    
    @Test
    void testSerialize() {
        Event conf1 = new Conference("1", "c1", LocalDateTime.now(), "loc1", 100, "theme1");
         
        String json = new EventSerializer().serialize(conf1); 
        System.out.println(json);

        assertTrue(json.contains("\"id\" : \"1\""));
        assertTrue(json.contains("\"name\" : \"c1\""));
        assertTrue(json.contains("\"location\" : \"loc1\""));
        assertTrue(json.contains("\"maxCapacity\" : 100"));
    }

}
