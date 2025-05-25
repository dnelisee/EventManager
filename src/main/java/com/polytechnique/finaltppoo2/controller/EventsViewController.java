package com.polytechnique.finaltppoo2.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.Concert;
import com.polytechnique.finaltppoo2.model.Conference;
import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.service.PersisObjectService;
import com.polytechnique.finaltppoo2.view.ConcertInfosView;
import com.polytechnique.finaltppoo2.view.ConferenceInfosView;
import com.polytechnique.finaltppoo2.view.EventsView;
import com.polytechnique.finaltppoo2.view.GraphicPersisObject;

import javafx.scene.image.ImageView;


public class EventsViewController extends CoreViewController{

    private static final int HEADER_IMG_SIZE = 100;

    private PersisObjectService<Event, Conference> confService;
    private PersisObjectService<Event, Concert> concService;
    
    public EventsViewController(EventsView view, PersisObjectService<Event, Conference> confService, PersisObjectService<Event, Concert> concService) {
        super(view);

        this.confService = confService; 
        this.concService = concService;

        /* load all events */
        loadElementsList();

        /* set all handlers */
        handleEventsListView();

    }

    public EventsViewController(EventsView view) throws URISyntaxException, IOException{ 
        this(view, new PersisObjectService<>(new Repository<>(Event.class, Conference.class)), new PersisObjectService<>(new Repository<>(Event.class, Concert.class)));
    }

    @Override
    protected void loadElementsList() {
        for(Conference conf : confService.getList()) {
            view.getElementsListView().getItems().add(new GraphicPersisObject(conf, conf.getName(), conf.getDate().toString()));
        }
        for(Concert conc : concService.getList()) {
            view.getElementsListView().getItems().add(new GraphicPersisObject(conc, conc.getName(), conc.getDate().toString()));
        }
    }

    private void handleEventsListView() {

        view.getElementsListView().setOnMouseClicked(_ -> {
            /* get the graphic object which is selected */
            GraphicPersisObject graphicObj = view.getElementsListView().getSelectionModel().getSelectedItem();


            /* create the header of the right side view */
            String imageName = graphicObj.getPersisObj() instanceof Conference ? "conference.jpg" : "concert.jpg";
            ImageView eventImageView = view.loadImage(imageName);

            eventImageView.setFitWidth(HEADER_IMG_SIZE);
            eventImageView.setFitHeight(HEADER_IMG_SIZE);

            /* clear the right side and add new elements */
            view.getRightSide().getChildren().clear();

            view.getRightSide().getChildren().add(eventImageView);

            if(graphicObj.getPersisObj() instanceof Conference) 
                view.getRightSide().getChildren().add(new ConferenceInfosView((Conference)graphicObj.getPersisObj()));
            else if(graphicObj.getPersisObj() instanceof Concert) 
                view.getRightSide().getChildren().add(new ConcertInfosView((Concert)graphicObj.getPersisObj()));

        });
    }
}
