package com.lorenzo.raceteamcreator_bp02.PopUp;

import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.Drivers;
import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
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

    // Add a driver to the database
    public AddDriver(Stage AddDriverStage, ComboBox<Drivers> cbDriver1, ComboBox<Drivers> cbDriver2) {
        this.cbDriver1 = cbDriver1;
        this.cbDriver2 = cbDriver2;

        // Create the layout
        root = new GridPane();
        lbName = new Label("Driver Name");
        txtDriver = new TextField();
        btnAdd = new Button("Add Driver");

        root.setId("root");
        lbName.setId("lbName");
        txtDriver.setId("txtDriver");
        btnAdd.setId("btnAdd");

        // Add the css file
        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/AddDriver.css").toExternalForm();
        Scene = new Scene(root, 300, 100);
        Scene.getStylesheets().add(css);

        root.setHgap(10);
        root.setVgap(5);

        root.add(lbName, 0, 0);
        root.add(txtDriver, 1, 0);
        root.add(btnAdd, 1, 1);

        // This will add the driver to the database and close the window
        btnAdd.setOnAction(e -> {
            db = new Database();
            tc = new TeamController(db);
            // Save the driver to the database
            try {
                tc.saveDriver(txtDriver.getText(), cbDriver1);
                cbDriver1.getItems().clear();
                cbDriver1.getItems().addAll(tc.getCoureurs());
                cbDriver2.getItems().clear();
                cbDriver2.getItems().addAll(tc.getCoureurs());
                AddDriverStage.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        // Set the stage
        AddDriverStage.setTitle("Add Driver");
        AddDriverStage.setResizable(false);
        AddDriverStage.setScene(Scene);
        AddDriverStage.show();
    }

}
