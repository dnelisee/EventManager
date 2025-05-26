package com.polytechnique.finaltppoo2.view;

import com.polytechnique.finaltppoo2.model.Person;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public abstract class PersonInfosView extends PersisObjInfosView{

    protected TextField emailField;


    protected PersonInfosView(Person obj) {
        super(obj);
    }

    @Override
    protected int addOtherFields() {
        startRow = addEmailField(); 
        
        return startRow; 
    } 

    private int addEmailField() {
        Label emailLabel = new Label("Email");
        this.add(emailLabel, 0, startRow);

        emailField = new TextField(((Person) obj).getEmail());
        emailField.setEditable(false);
        emailField.setPrefWidth(TEXT_FIELD_HEIGHT);
        this.add(emailField, 1, startRow);

        return startRow + 1;
    }


    public TextField getEmailField() {
        return emailField; 
    }
}
