package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public TeamController(Database db) {
        this.db = db;
        try {
            this.stm = db.getConn().createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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

    public void saveDriver(String txtDriver) throws Exception {
        try {
            ResultSet rs = this.stm.executeQuery("SELECT COUNT(*) AS count FROM coureur WHERE naam = '" + txtDriver + "'");
            if (rs.next() && rs.getInt("count") > 0) {
                throw new Exception("Driver already exists");
            }
            this.stm.execute("INSERT INTO coureur (naam) VALUES ('" + txtDriver + "')");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

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

    public void deleteTeam(int team_id) throws Exception {
        try {
            this.stm.execute("DELETE FROM team_coureur WHERE team_id = " + team_id);
            this.stm.execute("DELETE FROM teams WHERE team_id = " + team_id);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        try (ResultSet rs = stm.executeQuery("SELECT * FROM teams")) {
            while (rs.next()) {
                String teamYearString = rs.getString("team_jaar");
                LocalDate teamYear = LocalDate.parse(teamYearString);
                Team team = new Team(
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

    public void updateTeam(int team_id, String teamName, ComboBox<Kleur> teamColor, String teamCountry, DatePicker teamYear, ComboBox<MotorLeverancier> teamMotor, ComboBox<Drivers> teamDriver1, ComboBox<Drivers> teamDriver2, String teamManager) throws Exception {
        try {
            String color = teamColor.getValue().getName();
            String year = teamYear.getValue().toString();
            String motor = teamMotor.getValue().getName();
            String driver1 = teamDriver1.getValue().getName();
            String driver2 = teamDriver2.getValue().getName();

            this.stm.executeUpdate("UPDATE teams SET teamnaam = '" + teamName + "', kleur = '" + color + "', team_land = '" + teamCountry + "', team_jaar = '" + year + "', motor_leverancier = '" + motor + "', team_manager = '" + teamManager + "', coureur1 = '" + driver1 + "', coureur2 = '" + driver2 + "' WHERE team_id = " + team_id);        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Drivers getDriver(String teamDriver1) {
        return new Drivers(teamDriver1);
    }

    public MotorLeverancier getMotor(String teamMotor) {
        return new MotorLeverancier(teamMotor);
    }

    public Kleur getKleur(String teamColor) {
        return new Kleur(teamColor);
    }
}