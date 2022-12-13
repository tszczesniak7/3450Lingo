package com.example.teamlingo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class PrimaryController implements Initializable {

    @FXML
    private TableView<Language> langTable;
    @FXML
    private TableColumn<Language, Integer> idlanguages;
    @FXML
    private TableColumn<Language, String> _language;
    @FXML
    private TableColumn<Language, String> language_family;
    @FXML
    private TableColumn<Language, String> progenative_language;

    String query = null;
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHomeScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLangScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("language_screen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSentencesScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sentences_screen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSyntaxScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("syntax_rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToVerbTenseScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("verb_tenses.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    ObservableList<Language> languageList = FXCollections.observableArrayList();

    @FXML
    private void getAddView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add_language.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void refreshTable() throws SQLException {

        languageList.clear();
        query = "select * from LANGUAGES";
        prepStmt = conn.prepareStatement(query);
        rs = prepStmt.executeQuery();
        while(rs.next()){
            languageList.add(new Language(rs.getInt("idlanguages"), rs.getString("_language"), rs.getString("language_family"), rs.getString("progenative_language")));
            langTable.setItems(languageList);
        }
    }

    public static Connection ConnectDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TeamLingo","root","root");
            return conn;
        }catch(Exception e) {System.out.println(e);
            return null; }
    }
    @FXML
    private void loadData() throws SQLException {

        conn = ConnectDB();
        refreshTable();
        idlanguages.setCellValueFactory(new PropertyValueFactory<Language, Integer>("idlanguages"));
        _language.setCellValueFactory(new PropertyValueFactory<Language, String>("_language"));
        language_family.setCellValueFactory(new PropertyValueFactory<Language, String>("language_family"));
        progenative_language.setCellValueFactory(new PropertyValueFactory<Language, String>("progenative_language"));

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}