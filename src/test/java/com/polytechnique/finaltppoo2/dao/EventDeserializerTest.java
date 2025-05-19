package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Event;

class EventDeserializerTest {

    @Test
    void deserialize() {
        String json = """
            {
                "type" : "conference",
                "id" : "1",
                "name" : "c1",
                "date" : "2025-05-19T13:25:30.8805844",
                "location" : "loc1",
                "maxCapacity" : 100,
                "state" : "PROGRAMMED",
                "theme" : "theme1"
            }
                """;

        Event event = new EventDeserializer().deserialize(json);

        System.out.println(event.getDate());

        assertEquals("1", event.getId());
        assertEquals("c1", event.getName());
        assertEquals("loc1", event.getLocation());
    }
}
