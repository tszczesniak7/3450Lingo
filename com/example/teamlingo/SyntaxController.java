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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.teamlingo.PrimaryController.ConnectDB;


public class SyntaxController implements Initializable {
    @FXML
    private TableView<Syntax> syntaxTable;
    @FXML
    private TableColumn<Syntax, Integer> idsyntax;
    @FXML
    private TableColumn<Syntax, String> _language;
    @FXML
    private TableColumn<Syntax, String> word_order;
    @FXML
    private TableColumn<Syntax, String> declension_system;
    @FXML
    private TableColumn<Syntax, String> gender_rules;
    @FXML
    private TableColumn<Syntax, String> particle_words;
    String query = null;
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    Syntax syntax = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField syntax_idFld;
    @FXML
    private TextField lang_nameFld;
    @FXML
    private TextField word_orderFld;
    @FXML
    private TextField declen_sysFld;
    @FXML
    private TextField gender_rulesFld;
    @FXML
    private TextField part_wordsFld;

    @FXML
    void saveData(ActionEvent event) throws SQLException {
        conn = ConnectDB();
        Integer idsyntax = Integer.parseInt(syntax_idFld.getText());
        String _language = lang_nameFld.getText();
        String word_order = word_orderFld.getText();
        String declension_system = declen_sysFld.getText();
        String gender_rules = gender_rulesFld.getText();
        String part_words = part_wordsFld.getText();
        try{
            Statement stmt = conn.createStatement();
            String insertData = "INSERT INTO Syntax_Rules " + "VALUES("+idsyntax+", '"+word_order+"', '"+declension_system+"', '"+gender_rules+"', '"+part_words+"', '"+_language+"')";
            stmt.executeUpdate(insertData);
        }catch(Exception e) {System.out.println(e);}

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
    ObservableList<Syntax> syntaxList = FXCollections.observableArrayList();

    @FXML
    private void getAddView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add_syntax.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void refreshTable() throws SQLException {

        syntaxList.clear();
        query = "select * from syntax_rules";
        prepStmt = conn.prepareStatement(query);
        rs = prepStmt.executeQuery();
        while(rs.next()){
            syntaxList.add(new Syntax(rs.getInt("idsyntax"), rs.getString("_language"), rs.getString("word_order"), rs.getString("declension_system"), rs.getString("gender_rules"), rs.getString("particle_words")));
            syntaxTable.setItems(syntaxList);
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
        idsyntax.setCellValueFactory(new PropertyValueFactory<Syntax, Integer>("idsyntax"));
        _language.setCellValueFactory(new PropertyValueFactory<Syntax, String>("_language"));
        word_order.setCellValueFactory(new PropertyValueFactory<Syntax, String>("word_order"));
        declension_system.setCellValueFactory(new PropertyValueFactory<Syntax, String>("declension_system"));
        gender_rules.setCellValueFactory(new PropertyValueFactory<Syntax, String>("gender_rules"));
        particle_words.setCellValueFactory(new PropertyValueFactory<Syntax, String>("particle_words"));

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}