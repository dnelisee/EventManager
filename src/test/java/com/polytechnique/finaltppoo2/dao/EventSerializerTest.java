package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Conference;
import com.polytechnique.finaltppoo2.model.Event;

class EventSerializerTest {
    
    @Test
    void testGetJsonResult() {
        Conference conf1 = new Conference("1", "c1", LocalDateTime.now(), "loc1", 100, "theme1");
        
        Map<String, Event> events = new HashMap<>();
        events.put(conf1.getId(), conf1); 

        String format = "{\"%s\":\"" + "%s:".repeat(7) + "\"}";

        String expectedResult = String.format(format, conf1.getId(), conf1.getId(), conf1.getName(), conf1.getDate(), conf1.getLocation(), conf1.getMaxCapacity(), conf1.getState(), conf1.getTheme());
    
        EventSerializer eventSerializer = new EventSerializer(events); 

        assertEquals(expectedResult, eventSerializer.getJsonResult());
    }
}
