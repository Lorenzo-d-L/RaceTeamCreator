package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.PopUp.AddDriver;

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
            this.stm.executeUpdate("INSERT INTO team (teamName, teamColor, teamCountry, teamYear, teamMotor, teamManager) VALUES ('" + teamName + "', '" + teamColor + "', '" + teamCountry + "', '" + teamYear + "', '" + teamMotor +  "', '" + teamManager + "')");
            ResultSet rs = stm.executeQuery("SELECT max(id) as teamid FROM teams");
            if(rs.next()) {
                int team_id = rs.getInt("id");
                this.stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES ("+ team_id + ", '"+ teamDriver1 + "') ");
                this.stm.execute("INSERT INTO team_coureur (team_id, coureur_id) VALUES ("+ team_id + ", '"+ teamDriver2 + "') ");
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

    public ArrayList<String> getCoureurs() throws Exception {
        try {
            ArrayList<String> coureurs = new ArrayList<>();
            ResultSet rs = this.stm.executeQuery("SELECT * FROM coureur");
            while (rs.next()) {
                coureurs.add(rs.getString("naam"));
            }
            return coureurs;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

//    public void loadTeam( int team_id) throws Exception {
//        try {
//            this.stm.executeQuery("SELECT * FROM teams WHERE team_id = " + team_id);
//        } catch (Exception e) {
//            throw new Exception("Error: " + e.getMessage());
//        }
//    }

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
