package com.polytechnique.finaltppoo2.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.util.ManageLocalDateTime;

public abstract class EventInfosView extends GridPane implements ManageLocalDateTime{
    protected static final int PADDING = 40;
    protected static final int HGAP = 7;
    protected static final int VGAP = 15;
    protected static final int COL_1_WIDTH = 75;
    protected static final int COL_2_WIDTH = 250;
    protected static final int TEXT_FIELD_HEIGHT = 40;

    protected TextField nameField;
    protected TextField dateField;
    protected TextField locationField;
    protected TextField maxCapacityField;

    protected Button modifyBtn; 
    protected Button saveBtn;
    
    protected EventInfosView(Event event) {

        // position of the grid pane 
        this.setAlignment(Pos.CENTER);

        // padding
        this.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

        // horizontal and vertical gap
        this.setHgap(HGAP);
        this.setVgap(VGAP);

        // column 1 constraints
        ColumnConstraints col1Constraints = new ColumnConstraints(COL_1_WIDTH, COL_1_WIDTH, Double.MAX_VALUE);
        col1Constraints.setHgrow(Priority.ALWAYS);

        // column 2 constraints
        ColumnConstraints col2Constraints = new ColumnConstraints(COL_2_WIDTH, COL_2_WIDTH, Double.MAX_VALUE);
        col2Constraints.setHgrow(Priority.ALWAYS);

        this.getColumnConstraints().addAll(col1Constraints, col2Constraints);

        // header label
        Label headerLabel = new Label(event.getClass().getSimpleName());
        headerLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16));
        this.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(10, 0, 10, 0));

        // Name
        Label nameLabel = new Label("Name");
        this.add(nameLabel, 0, 1);

        nameField = new TextField(event.getName());
        nameField.setPrefWidth(TEXT_FIELD_HEIGHT);
        nameField.setEditable(false);
        this.add(nameField, 1, 1);

        // date
        Label dateLabel = new Label("Date");
        this.add(dateLabel, 0, 2);

        dateField = new TextField(lDtToString(event.getDate()));
        dateField.setEditable(false);
        dateField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(dateField, 1, 2);

        // location
        Label locationLabel = new Label("Location");
        this.add(locationLabel, 0, 3);

        locationField = new TextField(event.getLocation());
        locationField.setEditable(false);
        locationField.setPrefHeight(TEXT_FIELD_HEIGHT);
        this.add(locationField, 1, 3);

        // maxCapacity
        Label maxCapacityLabel = new Label("Max capacity");
        this.add(maxCapacityLabel, 0, 4);

        maxCapacityField = new TextField(String.valueOf(event.getMaxCapacity()));
        maxCapacityField.setEditable(false);
        maxCapacityField.setPrefHeight(TEXT_FIELD_HEIGHT);
        this.add(maxCapacityField, 1, 4);

        // others attributes
        int startRow = addOtherFields(event, 5);

        // buttons
        modifyBtn = new Button("Modify");
        this.add(modifyBtn, 0, startRow);

        saveBtn = new Button("Save");
        this.add(saveBtn, 1, startRow);
        GridPane.setHalignment(saveBtn, HPos.RIGHT);

    }

    protected abstract int addOtherFields(Event event, int startRow); 


    /* getters */
    public Button getModifyBtn() {
        return modifyBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

}
