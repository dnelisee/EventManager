package com.polytechnique.finaltppoo2;

import java.io.IOException;
import java.net.URISyntaxException;

import com.polytechnique.finaltppoo2.controller.EventsViewController;
import com.polytechnique.finaltppoo2.view.EventsView;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage; 
    private Scene scene; 

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage; 
        
        EventsView eventsView = new EventsView();
        try {
            new EventsViewController(eventsView);
        } catch (URISyntaxException | IOException _) {
            throw new RuntimeException("Error when creating an EventsViewController");
        } 

        scene = new Scene(eventsView, 800, 600);
        stage.setScene(scene);
        setRoot(eventsView, "coreViewStyle.css");

        stage.show();
    }

    public void setRoot(Parent root, String styleFileName) {
        scene.setRoot(root);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/finaltppoo2/styles/" + styleFileName).toExternalForm());
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