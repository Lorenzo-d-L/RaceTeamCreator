package com.lorenzo.raceteamcreator_bp02.screens;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private TextField txtDriver1 = new TextField();
    private Label lbDriver2 = new Label("Driver2");
    private TextField txtDriver2 = new TextField();
    private Label lbManager = new Label("Manager");
    private TextField txtManager = new TextField();

    public AddScreen(Stage addStage) {
        Scene scene = new Scene(container, 800, 600);

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
        grid.add(lbDriver, 0, 10);
        grid.add(lbDriver2, 1, 10);
        grid.add(txtDriver1, 0, 11);
        grid.add(txtDriver2, 1, 11);



        container.getChildren().add(grid);

        addStage.setResizable(false);
        addStage.setTitle("Add Screen");
        addStage.setScene(scene);
        addStage.show();
    }


}
