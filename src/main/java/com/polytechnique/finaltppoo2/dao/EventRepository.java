package com.polytechnique.finaltppoo2.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.finaltppoo2.dao.exceptions.EventNotFoundException;
import com.polytechnique.finaltppoo2.dao.exceptions.EventYetExistsException;
import com.polytechnique.finaltppoo2.dao.exceptions.EventLoadingException;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

/*
 * Implements methods to persist event datas into Json files located 
 * into ressources directory
*/
public class EventRepository<T extends Event> {
    private static final String FILE_EXTENSION = ".json";

    private final Class<T> eventClass;

    private final Path baseDir;
    private final Path indexFile;
    private ObjectMapper mapper;

    public EventRepository(Class<T> eventClass) throws URISyntaxException {
        this.eventClass = eventClass;
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

    public void createEvent(T event) throws IOException {
        EventIndex index = loadIndex();
        if (eventYetExists(event)) {
            throw new EventYetExistsException(eventClass.getSimpleName(), event.getId());
        }

        Path eventFile = null;

        eventFile = baseDir.resolve(eventClass.getSimpleName().toLowerCase() + "s/" + event.getId() + FILE_EXTENSION);
        index.getEventTypes().put(event.getId(), "conference");

        new EventSerializer().serializeToFile(event, eventFile);
        saveIndex(index);
    }

    public boolean eventYetExists(T event) {
        EventIndex index;
        try {
            index = loadIndex();
            for (Entry<String, String> entry : index.getEventTypes().entrySet()) {
                if (entry.getKey() == event.getId()) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new EventLoadingException(eventClass.getSimpleName());
        }
    }

    public T readEvent(String id) throws IOException {
        Path path = createPathToEvent(id);
        if (path != null) {
            return new EventSerializer().deserializeFromFile(path, eventClass);
        } else {
            throw new EventNotFoundException(id);
        }

    }

    public List<T> getEvents() {
        List<T> result = new ArrayList<>();

        EventIndex index;
        try {
            index = loadIndex();

            for (Entry<String, String> entry : index.getEventTypes().entrySet()) {
                if (entry.getValue() == eventClass.getSimpleName().toLowerCase()) {
                    result.add(readEvent(entry.getKey()));
                }
            }
            return result;
        } catch (IOException e) {
            throw new EventLoadingException(eventClass.getSimpleName());
        }

    }

    public void deleteEvent(T event) {
        try {
            EventIndex index = loadIndex();
            for (Entry<String, String> entry : index.getEventTypes().entrySet()) {
                if (entry.getKey() == event.getId()) {
                    index.getEventTypes().remove(entry.getKey());
                    return;
                }
            }
        } catch (IOException e) {
            throw new EventLoadingException(eventClass.getSimpleName());
        }

    }

    public Path createPathToEvent(String id) {
        return baseDir.resolve(eventClass.getSimpleName().toLowerCase() + "s/" + id + FILE_EXTENSION);
    }

    public Path getBaseDir() {
        return baseDir;
    }

    public Path getIndexFile() {
        return indexFile;
    }

}
