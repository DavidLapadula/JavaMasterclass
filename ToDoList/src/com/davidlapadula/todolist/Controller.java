package com.davidlapadula.todolist;

import datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetails;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;

    public void initialize() {

        // event listener for when selected property of the list view changes
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            // Anonymous class and override the changed method for whenever there is a new value
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                    if(newValue != null) {
                        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                        itemDetails.setText(item.getDetails());
                        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                        deadlineLabel.setText(df.format(item.getDeadline()));
                    }
            }
        });

        // Data loaded in init method of main class, and then loaded using getter from the Singleton
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void showNewItemDialogue() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        // Get the main window of the Scene where the dialog is called from. 'Owner' being the calling class
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Create a new Todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        // Get the pane and set the content as the root, which is the fxml file made to show modal dialogue info
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        // Show and wait present blocking dialog
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Gets the controller initialized in the FXML file
            DialogController controller = fxmlLoader.getController();

            TodoItem newItem = controller.processResults();
            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
        } else {
            System.out.println("Cancel pressed");
        }
    }

    // Deprecated method for only changing on mouseClick instead of whenever the value changes
    @FXML
    public void handleClickListView() {
        // return selected item; ony cast if dont specify type in ListView
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline());
//        itemDetails.setText(sb.toString());
    }

}
