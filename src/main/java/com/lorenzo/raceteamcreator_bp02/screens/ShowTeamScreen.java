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
private Pane root;
    private Scene scene;
    private VBox nav;
    private HBox showAllTeams;
    private HBox createTeam;
    private HBox home;
    private VBox icon;
    private TeamController tc;
    private Database db;

    public ShowTeamScreen(Stage stage) {
        root = new Pane();
        nav = new VBox();
        showAllTeams = new HBox();
        createTeam = new HBox();
        home = new HBox();
        icon = new VBox();
        db = new Database();
        tc = new TeamController(db);
        scene = new Scene(root, 800, 600);

        Label title = new Label("Show Team");
        title.setId("title");

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

        // Add the logo to the show team screen
        Image logo = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm());
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Add the home button in the show team screen
        Image homeIcon = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HomeBut.png").toExternalForm());
        ImageView homeButton = new ImageView(homeIcon);
        homeButton.setFitWidth(50);
        homeButton.setFitHeight(50);

        // Add the showAllTeams button in the show team screen
        Image show = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/ShowAll.png").toExternalForm());
        ImageView showAll = new ImageView(show);
        showAll.setFitWidth(50);
        showAll.setFitHeight(50);

        // Add the createTeam button in the show team screen
        Image add = new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/Add.png").toExternalForm());
        ImageView addTeam = new ImageView(add);
        addTeam.setFitWidth(50);
        addTeam.setFitHeight(50);

        // Add the items to the panes
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

        // Add the css file and create the scene
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Racing+Sans+One&display=swap");
        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/ShowTeamScreen.css").toExternalForm();
        scene.getStylesheets().add(css);

        // If this button is clicked, go to the home screen
        home.setOnMouseClicked(e -> {
            new HomeScreen(stage);
        });

        // If this button is clicked, go to the show all teams screen
        // This button is not needed in the show team screen, but it is added for consistency
        showAllTeams.setOnMouseClicked(e -> {
            new ShowTeamScreen(stage);
        });

        // If this button is clicked, go to the add screen
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

        // Show all the teams in the database
    public void showTeams() {
        // The list data is retrieved from the database
        List<Team> teams = tc.getTeams();
        FlowPane teamBox = new FlowPane();
        teamBox.setLayoutX(150);
        teamBox.setLayoutY(10);
        teamBox.setHgap(10);
        teamBox.setVgap(10);

        // Add the teams to the flowpane to see them
        for (Team team : teams) {
            VBox teamInfoBox = new VBox();
            teamInfoBox.setId("teamInfoBox");
            teamInfoBox.setPrefSize(300, 75);
            teamInfoBox.setSpacing(10);
            teamInfoBox.setStyle("-fx-border-color: black; -fx-padding: 10;");

            // Add the buttons to the team to edit or delete the team
            HBox teamButtons = new HBox();
            teamButtons.setSpacing(20);

            // Add the information of the team to the flowpane
            Label teamName = new Label("Name: " + team.getTeamName());
            Label teamColor = new Label("Color: " + team.getTeamColor());
            Label teamCountry = new Label("Country: " + team.getTeamCountry());
            Label teamYear = new Label("Year: " + team.getTeamYear().toString());
            Label teamMotor = new Label("Motor: " + team.getTeamMotor());
            Label teamDriver1 = new Label("Driver 1: " + team.getTeamDriver1());
            Label teamDriver2 = new Label("Driver 2: " + team.getTeamDriver2());
            Label teamManager = new Label("Manager: " + team.getTeamManager());

            // Add the icons to the buttons
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

            // If the user clicks on the edit icon, go to the edit popup
            editIcon.setOnMouseClicked(e -> {
                new EditPopup(new Stage(), team);
            });

            // If the user clicks on this, there will be an alert to ask if the user is sure to delete the team
            // If the user clicks on OK, the team will be deleted
            deleteIcon.setOnMouseClicked(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Are you sure?");
                alert.setHeaderText("Are you sure you want to delete this?");
                alert.setContentText("If you delete this you can't get it back");

                Optional<ButtonType> result = alert.showAndWait();

                // If the user clicks on OK, the team will be deleted
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

        // Add the flowpane to a scrollpane so the user can scroll through the teams
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

