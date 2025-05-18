package com.polytechnique.finaltppoo2.dao;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.polytechnique.finaltppoo2.model.Event;

/*
 * This class helps to tell jackson how to serialize Event
*/

public class EventSerializer extends JsonSerializer<Event>{
    /* mapper for serialization */
    private ObjectMapper mapper = new ObjectMapper();

    /* applying the EventSerializer to the map of events */
    @JsonSerialize(keyUsing = EventSerializer.class)
    private Map<String, Event> events;

    /* contructor */
    public EventSerializer(Map<String, Event> events) {
        this.events = events; 
    }

    @Override
    public void serialize(Event event, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        StringWriter writer = new StringWriter(); 

        mapper.writeValue(writer, event); 
        gen.writeFieldName(writer.toString());
    } 

    public String getJsonResult() {
        try {
            return(mapper.writeValueAsString(this.events)); 
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
