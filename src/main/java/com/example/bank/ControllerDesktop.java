package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerDesktop implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button Name;


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
        System.out.println("Halo Stachu ?");
        try {
            Name.setText(PersonalData.Person.getString("Imie") + " " + PersonalData.Person.getString("Nazwisko"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
