package com.lorenzo.raceteamcreator_bp02;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new LoginScreen(stage);
    }


    public static void main(String[] args) {
        launch();
    }
}