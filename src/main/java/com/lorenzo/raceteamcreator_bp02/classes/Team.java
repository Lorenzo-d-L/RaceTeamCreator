package com.lorenzo.raceteamcreator_bp02.classes;

import java.time.LocalDate;

public class Team {
    private int teamId;
    private String teamName;
    private String teamColor;
    private String teamCountry;
    private LocalDate teamYear;
    private String teamMotor;
    private String teamDriver1;
    private String teamDriver2;
    private String teamManager;

    // Constructor for the team
    public Team(int teamId, String teamName, String teamColor, String teamCountry, LocalDate teamYear, String teamMotor, String teamDriver1, String teamDriver2, String teamManager) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.teamCountry = teamCountry;
        this.teamYear = teamYear;
        this.teamMotor = teamMotor;
        this.teamDriver1 = teamDriver1;
        this.teamDriver2 = teamDriver2;
        this.teamManager = teamManager;
    }

    // Below are the getters for the team
    public String getTeamName() {
        return teamName;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public LocalDate getTeamYear() {
        return teamYear;
    }

    public String getTeamMotor() {
        return teamMotor;
    }

    public String getTeamDriver1() {
        return teamDriver1;
    }

    public String getTeamDriver2() {
        return teamDriver2;
    }

    public String getTeamManager() {
        return teamManager;
    }

    public int getTeamId() {
        return teamId;
    }
}
