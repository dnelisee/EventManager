package com.polytechnique.finaltppoo2;

import com.polytechnique.finaltppoo2.util.Database;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        // establish connection with the database
        Connection dbConnection = Database.getConnection();



        //...



        // close the database connection after closing the primary stage
        Platform.runLater(()->{
            primaryStage.setOnCloseRequest(windowEvent -> {
                try {
                    dbConnection.close();
                } catch(SQLException ex) {
                    throw new RuntimeException("Failing to close the database Connection");
                }
            });
        });


    }

    public static void main(String[] args) {
        launch();


    }
}