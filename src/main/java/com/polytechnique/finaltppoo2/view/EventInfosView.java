package com.polytechnique.finaltppoo2.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;
import com.polytechnique.finaltppoo2.util.InfoForView;

public class EventInfosView extends VBox { 
    private static final int DEFAULT_SPACING = 5;

    private Button modifyBtn; 
    private Button saveBtn;
    
    public EventInfosView(List<InfoForView> infos) {
        this(DEFAULT_SPACING, infos);
    }

    public EventInfosView(int sidesSpacing, List<InfoForView> infos) {
        super(sidesSpacing);

        /* create informations view */
        for(InfoForView info : infos) {
            this.getChildren().add(createAnInfoBox(info.getInfoName(), info.getInfoContent()));
        }
    
        /* create actions buttons */
        createActionsButtons();
    }

    private HBox createAnInfoBox(String infoName, String infoContent) {
        HBox infoBox = new HBox(); 

        Label name = new Label(infoName); 
        Text textContent = new Text(infoContent);

        infoBox.getChildren().addAll(name, textContent); 

        return infoBox;
    }

    private void createActionsButtons() {
        /* set the styles here ... */
        HBox line = new HBox();

        modifyBtn = new Button("modify ?");
        saveBtn = new Button("Save");

        line.getChildren().addAll(modifyBtn, saveBtn);

        this.getChildren().add(line);

    }

    /* getters */
    public Button getModifyBtn() {
        return modifyBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

}
