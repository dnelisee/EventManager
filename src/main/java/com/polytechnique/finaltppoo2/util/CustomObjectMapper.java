package com.polytechnique.finaltppoo2.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
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

        /* to deserialize null list as empty list */
        mapper.configOverride(List.class)
                .setSetterInfo(JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY));

        return mapper;
    }

}
