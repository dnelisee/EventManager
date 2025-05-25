package com.polytechnique.finaltppoo2.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.Concert;
import com.polytechnique.finaltppoo2.model.Conference;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.service.PersisObjectService;
import com.polytechnique.finaltppoo2.util.InfoForView;
import com.polytechnique.finaltppoo2.view.EventInfosView;
import com.polytechnique.finaltppoo2.view.EventsView;
import com.polytechnique.finaltppoo2.view.GraphicPersisObject;

import javafx.scene.image.ImageView;


public class EventsViewController {

    private static final int HEADER_IMG_SIZE = 100;

    private EventsView eventsView; 
    private PersisObjectService<Event, Conference> confService;
    private PersisObjectService<Event, Concert> concService;
    
    public EventsViewController(EventsView eventsView, PersisObjectService<Event, Conference> confService, PersisObjectService<Event, Concert> concService) {
        this.eventsView = eventsView;
        this.confService = confService; 
        this.concService = concService;

        /* load all events */
        loadElementsList();

        /* set all handlers */
        handleEventsListView();

    }

    public EventsViewController(EventsView eventsView) throws URISyntaxException, IOException{ 
        this(eventsView, new PersisObjectService<>(new Repository<>(Event.class, Conference.class)), new PersisObjectService<>(new Repository<>(Event.class, Concert.class)));
    }

    private void loadElementsList() {
        for(Conference conf : confService.getList()) {
            eventsView.getElementsListView().getItems().add(new GraphicPersisObject(conf, conf.getName(), conf.getDate().toString()));
        }
        for(Concert conc : concService.getList()) {
            eventsView.getElementsListView().getItems().add(new GraphicPersisObject(conc, conc.getName(), conc.getDate().toString()));
        }
    }

    private void handleEventsListView() {

        eventsView.getElementsListView().setOnMouseClicked(_ -> {
            /* get the graphic object which is selected */
            GraphicPersisObject graphicObj = eventsView.getElementsListView().getSelectionModel().getSelectedItem();

            /* create the array of attributes of the corresponding persisObject */
            List<InfoForView> infos = new ArrayList<>();
            for(Entry<String, String> entry : graphicObj.getPersisObj().getAllAttributes().entrySet()) {
                infos.add(new InfoForView(entry.getKey(), entry.getValue()));
            }

            /* create the header of the right side view */
            String imageName = graphicObj.getPersisObj() instanceof Conference ? "conference.jpg" : "concert.jpg";
            ImageView eventImageView = eventsView.loadImage(imageName);

            eventImageView.setFitWidth(HEADER_IMG_SIZE);
            eventImageView.setFitHeight(HEADER_IMG_SIZE);

            /* clear the right side and add new elements */
            eventsView.getRightSide().getChildren().clear();
            eventsView.getRightSide().getChildren().addAll(eventImageView, new EventInfosView(infos));
        });
    }
}
