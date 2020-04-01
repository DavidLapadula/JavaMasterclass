package com.davidlapadula.todolist;

import datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetails;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
        TodoItem item1 =  new TodoItem("Birthday Card", "Buy birthday card for some person", LocalDate.of(2020, Month.APRIL, 1));
        TodoItem item2 =  new TodoItem("Groceries", "Go shopping for some food", LocalDate.of(2020, Month.MARCH, 1));
        TodoItem item3 =  new TodoItem("Mechanic", "Go get my car fixed and the mechanic", LocalDate.of(2020, Month.MAY, 4));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);

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

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
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
