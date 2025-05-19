package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Conference;

class EventRepositoryTest {

    EventRepository<Conference> repo;

    @BeforeEach
    void setUp() {
        try {
            repo = new EventRepository<>(Conference.class);
        } catch (URISyntaxException e) {
            System.err.println("Error URI : " + e.getMessage());
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
        Path res = repo.createPathToEvent("100");

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\conferences\\100.json",
                res.toString());

    }

    @Test
    void testLoadIndex() {
        try {
            EventIndex expected = new EventIndex();
            expected.getEventTypes().put("1", "conference");

            EventIndex res = repo.loadIndex();

            expected.displayEvents();
            res.displayEvents();

            assertTrue(res.getEventTypes().entrySet().containsAll(expected.getEventTypes().entrySet()));

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test
    void testEventExists() {

        Path res = repo.createPathToEvent("1");

        System.out.println(res.toString());

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\conferences\\1.json",
                res.toString());
    }

    @Test
    void testCreateAndReadEvent() {
        Conference conf1 = new Conference("3", "c3", LocalDateTime.now(), "loc3", 100, "theme3");

        try {
            repo.createEvent(conf1);

            Conference conf2 = repo.readEvent("3");

            assertEquals(conf1.getId(), conf2.getId());
            assertEquals(conf1.getName(), conf2.getName());
            assertEquals(conf1.getDate(), conf2.getDate());
            assertEquals(conf1.getLocation(), conf2.getLocation());
            assertEquals(conf1.getMaxCapacity(), conf2.getMaxCapacity());
            assertEquals(conf1.getTheme(), conf2.getTheme());
            assertEquals(conf1.getState(), conf2.getState());

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test
    void testSaveAndLoadIndex() {
        try {
            EventIndex index = repo.loadIndex();

            assertTrue(index.getEventTypes().size() == 3);
            assertTrue(index.getLastUpdated().toString().contains("2025-05-19T19:32:58.894795300"));

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }

    }

}
