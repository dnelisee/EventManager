package com.polytechnique.finaltppoo2.service;

import java.io.IOException;

import com.polytechnique.finaltppoo2.dao.EventRepository;
import com.polytechnique.finaltppoo2.model.Event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * This class implements the business logic related to Conference 
*/
public class EventService<T extends Event> {

    private EventRepository<T> repo;
    private ObservableList<T> confObsrvList = FXCollections.observableArrayList();

    public EventService(EventRepository<T> repo) {
        this.repo = repo;
        confObsrvList.addAll(repo.getEvents());
    }

    public ObservableList<T> getConfObsrvList() {
        return confObsrvList;
    }

    public void addEvent(T event) throws IOException {
        repo.createEvent(event);
        confObsrvList.add(event);
    }

    public void removeEvent(T event) {
        repo.deleteEvent(event);
        confObsrvList.remove(event);
    }

}
