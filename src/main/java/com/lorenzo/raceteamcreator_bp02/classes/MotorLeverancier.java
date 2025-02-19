package com.lorenzo.raceteamcreator_bp02.classes;

public class MotorLeverancier {
    private String motorLeverancier;

    // Constructor for the motor supplier
    public MotorLeverancier(String motorLeverancier) {
        this.motorLeverancier = motorLeverancier;
    }

    // Get the name of the motor supplier
    public String getName() {
        return motorLeverancier;
    }

    // Set the name of the motor supplier
    @Override
    public String toString() {
        return motorLeverancier;
    }
}