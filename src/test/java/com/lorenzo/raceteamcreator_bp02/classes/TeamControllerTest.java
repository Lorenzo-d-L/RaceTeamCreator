package com.lorenzo.raceteamcreator_bp02.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamControllerTest {
    Database db = new Database();
    TeamController tc = new TeamController(db);

    @Test
    void saveTeam() {
        tc.saveTeam();
    }

    @Test
    void saveDriver() {
    }

    @Test
    void getCoureurs() {
    }

    @Test
    void getMotorLeveranciers() {
    }

    @Test
    void getKleuren() {
    }

    @Test
    void deleteTeam() {
    }

    @Test
    void getTeams() {
    }

    @Test
    void updateTeam() {
    }

    @Test
    void getDriver() {
    }

    @Test
    void getMotor() {
    }

    @Test
    void getKleur() {
    }
}