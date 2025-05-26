package com.polytechnique.finaltppoo2.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.Participant;
import com.polytechnique.finaltppoo2.model.Person;
import com.polytechnique.finaltppoo2.service.PersisObjectService;
import com.polytechnique.finaltppoo2.view.GraphicPersisObject;
import com.polytechnique.finaltppoo2.view.ParticipantInfosView;
import com.polytechnique.finaltppoo2.view.ParticipantsView;

import javafx.scene.image.ImageView;

public class ParticipantsViewController extends CoreViewController { 
    private PersisObjectService<Person, Participant> participantService;

    public ParticipantsViewController(ParticipantsView view, PersisObjectService<Person, Participant> participantService) {
        super(view); 

        this.view = view; 
        this.participantService = participantService;

        loadElementsList();
    }

    public ParticipantsViewController(ParticipantsView view) throws URISyntaxException, IOException {
        this(view, new PersisObjectService<>(new Repository<>(Person.class, Participant.class)));
    }



    @Override
    protected void loadElementsList() {
        for(Participant part : participantService.getList()) {
        view.getElementsListView().getItems().add(new GraphicPersisObject(part, part.getName(), part.getEmail()));
       }
    }

    @Override
    protected void handleListView() {
        view.getElementsListView().setOnMouseClicked(_->{
            GraphicPersisObject graphicObj = view.getElementsListView().getSelectionModel().getSelectedItem();
            
            if(graphicObj == null) return;

            ImageView participantImage = view.loadIcon("utilisateur.png");

            participantImage.setFitHeight(HEADER_IMG_SIZE);
            participantImage.setFitWidth(HEADER_IMG_SIZE);

            view.getRightSide().getChildren().clear();

            view.getRightSide().getChildren().add(participantImage);

            view.getRightSide().getChildren().add(new ParticipantInfosView((Participant)graphicObj.getPersisObj()));
        });
    } 
    
}
