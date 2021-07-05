/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ToDoController {
    public Pane pane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String task;
    public String taskDescription;
    public String taskDate;
    public boolean completion;

    // getters and setters generated for Junit5 test implementation
    // ============================================================


    public String getTask() {
        // this function is meant to grab the string inputted into app
        // the string will then be returned
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskDescription() {
        // this function is meant to grab the string inputted into app
        // the string will then be returned
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDate() {
        // this function is meant to grab the string inputted into app
        // the string will then be returned
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public boolean isCompletion() {
        // if string entered matches "y, yes, complete" set to true
        // if string entered matches "n, no, not complete" set to false
        // return boolean
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    // lines 60 - 89 are simply for getting the GUI buttons to work when creating GUI mockup with Scene Builder
    // ========================================================================================================

    public void switchToToDoScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("ToDo.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAllListScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AllList.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSettingsScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Settings.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAboutScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("About.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void sceneButtonClicked1(ActionEvent actionEvent) {
        // button for top left menu
    }

    @FXML
    public void sceneButtonClicked2(ActionEvent actionEvent) {
        // button for middle left menu
    }

    @FXML
    public void sceneButtonClicked3(ActionEvent actionEvent) {
        // button for middle right menu
    }

    @FXML
    public void sceneButtonClicked4(ActionEvent actionEvent) {
        // button for top right menu
    }

}
