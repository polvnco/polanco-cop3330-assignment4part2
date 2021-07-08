/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ucf.assignments;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class ToDoController implements Initializable {
    public Pane pane;
    public TextField textFieldTask;
    public TextField textFieldDescription;
    public DatePicker datePickerField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Task> tableView;
    @FXML
    private TableColumn<Task, String> taskColumn;
    @FXML
    private TableColumn<Task, String> taskDescriptionColumn;
    @FXML
    private TableColumn<Task, LocalDate> dueDateColumn;

    private static ObjectProperty call(TableColumn.CellDataFeatures<Task, LocalDate> cellData) {
        return cellData.getValue().dueDateProperty();
    }


    // lines 77 - 126 are simply for getting the GUI buttons to work when creating GUI mockup with Scene Builder
    // ========================================================================================================

    public void switchToToDoScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("ToDo.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAllListScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AllList.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSettingsScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Settings.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAboutScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("About.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<Task> getPeople() {
        ObservableList<Task> people = FXCollections.observableArrayList();
        people.add(new Task
                ("Mount TV's",
                        "Need to finish before my Wife's boyfriend beats me",
                        LocalDate.of(2001, 12, 17)));
        people.add(new Task
                ("Cook for Babushka",
                        "The family says \"I owe them a favor\"",
                        LocalDate.of(1997, 10, 1)));
        people.add(new Task
                ("Call the Governor",
                        "IDK just been told to give them a call...",
                        LocalDate.of(1999, 1, 21)));

        return people;
    }

    public void initialize(URL url, ResourceBundle rb) {

        taskColumn.setCellValueFactory(new PropertyValueFactory<>("task"));
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));
        dueDateColumn.setCellValueFactory(ToDoController::call);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        dueDateColumn.setCellFactory(birthDateColumn -> new TableCell<>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else setText(formatter.format(item));
            }
        });

        tableView.setItems(getPeople());

        tableView.setEditable(true);
    }

    public void buttonAdd(ActionEvent actionEvent) {
        Task t = new Task(textFieldTask.getText(), textFieldDescription.getText(), datePickerField.getValue());
        tableView.getItems().add(t);
    }
}
