package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.dao.exceptions.PersisObjectYetExistsException;
import com.polytechnique.finaltppoo2.model.Concert;
import com.polytechnique.finaltppoo2.model.Event;

class EventRepositoryTest {

    Repository<Event, Concert> repo;

    @BeforeEach
    void setUp() {
        try {
            repo = new Repository<>(Event.class, Concert.class);
        } catch (URISyntaxException | IOException e) {
            System.err.println("Error setUp : " + e.getMessage());
            throw new RuntimeException();
        } 
    }

    @Test
    void testCreateEventRepository() {

        System.out.println(repo.getBaseDir().toString());
        System.out.println(repo.getIndexFile().toString());

        assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events",
                repo.getBaseDir().toString());
        assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\_index.json",
                repo.getIndexFile().toString());
    }

    @Test
    void testCreatePathToEvent() {
        Path res = repo.createPathToPersisObject("100");

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\concerts\\100.json",
                res.toString());

    }

    @Test
    void testLoadIndex() {
        try {
            Index expected = new Index();
            expected.getPersisObjectTypes().put("4", "concert");

            Index res = repo.loadIndex();

            res.display();

            assertTrue(res.getPersisObjectTypes().entrySet().containsAll(expected.getPersisObjectTypes().entrySet()));

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test
    void testEventExists() {

        Path res = repo.createPathToPersisObject("4");

        System.out.println(res.toString());

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\concerts\\4.json",
                res.toString());
    }

    @Test
    void testCreateAndReadEvent() {
        Concert conf1 = new Concert("6", "c6", LocalDateTime.now(), "loc6", 50, "malock", "bole");
        try {
            repo.createPersisObject(conf1);

            assertTrue(true);
            Concert conf2 = repo.readPersisObject("6");

            assertEquals(conf1.getId(), conf2.getId());
            assertEquals(conf1.getName(), conf2.getName());
            assertEquals(conf1.getDate(), conf2.getDate());
            assertEquals(conf1.getLocation(), conf2.getLocation());
            assertEquals(conf1.getMaxCapacity(), conf2.getMaxCapacity());
            assertEquals(conf1.getArtist(), conf2.getArtist());
            assertEquals(conf1.getMusicalGenre(), conf2.getMusicalGenre());
            assertEquals(conf1.getState(), conf2.getState());
        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        } catch (PersisObjectYetExistsException e) {
            System.err.println("error PersisObjectYetExistsException : " + e.getMessage());
        }
    }

    @Test
    void testSaveAndLoadIndex() {
        try {
            Index index = repo.loadIndex();

            assertTrue(index.getPersisObjectTypes().size() == 5);

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }

    }

}
