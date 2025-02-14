package com.lorenzo.raceteamcreator_bp02.classes;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamControllerTest {
    Database db = new Database();
    TeamController tc = new TeamController(db);

    @Test
    void saveTeam() {
        try {
            tc.saveTeam("Test", "Red", "Netherlands", "2021-01-01", "Mercedes", "Lewis Hamilton", "Valtteri Bottas", "Toto Wolff");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void saveDriver() {
        try {
            ComboBox<Drivers> comboBox = new ComboBox<>();

            ObservableList<Drivers> lijst = tc.getCoureurs();
            comboBox.getItems().addAll(lijst);
            tc.saveDriver("Test", comboBox);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getMotorLeveranciers() {
        try {
            tc.getMotorLeveranciers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getKleuren() {
        try {
            tc.getKleuren();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteTeam() {
        try {
            tc.deleteTeam(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getTeams() {
        try {
            tc.getTeams();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateTeam() {

    }

    @Test
    void getDriver() {
        try {
            tc.getDriver("Lewis Hamilton");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getMotor() {
        tc.getMotor("Mercedes");
    }

    @Test
    void getKleur() {
        tc.getKleur("Red");
    }

}