package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.PersisObject;

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

public abstract class PersisObjInfosView extends GridPane {
    protected static final int PADDING = 40;
    protected static final int HGAP = 7;
    protected static final int VGAP = 15;
    protected static final int COL_1_WIDTH = 75;
    protected static final int COL_2_WIDTH = 250;
    protected static final int TEXT_FIELD_HEIGHT = 40;

    protected PersisObject obj;

    protected int startRow = 0;

    protected TextField nameField;
    protected Button modifyBtn;
    protected Button saveBtn;

    protected PersisObjInfosView(PersisObject obj) {

        this.obj = obj;

        setDefaultParameters();

        startRow = addHeaderLabel();

        startRow = addNameField();

        startRow = addOtherFields();

        startRow = addButtons();

    }

    private void setDefaultParameters() {
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
    }

    private int addHeaderLabel() {

        Label headerLabel = new Label(obj.getClass().getSimpleName());
        headerLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16));
        this.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(10, 0, 10, 0));

        return 1;
    }

    private int addNameField() {

        Label nameLabel = new Label("Name");
        this.add(nameLabel, 0, startRow);

        nameField = new TextField(obj.getName());
        nameField.setPrefWidth(TEXT_FIELD_HEIGHT);
        nameField.setEditable(false);
        this.add(nameField, 1, startRow);

        return startRow + 1;
    }

    protected abstract int addOtherFields();

    private int addButtons() {
        modifyBtn = new Button("Modify");
        this.add(modifyBtn, 0, startRow);

        saveBtn = new Button("Save");
        this.add(saveBtn, 1, startRow);
        GridPane.setHalignment(saveBtn, HPos.RIGHT);

        return startRow + 1;
    }

    /* getters */
    public Button getModifyBtn() {
        return modifyBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }
}
