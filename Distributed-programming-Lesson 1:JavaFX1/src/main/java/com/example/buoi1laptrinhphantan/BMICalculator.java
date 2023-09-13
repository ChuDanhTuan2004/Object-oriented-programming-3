package com.example.buoi1laptrinhphantan;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMICalculator {

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private void initialize() {
        calculateButton.setOnAction(event -> calculateBMI());
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            double bmi = weight / (height * height);
            resultLabel.setText(String.format("Your BMI is %.2f", bmi));
            if (bmi < 18.5 || bmi > 24.9) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Your BMI is outside the normal range (18.5 - 24.9). Please consult a doctor.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid weight and height values.");
            alert.showAndWait();
        }
    }
}