/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ToDo extends Application {






    @Override
    public void start(Stage stage) {
        try {

            /* create scene for when building and running app, opens first scene specified */

            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("ToDo.fxml"))));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("To-Do Something...");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}