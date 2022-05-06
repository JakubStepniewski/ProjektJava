package com.example.bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
public class ControllerLogin {

    @FXML
    PasswordField passwordField;
    @FXML
    TextField loginField;
    @FXML
    private Button cancel;

    @FXML
    Label warning;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static String URL = "jdbc:mysql://h25.seohost.pl:3306/srv42082_java_2";
    private static String Login = "srv42082_java_2";
    private static String Password = "qwerty123$";
    private static String Query1 = "SELECT * FROM Konto";



    public void Login(ActionEvent event) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection(URL,Login,Password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Query1);

        String UserLogin = loginField.getText();
        String UserPassword = passwordField.getText();
        System.out.println(UserLogin);
        System.out.println(UserPassword);

        while (resultSet.next()){
            if (Objects.equals(UserLogin, resultSet.getString("Login")) && Objects.equals(UserPassword, resultSet.getString("Haslo"))){

                String Query2 = "SELECT Dane_osobowe.Imie, Dane_osobowe.Nazwisko, Dane_osobowe.Pesel, Dane_osobowe.Plec, Dane_osobowe.Wiek, Adres.Kraj, Adres.Miasto, Adres.Ulica, Adres.Nr_domu, Adres.Kod_pocztowy FROM Dane_osobowe, Adres, Konto WHERE Dane_osobowe.ID_Adres = Adres.ID_Adres AND Konto.ID_Osoby = Dane_osobowe.ID_Osoby AND Konto.ID_Konta = " + resultSet.getString("ID_Konta");

                resultSet = statement.executeQuery(Query2);
                resultSet.next();
                PersonalData.Person = resultSet;
                PersonalData.Name = resultSet.getString("Imie");
                PersonalData.Surname = resultSet.getString("Nazwisko");
                PersonalData.ID = resultSet.getString("Pesel");
                PersonalData.Sex = resultSet.getString("Plec");
                PersonalData.Age = Integer.parseInt(resultSet.getString("Wiek"));
                PersonalData.Country = resultSet.getString("Kraj");



                root = FXMLLoader.load(getClass().getResource("Desktop.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root,1200,800);
                stage.setScene(scene);
                stage.show();
            }
            else{
                warning.setText("Podano zle dane");
            }
        }


    }
    public void exit()
    {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
