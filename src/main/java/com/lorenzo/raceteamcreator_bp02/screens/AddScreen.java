package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;
import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.Drivers;
import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class AddScreen {
    private Pane container = new Pane();
    private GridPane grid = new GridPane();
    private Label title = new Label("Add Screen");
    private Label lbName = new Label("Team Name");
    private TextField txtName = new TextField();
    private Label lbColor = new Label("Team Color");
    private TextField txtColor = new TextField();
    private Label lbCountry = new Label("Country");
    private TextField txtCountry = new TextField();
    private Label lbYear = new Label("Year");
    private TextField txtYear = new TextField();
    private Label lbMotor = new Label("Motorleverancier");
    private TextField txtMotor = new TextField();
    private Label lbDriver = new Label("Driver1");
    private ComboBox<Drivers> cbDriver1;
    private Label lbDriver2 = new Label("Driver2");
    private ComboBox<Drivers> cbDriver2;
    private Label lbManager = new Label("Manager");
    private TextField txtManager = new TextField();
    private Button btnAdd = new Button("Team Toevoegen");
    private Button btnAddDriver;
    private VBox nav;
    private HBox home;
    private HBox createTeam;
    private HBox showAllTeams;
    private VBox icon;
    private Tooltip tp;
    private Database db;
    private TeamController tc;

    public AddScreen(Stage addStage) throws Exception {
        nav = new VBox();
        home = new HBox();
        createTeam = new HBox();
        showAllTeams = new HBox();
        icon = new VBox();
        cbDriver1 = new ComboBox<>();
        cbDriver2 = new ComboBox<Drivers>();
        db = new Database();
        tc = new TeamController(db);

        cbDriver1.getItems().addAll(tc.getCoureurs());
        cbDriver2.getItems().addAll(tc.getCoureurs());


        Scene scene = new Scene(container, 800, 600);


        btnAddDriver = new Button("+");
        tp = new Tooltip("Add a new driver");
        Tooltip.install(btnAddDriver, tp);

        nav.setPrefSize(100, 550);
        nav.setLayoutY(50);
        nav.setAlignment(javafx.geometry.Pos.CENTER);
        nav.setSpacing(50);

        icon.setPrefSize(100, 100);
        icon.setMaxSize(100, 100);

        home.setPrefSize(50,50);
        home.setMaxSize(50,50);

        createTeam.setPrefSize(50,50);
        createTeam.setMaxSize(50,50);

        showAllTeams.setPrefSize(50,50);
        showAllTeams.setMaxSize(50,50);

       grid.setPrefSize(400, 300);
       grid.setLayoutX(200);
       grid.setLayoutY(150);

        grid.add(lbName, 0, 0);
        grid.add(txtName, 0, 1);
        grid.add(lbColor, 0, 2);
        grid.add(txtColor, 0, 3);
        grid.add(lbCountry, 0, 4);
        grid.add(txtCountry, 0, 5);
        grid.add(lbYear, 0, 6);
        grid.add(txtYear, 0, 7);
        grid.add(lbMotor, 0, 8);
        grid.add(txtMotor, 0, 9);
        grid.add(lbManager, 0, 11);
        grid.add(txtManager, 0, 12);
        grid.add(lbDriver, 0, 13);
        grid.add(lbDriver2, 1, 13);
        grid.add(cbDriver1, 0, 14);
        grid.add(cbDriver2, 1, 14);
        grid.add(btnAddDriver, 2, 14);
        grid.add(btnAdd, 0, 15);

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

        home.setOnMouseClicked(e -> {
            new HomeScreen(addStage);
        });

        showAllTeams.setOnMouseClicked(e -> {
            new ShowTeamScreen(addStage);
        });

        btnAddDriver.setOnAction(e -> {
            new AddDriver(new Stage(), cbDriver1, cbDriver2);
        });

        btnAdd.setOnAction(e -> {
            try {
                tc.saveTeam(txtName.getText(), txtColor.getText(), txtCountry.getText(), txtYear.getText(), txtMotor.getText(), ((Drivers)cbDriver1.getValue()).getName(),  ((Drivers)cbDriver2.getValue()).getName(), txtManager.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        container.getChildren().addAll(grid, nav, icon);
        nav.getChildren().addAll(home, showAllTeams, createTeam);
        icon.getChildren().add(imageView);
        home.getChildren().add(homeButton);
        showAllTeams.getChildren().add(showAll);
        createTeam.getChildren().add(addTeam);

        addStage.setResizable(false);
        addStage.setTitle("Add Screen");
        addStage.setScene(scene);
        addStage.show();
    }

    public void connectToDatabase(String url) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
