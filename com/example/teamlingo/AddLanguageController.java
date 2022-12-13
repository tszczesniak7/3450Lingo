package com.example.teamlingo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.teamlingo.PrimaryController.ConnectDB;

public class AddLanguageController implements Initializable {
    String query = null;
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    Language language = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField lang_idFld;
    @FXML
    private TextField lang_nameFld;
    @FXML
    private TextField lang_famFld;
    @FXML
    private TextField prog_langFld;
    @FXML
    private Button saveButton;


    @FXML
    void saveData(ActionEvent event) throws SQLException {
        conn = ConnectDB();
        Integer idlanguages = Integer.parseInt(lang_idFld.getText());
        String _language = lang_nameFld.getText();
        String language_family = lang_famFld.getText();
        String progenative_language = prog_langFld.getText();
        try{
            Statement stmt = conn.createStatement();
            String insertData = "INSERT INTO Languages " + "VALUES("+idlanguages+", '"+_language+"', '"+language_family+"', '"+progenative_language+"')";
            stmt.executeUpdate(insertData);
        }catch(Exception e) {System.out.println(e);}

    }


    @FXML
    private void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("language_screen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}