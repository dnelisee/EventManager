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
import com.polytechnique.finaltppoo2.dao.exceptions.PersisObjectLoadingException;
import com.polytechnique.finaltppoo2.dao.exceptions.PersisObjectNotFoundException;
import com.polytechnique.finaltppoo2.dao.exceptions.PersisObjectYetExistsException;
import com.polytechnique.finaltppoo2.model.PersisObject;
import com.polytechnique.finaltppoo2.util.CustomObjectMapper;

/*
 * V is an abstract class and T a concrete class and implements V. 
 * For example : V = Event and T = Conference 
 * or V = Person and T = Participant
 */
public class Repository<V extends PersisObject, T extends V> {
    protected static final String FILE_EXTENSION = ".json";

    protected Class<T> persisObjectClass;

    protected Path baseDir;
    protected Path indexFile;
    protected ObjectMapper mapper; 

    public Repository(Class<V> abstractPersisObject, Class<T> persisObjectClass) throws URISyntaxException, IOException {
        this.persisObjectClass = persisObjectClass;
        baseDir = Paths.get(String.format("src/main/resources/com/polytechnique/finaltppoo2/persistence/%ss", abstractPersisObject.getSimpleName().toLowerCase()));
        indexFile = baseDir.resolve("_index" + FILE_EXTENSION);
        mapper = CustomObjectMapper.get();

        // test if the index file is empty, if it is, then add a new empty index
        if(indexFile.toFile().length() == 0) {
            saveIndex(new Index());
        }
        
    } 

    public void saveIndex(Index index) throws IOException {
        index.setLastUpdated(LocalDateTime.now());
        mapper.writeValue(indexFile.toFile(), index);
    } 

    public Index loadIndex() throws IOException {
        return mapper.readValue(indexFile.toFile(), Index.class);
    }

    public void createPersisObject(T persisObject) throws IOException {
        Index index = loadIndex();
        if (persisObjectYetExists(persisObject)) {
            throw new PersisObjectYetExistsException(persisObjectClass.getSimpleName(), persisObject.getId());
        }

        Path persisObjectFile = baseDir.resolve(persisObjectClass.getSimpleName().toLowerCase() + "s/" + persisObject.getId() + FILE_EXTENSION);
        index.getPersisObjectTypes().put(persisObject.getId(), persisObjectClass.getSimpleName().toLowerCase());

        new Serializer<T>().serializeToFile(persisObject, persisObjectFile);
        saveIndex(index);
    }

    public boolean persisObjectYetExists(T persisObject) {
        Index index;
        try {
            index = loadIndex();
            for (Entry<String, String> entry : index.getPersisObjectTypes().entrySet()) {
                if (entry.getKey().equals(persisObject.getId())) {
                    return true;
                }
            }
            return false;
        } catch (IOException _) {
            throw new PersisObjectLoadingException(persisObjectClass.getSimpleName());
        }
    }

    public T readPersisObject(String id) throws IOException {
        Path path = createPathToPersisObject(id);
        if (path != null) {
            return new Serializer<T>().deserializeFromFile(path, persisObjectClass);
        } else {
            throw new PersisObjectNotFoundException(persisObjectClass.getSimpleName(), id);
        }

    }

    public List<T> getPersisObjects() {
        List<T> result = new ArrayList<>();

        Index index;
        try {
            index = loadIndex();

            for (Entry<String, String> entry : index.getPersisObjectTypes().entrySet()) {
                if (entry.getValue().equals(persisObjectClass.getSimpleName().toLowerCase())) {
                    result.add(readPersisObject(entry.getKey()));
                }
            }
            return result;
        } catch (IOException _) {
            throw new PersisObjectLoadingException(persisObjectClass.getSimpleName());
        }

    }

    public void deletePersisObject(T persisObject) {
        try {
            Index index = loadIndex();
            for (Entry<String, String> entry : index.getPersisObjectTypes().entrySet()) {
                if (entry.getKey().equals(persisObject.getId())) {
                    index.getPersisObjectTypes().remove(entry.getKey());
                    return;
                }
            }
        } catch (IOException _) {
            throw new PersisObjectLoadingException(persisObjectClass.getSimpleName());
        }

    }

    public Path createPathToPersisObject(String id) {
        return baseDir.resolve(persisObjectClass.getSimpleName().toLowerCase() + "s/" + id + FILE_EXTENSION);
    }

    public Path getBaseDir() {
        return baseDir;
    }

    public Path getIndexFile() {
        return indexFile;
    }
    
}
