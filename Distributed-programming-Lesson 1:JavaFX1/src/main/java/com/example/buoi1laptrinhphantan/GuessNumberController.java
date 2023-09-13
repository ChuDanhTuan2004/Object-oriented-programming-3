package com.example.buoi1laptrinhphantan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class GuessNumberController {
    @FXML
    private TextField inputField;

    @FXML
    private void handleGuessButtonAction(ActionEvent event) {
        try {
            int inputNumber = Integer.parseInt(inputField.getText());
            int randomNumber = (int) (Math.random() * 101);

            if (inputNumber == randomNumber) {
                showAlert("Correct!", "Congratulations, you guessed the number!");
            } else {
                showAlert("Wrong!", "The number was " + randomNumber);
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Please enter a valid number.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
