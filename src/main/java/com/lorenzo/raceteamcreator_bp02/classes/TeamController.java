package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            this.stm.executeUpdate("INSERT INTO teams (teamnaam, kleur, team_land, team_jaar, motor_leverancier, team_manager, coureur1, coureur2) VALUES ('" + teamName + "', '" + teamColor + "', '" + teamCountry + "', '" + teamYear + "', '" + teamMotor +  "', '" + teamManager + "', '" + teamDriver1 + "', '" + teamDriver2 + "')");
            ResultSet rs = stm.executeQuery("SELECT max(team_id) as team_id FROM teams");
            if(rs.next()) {
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
//                this.stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES ("+ team_id + ", '"+ teamDriver1 + "') ");
//                this.stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES ("+ team_id + ", '"+ teamDriver2 + "') ");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public ResultSet loadTeams(int team_id) throws Exception{
        try {
            return this.stm.executeQuery("SELECT * FROM teams WHERE team_id = " + team_id);
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

    public void showTeams() throws Exception {
        try {
            ResultSet rs = this.stm.executeQuery("SELECT * FROM teams");
            while (rs.next()) {
                System.out.println("Team ID: " + rs.getInt("team_id"));
                System.out.println("Team Name: " + rs.getString("teamName"));
                System.out.println("Team Color: " + rs.getString("teamColor"));
                System.out.println("Team Country: " + rs.getString("teamCountry"));
                System.out.println("Team Year: " + rs.getString("teamYear"));
                System.out.println("Team Motor: " + rs.getString("teamMotor"));
                System.out.println("Team Driver 1: " + rs.getString("teamDriver1"));
                System.out.println("Team Driver 2: " + rs.getString("teamDriver2"));
                System.out.println("Team Manager: " + rs.getString("teamManager"));
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public void deleteTeam(int team_id) throws Exception {
        try {
            this.stm.executeUpdate("DELETE FROM team WHERE team_id = " + team_id);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public void updateTeam( int team_id, String teamName, String teamColor, String teamCountry, String teamYear, String teamMotor, String teamDriver1, String teamDriver2, String teamManager) throws Exception {
        try {
            this.stm.executeUpdate("UPDATE team SET teamName = '" + teamName + "', teamColor = '" + teamColor + "', teamCountry = '" + teamCountry + "', teamYear = '" + teamYear + "', teamMotor = '" + teamMotor + "', teamDriver1 = '" + teamDriver1 + "', teamDriver2 = '" + teamDriver2 + "', teamManager = '" + teamManager + "' WHERE team_id = " + team_id);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


}
