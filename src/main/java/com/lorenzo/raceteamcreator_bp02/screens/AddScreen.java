package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;
import com.lorenzo.raceteamcreator_bp02.classes.*;
import javafx.geometry.Pos;
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

public class AddScreen {
    private Pane root;
    private GridPane grid;
    private Label title;
    private Label lbName;
    private TextField txtName ;
    private Label lbColor;
    private ComboBox<Kleur> cbColor;
    private Label lbCountry;
    private TextField txtCountry;
    private Label lbYear;
    private DatePicker dpYear;
    private Label lbMotor;
    private ComboBox<MotorLeverancier> cbMotor;
    private Label lbDriver;
    private ComboBox<Drivers> cbDriver1;
    private Label lbDriver2;
    private ComboBox<Drivers> cbDriver2;
    private Label lbManager;
    private TextField txtManager;
    private Button btnAdd;
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
        root = new Pane();
        grid = new GridPane();
        title = new Label("Add a new team");
        lbName = new Label("Name:");
        txtName = new TextField();
        lbColor = new Label("Color:");
        cbColor = new ComboBox<Kleur>();
        lbCountry = new Label("Country:");
        txtCountry = new TextField();
        lbYear = new Label("Year:");
        dpYear = new DatePicker();
        lbMotor = new Label("Motor:");
        cbMotor = new ComboBox<MotorLeverancier>();
        lbDriver = new Label("Driver 1:");
        cbDriver1 = new ComboBox<Drivers>();
        lbDriver2 = new Label("Driver 2:");
        cbDriver2 = new ComboBox<Drivers>();
        lbManager = new Label("Manager:");
        txtManager = new TextField();
        btnAdd = new Button("Add");
        nav = new VBox();
        home = new HBox();
        createTeam = new HBox();
        showAllTeams = new HBox();
        icon = new VBox();
        db = new Database();
        tc = new TeamController(db);

        root.setId("root");
        grid.setId("grid");
        title.setId("title");
        dpYear.setId("dpYear");
        lbName.setId("lbName");
        txtName.setId("txtName");
        lbColor.setId("lbColor");
        cbColor.setId("cbColor");
        lbCountry.setId("lbCountry");
        txtCountry.setId("txtCountry");
        lbYear.setId("lbYear");
        lbMotor.setId("lbMotor");
        cbMotor.setId("cbMotor");
        lbDriver.setId("lbDriver");
        cbDriver1.setId("cbDriver1");
        lbDriver2.setId("lbDriver2");
        cbDriver2.setId("cbDriver2");
        lbManager.setId("lbManager");
        txtManager.setId("txtManager");
        btnAdd.setId("btnAdd");
        nav.setId("nav");
        home.setId("home");
        createTeam.setId("createTeam");
        showAllTeams.setId("showAllTeams");
        icon.setId("icon");

        cbDriver1.getItems().addAll(tc.getCoureurs());
        cbDriver2.getItems().addAll(tc.getCoureurs());
        cbMotor.getItems().addAll(tc.getMotorLeveranciers());
        cbColor.getItems().addAll(tc.getKleuren());

        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/AddScreen.css").toExternalForm();
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(css);


        btnAddDriver = new Button("+");
        tp = new Tooltip("Add a new driver");
        Tooltip.install(btnAddDriver, tp);

        nav.setPrefSize(100, 550);
        nav.setLayoutY(50);
        nav.setAlignment(Pos.CENTER);
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
       grid.setLayoutX(250);
       grid.setLayoutY(75);
       grid.setVgap(5);

        grid.add(lbName, 0, 0);
        grid.add(txtName, 0, 1);
        grid.add(lbColor, 0, 2);
        grid.add(cbColor, 0, 3);
        grid.add(lbCountry, 0, 4);
        grid.add(txtCountry, 0, 5);
        grid.add(lbYear, 0, 6);
        grid.add(dpYear, 0, 7);
        grid.add(lbMotor, 0, 8);
        grid.add(cbMotor, 0, 9);
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
                tc.saveTeam(txtName.getText(),
                            ((Kleur)cbColor.getValue()).getName(),
                            txtCountry.getText(),
                            dpYear.getValue().toString(),
                            ((MotorLeverancier)cbMotor.getValue()).getName(),
                            ((Drivers)cbDriver1.getValue()).getName(),
                            ((Drivers)cbDriver2.getValue()).getName(),
                            txtManager.getText());

                new HomeScreen(addStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().addAll(grid, nav, icon);
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

//    public void setId( ){
//        root.setId("root");
//        grid.setId("grid");
//        title.setId("title");
//        dpYear.setId("dpYear");
//        lbName.setId("lbName");
//        txtName.setId("txtName");
//        lbColor.setId("lbColor");
//        cbColor.setId("cbColor");
//        lbCountry.setId("lbCountry");
//        txtCountry.setId("txtCountry");
//        lbYear.setId("lbYear");
//        lbMotor.setId("lbMotor");
//        cbMotor.setId("cbMotor");
//        lbDriver.setId("lbDriver");
//        cbDriver1.setId("cbDriver1");
//        lbDriver2.setId("lbDriver2");
//        cbDriver2.setId("cbDriver2");
//        lbManager.setId("lbManager");
//        txtManager.setId("txtManager");
//        btnAdd.setId("btnAdd");
//        btnAddDriver.setId("btnAddDriver");
//        nav.setId("nav");
//        home.setId("home");
//        createTeam.setId("createTeam");
//        showAllTeams.setId("showAllTeams");
//        icon.setId("icon");
//    }

}


