package com.polytechnique.finaltppoo2.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.polytechnique.finaltppoo2.model.Event;
import com.polytechnique.finaltppoo2.util.ManageLocalDateTime;

public abstract class EventInfosView extends PersisObjInfosView implements ManageLocalDateTime {

    protected TextField dateField;
    protected TextField locationField;
    protected TextField maxCapacityField;

    protected EventInfosView(Event event) {
        super(event);
    }

    @Override
    protected int addOtherFields() {
        startRow = addDateField();
        startRow = addLocationField();
        startRow = addMaxCapacityField();

        return startRow;

    }

    private int addDateField() {
        Label dateLabel = new Label("Date");
        this.add(dateLabel, 0, startRow);

        dateField = new TextField(lDtToString(((Event) obj).getDate()));
        dateField.setEditable(false);
        dateField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(dateField, 1, startRow);

        return startRow + 1;
    }

    private int addLocationField() {
        Label locationLabel = new Label("Location");
        this.add(locationLabel, 0, startRow);

        locationField = new TextField(((Event) obj).getLocation());
        locationField.setEditable(false);
        locationField.setPrefHeight(TEXT_FIELD_HEIGHT);
        this.add(locationField, 1, startRow);

        return startRow + 1;
    }

    private int addMaxCapacityField() {
        Label maxCapacityLabel = new Label("Max capacity");
        this.add(maxCapacityLabel, 0, startRow);

        maxCapacityField = new TextField(String.valueOf(((Event) obj).getMaxCapacity()));
        maxCapacityField.setEditable(false);
        maxCapacityField.setPrefHeight(TEXT_FIELD_HEIGHT);
        this.add(maxCapacityField, 1, startRow);

        return startRow + 1;
    }

}
