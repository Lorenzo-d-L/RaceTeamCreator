package com.lorenzo.raceteamcreator_bp02.PopUp;

import com.lorenzo.raceteamcreator_bp02.classes.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditPopup {
    private Label lbTeamName;
    private TextField txfTeamname;
    private Label lbColor;
    private ComboBox<Kleur> cbColor;
    private Label lbCountry;
    private TextField txfCountry;
    private Label lbYear;
    private DatePicker dpYear;
    private Label lbMotor;
    private ComboBox<MotorLeverancier> cbMotor;
    private Label lbManager;
    private TextField txfManager;
    private Label lbDriver1;
    private ComboBox<Drivers> cbDriver1;
    private Label lbDriver2;
    private ComboBox<Drivers> cbDriver2;
    private Button addDriver;
    private Button editTeam;
    private Button cancel;
    private GridPane root;
    private Scene editScene;
    private TeamController tc;
    private Database db;

    public EditPopup(Stage editStage, Team team) {
        lbTeamName = new Label("Team Name");
        txfTeamname = new TextField(team.getTeamName());
        lbColor = new Label("Team Color");
        cbColor = new ComboBox<>();
        lbCountry = new Label("Country");
        txfCountry = new TextField(team.getTeamCountry());
        lbYear = new Label("Year");
        dpYear = new DatePicker(team.getTeamYear());
        lbMotor = new Label("Motor Supplier");
        cbMotor = new ComboBox<>();
        lbManager = new Label("Manager");
        txfManager = new TextField(team.getTeamManager());
        lbDriver1 = new Label("Driver 1");
        cbDriver1 = new ComboBox<>();
        lbDriver2 = new Label("Driver 2");
        cbDriver2 = new ComboBox<>();
        addDriver = new Button("+");
        editTeam = new Button("Edit Team");
        cancel = new Button("Cancel");
        root = new GridPane();
        db = new Database();
        tc = new TeamController(db);

        lbTeamName.setId("lbTeamName");
        txfTeamname.setId("txfTeamname");
        lbColor.setId("lbColor");
        cbColor.setId("cbColor");
        lbCountry.setId("lbCountry");
        txfCountry.setId("txfCountry");
        lbYear.setId("lbYear");
        dpYear.setId("dpYear");
        lbMotor.setId("lbMotor");
        cbMotor.setId("cbMotor");
        lbManager.setId("lbManager");
        txfManager.setId("txfManager");
        lbDriver1.setId("lbDriver1");
        cbDriver1.setId("cbDriver1");
        lbDriver2.setId("lbDriver2");
        cbDriver2.setId("cbDriver2");
        addDriver.setId("addDriver");
        editTeam.setId("editTeam");
        cancel.setId("cancel");
        root.setId("root");


        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/EditPopup.css").toExternalForm();
        editScene = new Scene(root, 400, 300);
        editScene.getStylesheets().add(css);

        try {
            cbDriver1.getItems().addAll(tc.getCoureurs());
            cbDriver2.getItems().addAll(tc.getCoureurs());
            cbMotor.getItems().addAll(tc.getMotorLeveranciers());
            cbColor.getItems().addAll(tc.getKleuren());

            cbDriver1.setValue(tc.getDriver(team.getTeamDriver1()));
            cbDriver2.setValue(tc.getDriver(team.getTeamDriver2()));
            cbMotor.setValue(tc.getMotor(team.getTeamMotor()));
            cbColor.setValue(tc.getKleur(team.getTeamColor()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        root.setHgap(5);
        root.setVgap(5);

        root.add(lbTeamName, 0, 0);
        root.add(txfTeamname, 1, 0);
        root.add(lbColor, 0, 1);
        root.add(cbColor, 1, 1);
        root.add(lbCountry, 0, 2);
        root.add(txfCountry, 1, 2);
        root.add(lbYear, 0, 3);
        root.add(dpYear, 1, 3);
        root.add(lbMotor, 0, 4);
        root.add(cbMotor, 1, 4);
        root.add(lbManager, 0, 5);
        root.add(txfManager, 1, 5);
        root.add(lbDriver1, 0, 6);
        root.add(lbDriver2, 1, 6);
        root.add(cbDriver1, 0, 7);
        root.add(cbDriver2, 1, 7);
        root.add(addDriver, 2, 7);
        root.add(editTeam, 0, 8);
        root.add(cancel, 1, 8);

        addDriver.setOnAction(e -> {
            new AddDriver(new Stage(), cbDriver1, cbDriver2);
        });

        editTeam.setOnAction(e -> {
            try {
                tc.updateTeam(team.getTeamId(),
                        txfTeamname.getText(),
                        cbColor,
                        txfCountry.getText(),
                        dpYear,
                        cbMotor,
                        cbDriver1,
                        cbDriver2,
                        txfManager.getText());
                System.out.println("Team updated successfully");
                editStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        });

        cancel.setOnAction(e -> {
            editStage.close();
        });


        editStage.setResizable(false);
        editStage.setTitle("Edit Team");
        editStage.setScene(editScene);
        editStage.show();
    }

}
