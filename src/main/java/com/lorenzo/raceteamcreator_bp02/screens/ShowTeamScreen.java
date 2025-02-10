package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.classes.TeamController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class ShowTeamScreen {
    TeamController tc = new TeamController();

    public ShowTeamScreen(Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);

        try{
            ResultSet rs = tc.loadTeams(1);
            if (rs.next()){
                Label teamName = new Label("Team Name: " + rs.getString("teamName"));
                Label teamColor = new javafx.scene.control.Label("Team Color: " + rs.getString("teamColor"));
                Label teamCountry = new javafx.scene.control.Label("Team Country: " + rs.getString("teamCountry"));
                Label teamYear = new javafx.scene.control.Label("Team Year: " + rs.getString("teamYear"));
                Label teamMotor = new javafx.scene.control.Label("Team Motor: " + rs.getString("teamMotor"));
                Label teamDriver1 = new javafx.scene.control.Label("Team Driver 1: " + rs.getString("teamDriver1"));
                Label teamDriver2 = new javafx.scene.control.Label("Team Driver 2: " + rs.getString("teamDriver2"));
                Label teamManager = new javafx.scene.control.Label("Team Manager: " + rs.getString("teamManager"));

                root.getChildren().addAll(teamName, teamColor, teamCountry, teamYear, teamMotor, teamDriver1, teamDriver2, teamManager);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        stage.setScene(scene);
        stage.show();

        }


    }
}
