module com.example.teamlingo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.teamlingo to javafx.fxml;
    exports com.example.teamlingo;
}