module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;


    opens com.example.controller to javafx.fxml;
    exports com.example;
    exports com.example.model;
    exports com.example.controller;
}
