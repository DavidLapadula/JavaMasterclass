package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
       if (e.getSource().equals(helloButton)) {
           System.out.println("Hello " + nameField.getText());
       } else if (e.getSource().equals(byeButton)) {
           System.out.println("Bye " + nameField.getText());
       }

       // Define runnable
       Runnable task = new Runnable() {
           @Override
           public void run() {
               try {
                   String s = Platform.isFxApplicationThread() ? "UI Thread" : "BR Thread";
                   System.out.println("Sleep on the: " + s);
                   Thread.sleep(10000);
                   // Put code to run on the UI thread; necessary for JavaFx
                   Platform.runLater(new Runnable() {
                       @Override
                       public void run() {
                           String s = Platform.isFxApplicationThread() ? "UI Thread" : "BR Thread";
                           System.out.println("Updating label on the: " + s);
                           ourLabel.setText("We did something!");
                       }
                   });
               } catch(InterruptedException event) {
                   // Throw event
               }

           }
       };

       // Run the thread
       new Thread(task).start();

       if (ourCheckBox.isSelected()) {
           nameField.clear();
           helloButton.setDisable(true);
           byeButton.setDisable(true);
       }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
