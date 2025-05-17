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

        // establish connection with the database
        Connection dbConnection = Database.getConnection();




        // close the database connection after closing the primary stage
        Platform.runLater(()->
            primaryStage.setOnCloseRequest(_ -> { // _ is a unnamed variable; useful when we don't reused the variable as in this case
                try {
                    dbConnection.close();
                } catch(SQLException _) {
                    throw new RuntimeException("Failing to close the database Connection");
                }
            })
        );


    }

    public static void main(String[] args) {
        launch();


    }
}