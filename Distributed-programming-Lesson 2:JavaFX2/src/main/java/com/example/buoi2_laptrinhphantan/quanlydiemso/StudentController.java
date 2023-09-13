package com.example.buoi2_laptrinhphantan.quanlydiemso;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> classColumn;

    @FXML
    private TableColumn<Student, String> genderColumn;

    @FXML
    private TableColumn<Student, String> addressColumn;

    @FXML
    private TableColumn<Student, Double> scoreColumn;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField classField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField scoreField;

    @FXML
    private Button addStudentButton;

    @FXML
    private Button updateStudentButton;

    @FXML
    private Button deleteStudentButton;

    private List<Student> students = new ArrayList<>();

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("clazz"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        studentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                idField.setText(newSelection.getId());
                nameField.setText(newSelection.getName());
                classField.setText(newSelection.getClazz());
                genderField.setText(newSelection.getGender());
                addressField.setText(newSelection.getAddress());
                scoreField.setText(String.valueOf(newSelection.getScore()));
            }
        });
    }

    @FXML
    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String clazz = classField.getText();
        String gender = genderField.getText();
        String address = addressField.getText();
        double score = Double.parseDouble(scoreField.getText());

        Student student = new Student(id, name, clazz, gender, address, score);
        students.add(student);
        studentTable.getItems().add(student);

        clearFields();
    }

    @FXML
    private void updateStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            selectedStudent.setId(idField.getText());
            selectedStudent.setName(nameField.getText());
            selectedStudent.setClazz(classField.getText());
            selectedStudent.setGender(genderField.getText());
            selectedStudent.setAddress(addressField.getText());
            selectedStudent.setScore(Double.parseDouble(scoreField.getText()));

            studentTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            students.remove(selectedStudent);
            studentTable.getItems().remove(selectedStudent);

            clearFields();
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        classField.clear();
        genderField.clear();
        addressField.clear();
        scoreField.clear();
    }
}
