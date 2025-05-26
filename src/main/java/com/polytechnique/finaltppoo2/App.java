package com.polytechnique.finaltppoo2;

import java.io.IOException;
import java.net.URISyntaxException;

import com.polytechnique.finaltppoo2.controller.EventsViewController;
import com.polytechnique.finaltppoo2.controller.OrganizersViewController;
import com.polytechnique.finaltppoo2.controller.ParticipantsViewController;
import com.polytechnique.finaltppoo2.view.EventsView;
import com.polytechnique.finaltppoo2.view.OrganizersView;
import com.polytechnique.finaltppoo2.view.ParticipantsView;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;
    private Scene scene;

    /* views */
    EventsView eventsView;
    OrganizersView organizersView;
    ParticipantsView participantsView; 

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        /* creation of views and their controllers */
        eventsView = new EventsView(this);
        organizersView = new OrganizersView(this);
        participantsView = new ParticipantsView(this); 

        try {
            new EventsViewController(eventsView);
            new OrganizersViewController(organizersView);
            new ParticipantsViewController(participantsView);
        } catch (URISyntaxException | IOException _) {
            throw new RuntimeException("Error when creating an EventsViewController");
        }

        scene = new Scene(eventsView, 800, 600);
        stage.setScene(scene);
        setRoot(eventsView, "coreViewStyle.css");

        stage.show();
    }

    public void setRoot(Parent root) {
        scene.setRoot(root);
    }

    public void setRoot(Parent root, String styleFileName) {
        scene.setRoot(root);
        scene.getStylesheets().clear();
        scene.getStylesheets()
                .add(getClass().getResource("/com/polytechnique/finaltppoo2/styles/" + styleFileName).toExternalForm());
    }

    public void gotoEventsView() {
        setRoot(eventsView);
    }

    public void gotoOrganizersView() {
        setRoot(organizersView); 
    }

    public void gotoParticipantsView() {
        setRoot(participantsView); 
    }
    

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

}