package com.lorenzo.raceteamcreator_bp02;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        new LoginScreen(stage);

        Image appIcon = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm());
        stage.getIcons().add(appIcon);
    }


    public static void main(String[] args) {
        launch();
    }
}