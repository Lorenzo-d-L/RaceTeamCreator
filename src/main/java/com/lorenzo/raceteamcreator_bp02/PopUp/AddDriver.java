package com.lorenzo.raceteamcreator_bp02.PopUp;

import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.Drivers;
import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class AddDriver {
    private GridPane root;
    private Label lbName;
    private TextField txtDriver;
    private Button btnAdd;
    private Scene Scene;
    private TeamController tc;
    private Database db;
    private ComboBox<Drivers> cbDriver1;
    private ComboBox<Drivers> cbDriver2;

    public AddDriver(Stage AddDriverStage, ComboBox<Drivers> cbDriver1, ComboBox<Drivers> cbDriver2) {
        this.cbDriver1 = cbDriver1;
        this.cbDriver2 = cbDriver2;

        root = new GridPane();
        lbName = new Label("Driver Name");
        txtDriver = new TextField();
        btnAdd = new Button("Add Driver");

        Scene = new Scene(root, 300, 200);

        root.add(lbName, 0, 0);
        root.add(txtDriver, 1, 0);
        root.add(btnAdd, 1, 1);

        btnAdd.setOnAction(e -> {
            db = new Database();
            tc = new TeamController(db);
            try {
                tc.saveDriver(txtDriver.getText());
                cbDriver1.getItems().addAll(tc.getCoureurs());
                cbDriver2.getItems().addAll(tc.getCoureurs());
                AddDriverStage.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        AddDriverStage.setTitle("Add Driver");
        AddDriverStage.setResizable(false);
        AddDriverStage.setScene(Scene);
        AddDriverStage.show();
    }

}
