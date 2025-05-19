package com.polytechnique.finaltppoo2.dao;

import java.io.IOException;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.dao.exceptions.SerializeException;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

public class EventSerializer {

    public void serializeToFile(Event event, Path file) throws IOException {
        ObjectMapper mapper = CustomObjectMapper.get();

        try {
            mapper.writeValue(file.toFile(), event);
        } catch (JsonProcessingException e) {
            throw new SerializeException("serialize", e.getMessage());
        }
    }

    public <T extends Event> T deserializeFromFile(Path file, Class<T> eventClass) throws IOException {
        ObjectMapper mapper = CustomObjectMapper.get();
        try {
            return (mapper.readValue(file.toFile(), eventClass));
        } catch (JsonProcessingException e) {
            throw new SerializeException("deserialize", e.getMessage());
        }
    }
}
