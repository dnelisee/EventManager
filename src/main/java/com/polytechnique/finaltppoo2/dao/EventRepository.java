package com.polytechnique.finaltppoo2.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.finaltppoo2.dao.exceptions.EventNotFoundException;
import com.polytechnique.finaltppoo2.model.Concert;
import com.polytechnique.finaltppoo2.model.Conference;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

/*
 * Implements methods to persist event datas into Json files located 
 * into ressources directory
*/
public class EventRepository {
    private static final String FILE_EXTENSION = ".json";

    private final Path baseDir;
    private final Path indexFile;
    private ObjectMapper mapper;

    public EventRepository() throws URISyntaxException {
        baseDir = Paths.get("src/main/resources/com/polytechnique/finaltppoo2/persistence/events");
        indexFile = baseDir.resolve("_index" + FILE_EXTENSION);
        mapper = CustomObjectMapper.get();
    }

    public void saveIndex(EventIndex index) throws IOException {
        index.setLastUpdated(LocalDateTime.now());
        mapper.writeValue(indexFile.toFile(), index);

    }

    public EventIndex loadIndex() throws IOException {
        return mapper.readValue(indexFile.toFile(), EventIndex.class);
    }

    public void createEvent(Event event) throws IOException {
        EventIndex index = loadIndex();
        Path eventFile = null;

        if (event instanceof Conference) {
            eventFile = baseDir.resolve("conferences/" + event.getId() + FILE_EXTENSION);
            index.getEventTypes().put(event.getId(), "conference");
        } else if (event instanceof Concert) {
            eventFile = baseDir.resolve("concerts/" + event.getId() + FILE_EXTENSION);
            index.getEventTypes().put(event.getId(), "concert");
        }
        new EventSerializer().serializeToFile(event, eventFile);
        saveIndex(index);
    }

    public <T extends Event> T readEvent(String id, Class<T> eventClass) throws IOException {
        Path path = eventExists(id);
        if (path != null) {
            return new EventSerializer().deserializeFromFile(path, eventClass);
        } else {
            throw new EventNotFoundException(id);
        }

    }

    public Path eventExists(String id) throws IOException {
        EventIndex index = loadIndex();
        return createPathToEvent(id, index.getEventTypes().get(id));
    }

    public Path createPathToEvent(String id, String type) {
        return baseDir.resolve(type + "s/" + id + FILE_EXTENSION);
    }

    public Path getBaseDir() {
        return baseDir;
    }

    public Path getIndexFile() {
        return indexFile;
    }

}
