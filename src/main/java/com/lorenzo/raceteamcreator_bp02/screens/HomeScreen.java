package com.lorenzo.raceteamcreator_bp02.screens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HomeScreen {
    private Pane root = new Pane();
    private Scene scene;
    private VBox nav = new VBox();
    private HBox showAllTeams = new HBox();
    private HBox createTeam = new HBox();
    private HBox home = new HBox();
    private VBox icon = new VBox();
    private Label title = new Label("Welkom bij RaceTeamCreator");


    public HomeScreen(Stage stage) {
        title.setId("title");
        changeTitleColor(title);
        moveTitle(title);

        scene = new Scene(root, 800, 600);

        icon.setPrefSize(100, 100);
        icon.setMaxSize(100, 100);

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

        Image logo = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm());
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Image homeIcon = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HomeBut.png").toExternalForm());
        ImageView homeButton = new ImageView(homeIcon);
        homeButton.setFitWidth(50);
        homeButton.setFitHeight(50);

        Image show = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/ShowAll.png").toExternalForm());
        ImageView showAll = new ImageView(show);
        showAll.setFitWidth(50);
        showAll.setFitHeight(50);

        Image add = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/Add.png").toExternalForm());
        ImageView addTeam = new ImageView(add);
        addTeam.setFitWidth(50);
        addTeam.setFitHeight(50);

        title.setLayoutX(350);
        title.setLayoutY(300);

        root.getChildren().addAll(nav, icon, title);
        nav.getChildren().addAll(home, showAllTeams, createTeam);
        icon.getChildren().add(imageView);
        home.getChildren().add(homeButton);
        showAllTeams.getChildren().add(showAll);
        createTeam.getChildren().add(addTeam);

        root.setId("root");
        nav.setId("nav");
        home.setId("home");
        showAllTeams.setId("showAllTeams");
        createTeam.setId("createTeam");
        icon.setId("icon");
        title.setId("title");


        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/HomeScreen.css").toExternalForm();
        scene.getStylesheets().add(css);


        addTeam.setOnMouseClicked(e -> {
            try {
                new AddScreen(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        showAll.setOnMouseClicked(e -> {
            new ShowTeamScreen(stage);
        });


        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();

    }

    private void changeTitleColor(Label title) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> title.setTextFill(Color.RED)),
                new KeyFrame(Duration.seconds(1), e -> title.setTextFill(Color.GREEN)),
                new KeyFrame(Duration.seconds(2), e -> title.setTextFill(Color.BLUE))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void moveTitle(Label title) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> {
                    title.setLayoutX(150);
                    title.setLayoutY(500);
                }),
                new KeyFrame(Duration.seconds(1), e -> {
                    title.setLayoutX(150);
                    title.setLayoutY(400);
                }),
                new KeyFrame(Duration.seconds(2), e -> {
                    title.setLayoutX(150);
                    title.setLayoutY(300);
                }),
                new KeyFrame(Duration.seconds(3), e -> {
                    title.setLayoutX(150);
                    title.setLayoutY(200);
                }),
                new KeyFrame(Duration.seconds(4), e -> {
                    title.setLayoutX(150);
                    title.setLayoutY(100);
                }),
                new KeyFrame(Duration.seconds(5), e -> {
                    title.setLayoutX(250);
                    title.setLayoutY(100);
                }),
                new KeyFrame(Duration.seconds(6), e -> {
                    title.setLayoutX(350);
                    title.setLayoutY(100);
                }),
                new KeyFrame(Duration.seconds(7), e -> {
                    title.setLayoutX(350);
                    title.setLayoutY(200);
                }),
                new KeyFrame(Duration.seconds(8), e -> {
                    title.setLayoutX(250);
                    title.setLayoutY(300);
                }),
                new KeyFrame(Duration.seconds(9), e -> {
                    title.setLayoutX(300);
                    title.setLayoutY(400);
                }),
                new KeyFrame(Duration.seconds(10), e -> {
                    title.setLayoutX(350);
                    title.setLayoutY(500);
                }),
                new KeyFrame(Duration.seconds(11), e -> {
                    title.setLayoutX(450);
                    title.setLayoutY(500);
                })

        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
