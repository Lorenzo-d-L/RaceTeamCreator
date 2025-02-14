package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.PopUp.EditPopup;
import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.Team;
import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class ShowTeamScreen {
//    TeamController tc = new TeamController();
private Pane root = new Pane();
    private Scene scene;
    private VBox nav = new VBox();
    private HBox showAllTeams = new HBox();
    private HBox createTeam = new HBox();
    private HBox home = new HBox();
    private VBox icon = new VBox();
    private TeamController tc;
    private Database db;

    public ShowTeamScreen(Stage stage) {
        db = new Database();
        tc = new TeamController(db);
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

        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Racing+Sans+One&display=swap");
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

        showTeams();
        }

    public void showTeams() {
        List<Team> teams = tc.getTeams();
        FlowPane teamBox = new FlowPane();
        teamBox.setLayoutX(150);
        teamBox.setLayoutY(10);
        teamBox.setHgap(10);
        teamBox.setVgap(10);

        for (Team team : teams) {
            VBox teamInfoBox = new VBox();
            teamInfoBox.setId("teamInfoBox");
            teamInfoBox.setPrefSize(300, 75);
            teamInfoBox.setSpacing(10);
            teamInfoBox.setStyle("-fx-border-color: black; -fx-padding: 10;");

            HBox teamButtons = new HBox();
            teamButtons.setSpacing(20);

            Label teamName = new Label("Name: " + team.getTeamName());
            Label teamColor = new Label("Color: " + team.getTeamColor());
            Label teamCountry = new Label("Country: " + team.getTeamCountry());
            Label teamYear = new Label("Year: " + team.getTeamYear().toString());
            Label teamMotor = new Label("Motor: " + team.getTeamMotor());
            Label teamDriver1 = new Label("Driver 1: " + team.getTeamDriver1());
            Label teamDriver2 = new Label("Driver 2: " + team.getTeamDriver2());
            Label teamManager = new Label("Manager: " + team.getTeamManager());

            Image edit = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/Edit_icon.png").toExternalForm());
            ImageView editIcon = new ImageView(edit);
            editIcon.setFitWidth(20);
            editIcon.setFitHeight(20);

            Image delete = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/Delete_icon.png").toExternalForm());
            ImageView deleteIcon = new ImageView(delete);
            deleteIcon.setFitWidth(20);
            deleteIcon.setFitHeight(20);

            teamInfoBox.getChildren().addAll(teamName, teamColor, teamCountry, teamYear, teamMotor, teamManager, teamDriver1, teamDriver2, teamButtons);
            teamButtons.getChildren().addAll(editIcon, deleteIcon);
            teamBox.getChildren().add(teamInfoBox);

            editIcon.setOnMouseClicked(e -> {
                new EditPopup(new Stage(), team);
            });

            deleteIcon.setOnMouseClicked(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Are you sure?");
                alert.setHeaderText("Are you sure you want to delete this?");
                alert.setContentText("If you delete this you can't get it back");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    try {
                        tc.deleteTeam(team.getTeamId());
                        teamBox.getChildren().remove(teamInfoBox);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(teamBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutX(125);
        scrollPane.setLayoutY(50);
        scrollPane.setPrefViewportHeight(500);
        scrollPane.setPrefViewportWidth(650);

        teamBox.setId("teamBox");
        root.getChildren().add(scrollPane);
    }
}

