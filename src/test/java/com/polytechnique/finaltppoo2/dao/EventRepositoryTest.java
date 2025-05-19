package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Conference;

class EventRepositoryTest {

    @Test 
    void testCreateEventRepository() {
        try {
            EventRepository repo = new EventRepository();

            System.out.println(repo.getBaseDir().toString());
            System.out.println(repo.getIndexFile().toString());

            assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events", repo.getBaseDir().toString());
            assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\_index.json", repo.getIndexFile().toString());

        } catch (URISyntaxException _) {
            System.out.println("Error URI");
        } 
    }


    @Test
    void testCreatePathToEvent() {
        EventRepository repo;
        try {
            repo = new EventRepository();

            Path res = repo.createPathToEvent("100", "conference");

            assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\conferences\\100.json",
                    res.toString());
        } catch (URISyntaxException _) {
            System.err.println("Error");
        }

    }

    @Test 
    void testLoadIndex() {
        try {
            EventIndex expected = new EventIndex(); 
            expected.getEventTypes().put("1", "conference"); 

            EventIndex res = new EventRepository().loadIndex();

            expected.displayEvents();
            res.displayEvents();

            assertTrue(expected.getEventTypes().equals(res.getEventTypes()));
            

        } catch(URISyntaxException _) {
            System.err.println("error URI");
        } catch(IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test 
    void testEventExists() {
        try {
            EventRepository repo = new EventRepository();

            Path res = repo.eventExists("1"); 

            System.out.println(res.toString());

            assertEquals("src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\events\\conferences\\1.json", res.toString());

        } catch (URISyntaxException _ ) {
            System.err.println("error URI ");
        } catch (IOException _) {
            System.err.println("error IO");
        }

    }

    @Test 
    void testCreateAndReadEvent() {
        Conference conf1 = new Conference("2", "c2", LocalDateTime.now(), "loc2", 100, "theme2");

        try {
            EventRepository repo = new EventRepository();
            repo.createEvent(conf1);

            Conference conf2 = repo.readEvent("2", Conference.class);

            assertEquals(conf1.getId(), conf2.getId());
            assertEquals(conf1.getName(), conf2.getName());
            assertEquals(conf1.getDate(), conf2.getDate());
            assertEquals(conf1.getLocation(), conf2.getLocation());
            assertEquals(conf1.getMaxCapacity(), conf2.getMaxCapacity());
            assertEquals(conf1.getTheme(), conf2.getTheme());
            assertEquals(conf1.getState(), conf2.getState());

        } catch (URISyntaxException e) {
            System.err.println("error URI : " + e.getMessage());
        } catch(IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test 
    void testSaveAndLoadIndex() {
        try {
            EventRepository repo = new EventRepository(); 
            EventIndex index = repo.loadIndex();

            assertTrue(index.getEventTypes().size() == 2);
            assertEquals("2025-05-19T17:48:16.048810", index.getLastUpdated().toString());

        } catch(URISyntaxException e) {
            System.out.println("error URI : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }

    }

    
}
