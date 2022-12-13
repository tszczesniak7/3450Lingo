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

public class VerbTenseController implements Initializable {
    String query = null;
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    Language language = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<VerbTense> verbTenseTable;
    @FXML
    private TableColumn<VerbTense, Integer> idverb_tense;
    @FXML
    private TableColumn<VerbTense, String> _language;
    @FXML
    private TableColumn<VerbTense, String> past_simple;
    @FXML
    private TableColumn<VerbTense, String> past_perfect;
    @FXML
    private TableColumn<VerbTense, String> past_continuous;
    @FXML
    private TableColumn<VerbTense, String> present_simple;
    @FXML
    private TableColumn<VerbTense, String> present_perfect;
    @FXML
    private TableColumn<VerbTense, String> present_continuous;
    @FXML
    private TableColumn<VerbTense, String> future_simple;
    @FXML
    private TableColumn<VerbTense, String> future_perfect;
    @FXML
    private TableColumn<VerbTense, String> future_continuous;
    @FXML
    private TableColumn<VerbTense, Integer> idsyntax;



    @FXML
    private TextField future_conFld;
    @FXML
    private TextField future_perFld;
    @FXML
    private TextField future_simFld;
    @FXML
    private TextField lang_nameFld;
    @FXML
    private TextField past_conFld;
    @FXML
    private TextField past_perFld;
    @FXML
    private TextField past_simFld;
    @FXML
    private TextField pres_conFld;
    @FXML
    private TextField pres_perFld;
    @FXML
    private TextField pres_simFld;
    @FXML
    private TextField syntax_idFld;
    @FXML
    private TextField vt_idFld;

    ObservableList<VerbTense> verbTenseList = FXCollections.observableArrayList();

    @FXML
    void saveData(ActionEvent event) throws SQLException {
        conn = ConnectDB();
        Integer idverb_tense = Integer.parseInt(vt_idFld.getText());
        String _language = lang_nameFld.getText();
        String past_simple = past_simFld.getText();
        String present_simple = pres_simFld.getText();
        String future_simple = future_simFld.getText();
        String past_perfect = past_perFld.getText();
        String present_perfect = pres_perFld.getText();
        String future_perfect = future_perFld.getText();
        String past_continuous = past_conFld.getText();
        String present_continuous = pres_conFld.getText();
        String future_continuous = future_conFld.getText();
        Integer idsyntax = Integer.parseInt(syntax_idFld.getText());

        try {
            Statement stmt = conn.createStatement();
            String insertData = "INSERT INTO verb_tense " + "VALUES(" + idverb_tense + ", '" + _language + "', '" + past_simple + "', '" + past_perfect + "', '"
                    + past_continuous + "', '" + present_simple + "', '" + present_perfect + "', '" + present_continuous + "', '" + future_simple + "', '"
                    + future_perfect + "', '" + future_continuous + "', "
                    + idsyntax + ")";
            stmt.executeUpdate(insertData);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @FXML
    private void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("verb_tenses.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToHomeScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLangScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("language_screen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSentencesScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sentences_screen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSyntaxScrn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("syntax_rules.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        root = FXMLLoader.load(getClass().getResource("add_verbtense.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void refreshTable() throws SQLException {

        verbTenseList.clear();
        query = "select * from verb_tense";
        prepStmt = conn.prepareStatement(query);
        rs = prepStmt.executeQuery();
        while (rs.next()) {
            verbTenseList.add(new VerbTense(
                    rs.getInt("idverb_tense"), rs.getString("_language"), rs.getString("past_simple"), rs.getString("past_perfect"),
                    rs.getString("past_continuous"), rs.getString("present_simple"), rs.getString("present_perfect"), rs.getString("present_continuous"),
                    rs.getString("future_simple"), rs.getString("future_perfect"), rs.getString("future_continuous"), rs.getInt("idsyntax")
            ));
            verbTenseTable.setItems(verbTenseList);
        }
    }

    public static Connection ConnectDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TeamLingo", "root", "root");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @FXML
    private void loadData() throws SQLException {

        conn = ConnectDB();
        refreshTable();
        idverb_tense.setCellValueFactory(new PropertyValueFactory<VerbTense, Integer>("idverb_tense"));
        _language.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("_language"));
        past_simple.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("past_simple"));
        past_perfect.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("past_perfect"));
        past_continuous.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("past_continuous"));
        present_simple.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("present_simple"));
        present_perfect.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("present_perfect"));
        present_continuous.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("present_continuous"));
        future_simple.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("future_simple"));
        future_perfect.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("future_perfect"));
        future_continuous.setCellValueFactory(new PropertyValueFactory<VerbTense, String>("future_continuous"));
        idsyntax.setCellValueFactory(new PropertyValueFactory<VerbTense, Integer>("idsyntax"));




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}