package com.polytechnique.finaltppoo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.polytechnique.finaltppoo2.model.Participant;
import com.polytechnique.finaltppoo2.model.Person;

class PersonRepositoryTest {
    
    Repository<Person, Participant> repo; 

    @BeforeEach
    void setUp() {
        try {
            repo = new Repository<>(Person.class, Participant.class);
        } catch (URISyntaxException | IOException e) {
            System.err.println("Error setUp : " + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Test 
    void testCreatePathToPerson() {
        Path res = repo.createPathToPersisObject("100");

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\persons\\participants\\100.json",
                res.toString()); 
    }

    @Test 
    void testCreateAndReadPerson() {
        Participant part1 = new Participant("1", "part1", "email1");

        try {
            repo.createPersisObject(part1);
            assertTrue(true);
        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test
    void testLoadIndex() {
        try {
            Index expected = new Index();
            expected.getPersisObjectTypes().put("1", "participant");

            Index res = repo.loadIndex();

            res.display();

            assertTrue(res.getPersisObjectTypes().entrySet().containsAll(expected.getPersisObjectTypes().entrySet()));

        } catch (IOException e) {
            System.err.println("error IO : " + e.getMessage());
        }
    }

    @Test 
    void testPersonExists() {
         Path res = repo.createPathToPersisObject("1");

        System.out.println(res.toString());

        assertEquals(
                "src\\main\\resources\\com\\polytechnique\\finaltppoo2\\persistence\\persons\\participants\\1.json",
                res.toString());
    }
}
