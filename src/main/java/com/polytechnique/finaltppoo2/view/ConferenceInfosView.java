package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.Conference;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConferenceInfosView extends EventInfosView {

    private TextField themeField; 

    public ConferenceInfosView(Conference conference) {
        super(conference);
    }

    @Override
    protected int addOtherFields() {
        startRow = super.addOtherFields();

        startRow = addThemeField();
        
        return startRow;
    }

    private int addThemeField() {
        Label themeLabel = new Label("Theme");
        this.add(themeLabel, 0, startRow);

        themeField = new TextField(((Conference)obj).getTheme());
        themeField.setEditable(false);
        themeField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(themeField, 1, startRow);

        return startRow + 1;
    }

    public TextField getThemeField() {
        return themeField;
    }
    
    
}
