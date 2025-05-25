package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.PersisObject;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GraphicPersisObject extends VBox{  
    private static final int DEFAULT_SPACING = 5;

    private PersisObject persisObj; 

    public GraphicPersisObject(PersisObject persisObj, String name, String description) {
        super(DEFAULT_SPACING); 
        this.persisObj = persisObj;
        createLabel(name);
        createDescription(description);
    }

    private void createLabel(String name) {
        Label objLabel;
        objLabel = new Label(name); 
        objLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));

        Separator sep = new Separator(Orientation.HORIZONTAL);

        this.getChildren().addAll(objLabel, sep); 
    }

    private void createDescription(String description) {
        Label objDescription;
        objDescription = new Label(description); 
        objDescription.setFont(Font.font(Font.getDefault().getName(), FontWeight.EXTRA_LIGHT, 12));

        this.getChildren().add(objDescription);
    }

    public PersisObject getPersisObj() {
        return persisObj;
    }
}
