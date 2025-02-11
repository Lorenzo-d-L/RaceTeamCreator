package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class ShowTeamScreen {
//    TeamController tc = new TeamController();
private Pane root = new Pane();
    private Scene scene;
    private VBox nav = new VBox();
    private HBox showAllTeams = new HBox();
    private HBox createTeam = new HBox();
    private HBox home = new HBox();
    private VBox icon = new VBox();

    public ShowTeamScreen(Stage stage) {
        scene = new Scene(root, 800, 600);

        Label title = new Label("Show Team");
        title.setId("title");

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

        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/ShowTeamScreen.css").toExternalForm();
        scene.getStylesheets().add(css);

        home.setOnMouseClicked(e -> {
            new HomeScreen(stage);
        });

        addTeam.setOnMouseClicked(e -> {
            try {
                new AddScreen(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        stage.setResizable(false);
        stage.setTitle("Show Team");
        stage.setScene(scene);
        stage.show();

        }


    }

