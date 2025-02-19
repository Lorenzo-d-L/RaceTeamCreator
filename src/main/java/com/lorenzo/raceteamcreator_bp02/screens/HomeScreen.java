package com.lorenzo.raceteamcreator_bp02.screens;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
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
import javafx.scene.shape.Circle;
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
    private Circle[] light = new Circle[5];


    public HomeScreen(Stage stage) {
        title.setId("title");
        changeTitleColor(title);
        intro();

        // Create the scene
        scene = new Scene(root, 800, 600);

        // Set the size of the panes
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

        // Add the logo to the home screen
        Image logo = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm());
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Add the home button in the home screen
        Image homeIcon = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HomeBut.png").toExternalForm());
        ImageView homeButton = new ImageView(homeIcon);
        homeButton.setFitWidth(50);
        homeButton.setFitHeight(50);

        // Add the showAllTeams button in the home screen
        Image show = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/ShowAll.png").toExternalForm());
        ImageView showAll = new ImageView(show);
        showAll.setFitWidth(50);
        showAll.setFitHeight(50);

        // Add the addTeam button in the home screen
        Image add = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/Add.png").toExternalForm());
        ImageView addTeam = new ImageView(add);
        addTeam.setFitWidth(50);
        addTeam.setFitHeight(50);

        // Add the panes to the root pane
        root.getChildren().addAll(nav, icon);
        nav.getChildren().addAll(home, showAllTeams, createTeam);
        icon.getChildren().add(imageView);
        home.getChildren().add(homeButton);
        showAllTeams.getChildren().add(showAll);
        createTeam.getChildren().add(addTeam);

        // Set the id's for the panes and labels
        root.setId("root");
        nav.setId("nav");
        home.setId("home");
        showAllTeams.setId("showAllTeams");
        createTeam.setId("createTeam");
        icon.setId("icon");
        title.setId("title");

        // Add the css file to the scene
        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/HomeScreen.css").toExternalForm();
        scene.getStylesheets().add(css);

        // If the user clicks on the home button, go to the home screen
        // This button is not needed in the home screen, but it is added for consistency
        homeButton.setOnMouseClicked(e -> {
            try {
                new HomeScreen(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Set the event for the addTeam button to go to the AddScreen
        addTeam.setOnMouseClicked(e -> {
            try {
                new AddScreen(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Set the event for the showAllTeams button to show the ShowTeamScreen
        showAll.setOnMouseClicked(e -> {
            new ShowTeamScreen(stage);
        });

        // Set the stage
        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();

    }

    private void changeTitleColor(Label title) {
        // Create a Timeline with three KeyFrames
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> title.setTextFill(Color.RED)),
                new KeyFrame(Duration.seconds(1), e -> title.setTextFill(Color.GREEN)),
                new KeyFrame(Duration.seconds(2), e -> title.setTextFill(Color.BLUE))
        );
        // Set the cycle count to indefinite
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void intro() {
        // Initialize the circles and add them to the root pane
        for (int i = 0; i < light.length; i++) {
            light[i] = new Circle(50, Color.BLACK);
            light[i].setLayoutX(200 + i * 125);
            light[i].setLayoutY(300);
            root.getChildren().add(light[i]);
        }
        // Create a SequentialTransition
        SequentialTransition st = new SequentialTransition();
        for (int i = 0; i < light.length; i++) {
            int index = i;
            Timeline tl = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> light[index].setFill(Color.RED))
            );
            st.getChildren().add(tl);
        }
        // Add a KeyFrame to the SequentialTransition to hide the circles and show the title
        Timeline tl = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    for (Circle c : light) {
                        c.setVisible(false);
                    }
                    title.setLayoutX(250);
                    title.setLayoutY(300);
                    root.getChildren().add(title);
                })
        );
        st.getChildren().add(tl);
        st.play();
    }
}
