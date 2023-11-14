package com.example.controller;

import java.io.IOException;

import com.example.App;

import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    public void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

        
}
