package com.polytechnique.finaltppoo2.dao;

import java.io.IOException;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.finaltppoo2.dao.exceptions.SerializeException;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

public class Serializer<T> {

    private ObjectMapper mapper = CustomObjectMapper.get();

    public void serializeToFile(T object, Path file) throws IOException {
        try {
            mapper.writeValue(file.toFile(), object);
        } catch (JsonProcessingException e) {
            throw new SerializeException("serialize", e.getMessage());
        }
    }

    public T deserializeFromFile(Path file, Class<T> persisObjectClass) throws IOException {
        try {
            return (mapper.readValue(file.toFile(), persisObjectClass));
        } catch (JsonProcessingException e) {
            throw new SerializeException("deserialize", e.getMessage());
        }
    }
}
