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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SentenceController implements Initializable {
    String query = null;
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    Language language = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Sentence> sentenceTable;
    @FXML
    private TableColumn<Sentence, Integer> idsentences;
    @FXML
    private TableColumn<Sentence, String> _language;
    @FXML
    private TableColumn<Sentence, String> sentence_ex;
    @FXML
    private TableColumn<Sentence, Integer> idsyntax;
    @FXML
    private TextField sentence_idFld;
    @FXML
    private TextField lang_nameFld;
    @FXML
    private TextField sentenceFld;
    @FXML
    private TextField syntax_idFld;
    ObservableList<Sentence> sentenceList = FXCollections.observableArrayList();

    @FXML
    void saveData(ActionEvent event) throws SQLException {
        conn = ConnectDB();
        Integer idsentences = Integer.parseInt(sentence_idFld.getText());
        String _language = lang_nameFld.getText();
        String sentence_ex = sentenceFld.getText();
        Integer idsyntax = Integer.parseInt(syntax_idFld.getText());
        try{
            Statement stmt = conn.createStatement();
            String insertData = "INSERT INTO Sentences " + "VALUES("+idsentences+", '"+_language+"', '"+sentence_ex+"', "+idsyntax+")";
            stmt.executeUpdate(insertData);
        }catch(Exception e) {System.out.println(e);}

    }


    @FXML
    private void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sentences_screen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
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
    @FXML
    private void getAddView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add_sentence.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    private void refreshTable() throws SQLException {

        sentenceList.clear();
        query = "select * from sentences";
        prepStmt = conn.prepareStatement(query);
        rs = prepStmt.executeQuery();
        while(rs.next()){
            sentenceList.add(new Sentence(rs.getInt("idsentences"), rs.getInt("idsyntax"), rs.getString("_language"), rs.getString("sentence_ex")));
            sentenceTable.setItems(sentenceList);
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
        idsentences.setCellValueFactory(new PropertyValueFactory<Sentence, Integer>("idsentences"));
        idsyntax.setCellValueFactory(new PropertyValueFactory<Sentence, Integer>("idsyntax"));
        _language.setCellValueFactory(new PropertyValueFactory<Sentence, String>("_language"));
        sentence_ex.setCellValueFactory(new PropertyValueFactory<Sentence, String>("sentence_ex"));


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}