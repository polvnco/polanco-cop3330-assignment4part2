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
    private TableView<Task> tableView = new TableView<>();
    @FXML
    private TableColumn<Task, String> taskColumn = new TableColumn<>();
    @FXML
    private TableColumn<Task, String> taskDescriptionColumn = new TableColumn<>();
    @FXML
    private TableColumn<Task, LocalDate> dueDateColumn = new TableColumn<>();
    @FXML
    private TableColumn<Task, String> choiceBoxColumn = new TableColumn<>();
    @FXML
    public ComboBox<String> choiceBoxData = new ComboBox<>();


    private static ObjectProperty call(TableColumn.CellDataFeatures<Task, LocalDate> cellData) {
        return cellData.getValue().dueDateProperty();
    }


    // lines 59 - 89 are simply for getting the GUI buttons to work when creating GUI mockup with Scene Builder
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
                        "Complete", LocalDate.of(2001, 12, 17)));
        people.add(new Task
                ("Cook for Babushka",
                        "The family says \"I owe them a favor\"",
                        "Complete", LocalDate.of(1997, 10, 1)));
        people.add(new Task
                ("Call the Governor",
                        "IDK just been told to give them a call...",
                        "Complete", LocalDate.of(1999, 1, 21)));

        return people;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // this would allow the TableView cells to become editable
        tableView.setEditable(true);

        // lines 115 - 130 are used to make the new values be inserted into the TableView by their specific property
        taskColumn.setCellValueFactory(new PropertyValueFactory<>("task"));
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));
        dueDateColumn.setCellValueFactory(ToDoController::call);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dueDateColumn.setCellFactory(taskDateColumn -> new TableCell<>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else setText(formatter.format(item));
            }
        });
        choiceBoxColumn.setCellValueFactory(new PropertyValueFactory<>("Completion"));

        // labels for ComboBox options
        choiceBoxData.getItems().add("Complete");
        choiceBoxData.getItems().add("Not Complete");

        // fills in table with preloaded values
        tableView.setItems(getPeople());
    }

    public void buttonAdd(ActionEvent actionEvent) {
        // controls what the values the button will have when the button is clicked / touched
        Task t = new Task
                        (
                                textFieldTask.getText(),
                                textFieldDescription.getText(),
                                choiceBoxData.getValue(),
                                datePickerField.getValue()
                        );
        tableView.getItems().add(t);
    }
}
