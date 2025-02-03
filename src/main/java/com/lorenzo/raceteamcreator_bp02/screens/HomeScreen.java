package com.lorenzo.raceteamcreator_bp02.screens;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreen {
    private Pane root = new Pane();
    private Scene scene;
    private VBox nav = new VBox();
    private HBox showAllTeams = new HBox();
    private HBox createTeam = new HBox();
    private HBox home = new HBox();
    private VBox icon = new VBox();

    public HomeScreen(Stage stage) {
        scene = new Scene(root, 800, 600);

        icon.setPrefSize(100, 100);

        nav.setPrefSize(100,550);
        nav.setLayoutY(50);
        nav.setAlignment(javafx.geometry.Pos.CENTER);
        nav.setSpacing(50);

        home.setPrefSize(50,50);
        home.setMaxSize(50,50);

        createTeam.setPrefSize(50,50);
        createTeam.setMaxSize(50,50);

        showAllTeams.setPrefSize(50,50);
        showAllTeams.setMaxSize(50,50);


    root.setStyle("-fx-background-color: #c95c5c");
    nav.setStyle("-fx-background-color: #000000");
    showAllTeams.setStyle("-fx-background-color: #b49d9d");
    createTeam.setStyle("-fx-background-color: #58cebf");
    home.setStyle("-fx-background-color: #bb45c7");
    icon.setStyle("-fx-background-color: #ff0000");

        root.getChildren().addAll(nav, icon);
        nav.getChildren().addAll(showAllTeams, createTeam, home);

        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}
