package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerAccount implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button Welcome;
    @FXML
    Label Name;
    @FXML
    Label Surname;
    @FXML
    Label ID;
    @FXML
    Label Age;
    @FXML
    Label Sex;
    @FXML
    Label Email;
    @FXML
    Label Phone;


    public void openDesktopPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Desktop.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void openTransactionPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void openAccountPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Siema Zdzichu");
        Welcome.setText(PersonalData.Name + " " + PersonalData.Surname);
        Name.setText("Imie: " + PersonalData.Name);
        Surname.setText("Nazwisko: " + PersonalData.Surname);
        ID.setText("Pesel: " + PersonalData.ID);
        Sex.setText("Pleć: " + PersonalData.Sex);
        Age.setText("Wiek: " + PersonalData.Age);

    }
    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Welcome.setText(PersonalData.Person.getString("Imie") + " " + PersonalData.Person.getString("Nazwisko"));
            Name.setText("Imie: " + PersonalData.Person.getString("Imie"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     */
}
