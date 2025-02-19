package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeamController {
    private Database db;
    private Statement stm;

    // Constructor for the team controller
    public TeamController(Database db) {
        this.db = db;
        try {
            this.stm = db.getConn().createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Save the team to the database with the given values from the textfields and comboboxes
    // Also save the drivers to the team
    // If the team already exists, throw an exception
    // If the team is saved, show an alert
    // The class team is used to get the values from the textfields and comboboxes
    public void saveTeam(String teamName, String teamColor, String teamCountry, String teamYear, String teamMotor, String teamDriver1, String teamDriver2, String teamManager) throws Exception {
        try {
            this.stm.executeUpdate("INSERT INTO teams (teamnaam, kleur, team_land, team_jaar, motor_leverancier, team_manager, coureur1, coureur2) VALUES ('" + teamName + "', '" + teamColor + "', '" + teamCountry + "', '" + teamYear + "', '" + teamMotor + "', '" + teamManager + "', '" + teamDriver1 + "', '" + teamDriver2 + "')");
            ResultSet rs = stm.executeQuery("SELECT max(team_id) as team_id FROM teams");
            if (rs.next()) {
                int team_id = rs.getInt("team_id");

                ResultSet rsDriver1 = stm.executeQuery("SELECT coureur_id FROM coureur WHERE naam = '" + teamDriver1 + "'");
                if (rsDriver1.next()) {
                    int coureur1_id = rsDriver1.getInt("coureur_id");
                    stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES (" + team_id + ", " + coureur1_id + ")");
                }

                ResultSet rsDriver2 = stm.executeQuery("SELECT coureur_id FROM coureur WHERE naam = '" + teamDriver2 + "'");
                if (rsDriver2.next()) {
                    int coureur2_id = rsDriver2.getInt("coureur_id");
                    stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES (" + team_id + ", " + coureur2_id + ")");
                }
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // Save the driver to the database with the given value from the textfield and combobox
    // If the driver already exists, throw an exception
    // If the driver is saved, update the combobox
    // The class drivers will be used to get the value from the textfield
    public void saveDriver(String txtDriver, ComboBox<Drivers> comboBox) throws Exception {
        try {
            ResultSet rs = this.stm.executeQuery("SELECT COUNT(*) AS count FROM coureur WHERE naam = '" + txtDriver + "'");
            if (rs.next() && rs.getInt("count") > 0) {
                throw new Exception("Driver already exists");
            }
            this.stm.execute("INSERT INTO coureur (naam) VALUES ('" + txtDriver + "')");
            updateDrivers(comboBox);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding driver");
            alert.setContentText("Driver already exists");
            alert.showAndWait();
        }
    }

    // Update the combobox with the drivers from the database
    // If the drivers are not found, throw an exception
    // If the drivers are found, update the combobox
    // The class drivers will be used to get the values from the database
    // The class observablelist will be used to update the combobox
    private void updateDrivers(ComboBox<Drivers> comboBox) {
        try {
            comboBox.getItems().clear();
            comboBox.getItems().addAll(getCoureurs());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Get the drivers from the database
    // If the drivers are not found, throw an exception
    // If the drivers are found, return the drivers
    // The class drivers will be used to get the values from the database
    public ObservableList<Drivers> getCoureurs() throws Exception {
        try {
            ObservableList<Drivers> coureurs = FXCollections.observableArrayList();
            ResultSet rs = this.stm.executeQuery("SELECT * FROM coureur");
            while (rs.next()) {
                Drivers d = new Drivers(rs.getString("naam"));
                coureurs.add(d);
            }
            return coureurs;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // Get the motor leveranciers from the database
    // If the motor leveranciers are not found, throw an exception
    // If the motor leveranciers are found, return the motor leveranciers
    // The class motor leverancier will be used to get the values from the database
    public ObservableList<MotorLeverancier> getMotorLeveranciers() throws Exception {
        try {
            ObservableList<MotorLeverancier> motorLeveranciers = FXCollections.observableArrayList();
            ResultSet rs = this.stm.executeQuery("SELECT * FROM leverancier");
            while (rs.next()) {
                MotorLeverancier ml = new MotorLeverancier(rs.getString("leverancier_naam"));
                motorLeveranciers.add(ml);
            }
            return motorLeveranciers;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // Get the kleuren from the database
    // If the kleuren are not found, throw an exception
    // If the kleuren are found, return the kleuren
    // The class kleur will be used to get the values from the database
    public ObservableList<Kleur> getKleuren() throws Exception {
        try {
            ObservableList<Kleur> kleuren = FXCollections.observableArrayList();
            ResultSet rs = this.stm.executeQuery("SELECT * FROM kleur");
            while (rs.next()) {
                Kleur k = new Kleur(rs.getString("kleur"));
                kleuren.add(k);
            }
            return kleuren;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // Delete the team from the database with the given team id
    public void deleteTeam(int getTeamId) throws Exception {
        try {
            this.stm.execute("DELETE FROM team_coureur WHERE team_id = " + getTeamId);
            this.stm.execute("DELETE FROM teams WHERE teams.team_id = " + getTeamId);
            System.out.println("Team deleted");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // Get the teams from the database
    // If the teams are not found, throw an exception
    // The class team is used to get the values from the database
    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        try (ResultSet rs = stm.executeQuery("SELECT * FROM teams")) {
            while (rs.next()) {
                String teamYearString = rs.getString("team_jaar");
                LocalDate teamYear = LocalDate.parse(teamYearString);
                Team team = new Team(
                        rs.getInt("team_id"),
                        rs.getString("teamnaam"),
                        rs.getString("kleur"),
                        rs.getString("team_land"),
                        teamYear,
                        rs.getString("motor_leverancier"),
                        rs.getString("coureur1"),
                        rs.getString("coureur2"),
                        rs.getString("team_manager")
                );
                teams.add(team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams;
    }

    // Update the team with the given values from the textfields and comboboxes
    // If the team is not found, throw an exception
    // If the team is found, update the team
    public void updateTeam(int team_id, String teamName, ComboBox<Kleur> teamColor, String teamCountry, DatePicker teamYear, ComboBox<MotorLeverancier> teamMotor, ComboBox<Drivers> teamDriver1, ComboBox<Drivers> teamDriver2, String teamManager) throws Exception {
        try {
            int teamd = team_id;
            String color = teamColor.getValue().getName();
            String year = teamYear.getValue().toString();
            String motor = teamMotor.getValue().getName();
            String driver1 = teamDriver1.getValue().getName();
            String driver2 = teamDriver2.getValue().getName();

            this.stm.executeUpdate("UPDATE teams SET teamnaam = '" + teamName + "', kleur = '" + color + "', team_land = '" + teamCountry + "', team_jaar = '" + year + "', motor_leverancier = '" + motor + "', team_manager = '" + teamManager + "', coureur1 = '" + driver1 + "', coureur2 = '" + driver2 + "' WHERE team_id = " + teamd);
            } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    // This method is used to get the values from the comboboxes and textfields
    public Drivers getDriver(String teamDriver1) {
        return new Drivers(teamDriver1);
    }

    // This method is used to get the values from the comboboxes and textfields
    public MotorLeverancier getMotor(String teamMotor) {
        return new MotorLeverancier(teamMotor);
    }

    // This method is used to get the values from the comboboxes and textfields
    public Kleur getKleur(String teamColor) {
        return new Kleur(teamColor);
    }
}