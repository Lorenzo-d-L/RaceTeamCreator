package com.lorenzo.raceteamcreator_bp02.PopUp;

import com.lorenzo.raceteamcreator_bp02.classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditPopup {
    private Label lbTeamname;
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
    private GridPane gp;
    private Scene editScene;
    private TeamController tc;
    private Database db;

    public EditPopup(Stage editStage, Team team) {
        lbTeamname = new Label("Team Name");
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
        gp = new GridPane();
        db = new Database();
        tc = new TeamController(db);

        lbTeamname.setId("lbTeamname");
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
        gp.setId("gp");


        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/addDriver.css").toExternalForm();
        editScene = new Scene(gp, 400, 300);
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

        gp.setHgap(5);
        gp.setVgap(5);

        gp.add(lbTeamname, 0, 0);
        gp.add(txfTeamname, 1, 0);
        gp.add(lbColor, 0, 1);
        gp.add(cbColor, 1, 1);
        gp.add(lbCountry, 0, 2);
        gp.add(txfCountry, 1, 2);
        gp.add(lbYear, 0, 3);
        gp.add(dpYear, 1, 3);
        gp.add(lbMotor, 0, 4);
        gp.add(cbMotor, 1, 4);
        gp.add(lbManager, 0, 5);
        gp.add(txfManager, 1, 5);
        gp.add(lbDriver1, 0, 6);
        gp.add(lbDriver2, 1, 6);
        gp.add(cbDriver1, 0, 7);
        gp.add(cbDriver2, 1, 7);
        gp.add(addDriver, 2, 7);
        gp.add(editTeam, 0, 8);
        gp.add(cancel, 1, 8);

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
