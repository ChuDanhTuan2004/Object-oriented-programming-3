package com.example.buoi2_laptrinhphantan.khaosat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SurveyController {
    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private CheckBox option4;

    @FXML
    private Button submitButton;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);
    }

    @FXML
    public void submitSurvey() {
        String selectedOptions = "";

        if (option1.isSelected()) {
            selectedOptions += "Option 1, ";
        }

        if (option2.isSelected()) {
            selectedOptions += "Option 2, ";
        }

        if (option3.isSelected()) {
            selectedOptions += "Option 3, ";
        }

        if (option4.isSelected()) {
            selectedOptions += "Option 4, ";
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
            writer.write(selectedOptions);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        submitButton.setDisable(true);
    }
}
