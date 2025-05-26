package com.polytechnique.finaltppoo2.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import com.polytechnique.finaltppoo2.dao.Repository;
import com.polytechnique.finaltppoo2.model.Organizer;
import com.polytechnique.finaltppoo2.model.Person;
import com.polytechnique.finaltppoo2.service.PersisObjectService;
import com.polytechnique.finaltppoo2.view.GraphicPersisObject;
import com.polytechnique.finaltppoo2.view.OrganizerInfosView;
import com.polytechnique.finaltppoo2.view.OrganizersView;

import javafx.scene.image.ImageView;

public class OrganizersViewController extends CoreViewController{

    private PersisObjectService<Person, Organizer> organizerService; 

    public OrganizersViewController(OrganizersView view, PersisObjectService<Person, Organizer> organizerService) {
        super(view); 

        this.view = view; 
        this.organizerService = organizerService;

        loadElementsList();
    }

    public OrganizersViewController(OrganizersView view) throws URISyntaxException, IOException {
        this(view, new PersisObjectService<>(new Repository<>(Person.class, Organizer.class)));
    }


    @Override
    protected void loadElementsList() {
       for(Organizer org : organizerService.getList()) {
        view.getElementsListView().getItems().add(new GraphicPersisObject(org, org.getName(), org.getEmail()));
       }
    }

    @Override
    protected void handleListView() {
        view.getElementsListView().setOnMouseClicked(_->{
            GraphicPersisObject graphicObj = view.getElementsListView().getSelectionModel().getSelectedItem();
            
            if(graphicObj == null) return;

            ImageView organizerImage = view.loadIcon("user.png");

            organizerImage.setFitHeight(HEADER_IMG_SIZE);
            organizerImage.setFitWidth(HEADER_IMG_SIZE);

            view.getRightSide().getChildren().clear();

            view.getRightSide().getChildren().add(organizerImage);

            view.getRightSide().getChildren().add(new OrganizerInfosView((Organizer)graphicObj.getPersisObj()));
        });
    }
    
}
