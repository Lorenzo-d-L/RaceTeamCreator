package com.lorenzo.raceteamcreator_bp02.classes;

public class MotorLeverancier {
    private String motorLeverancier;

    public MotorLeverancier(String motorLeverancier) {
        this.motorLeverancier = motorLeverancier;
    }

    public String getName() {
        return motorLeverancier;
    }

    @Override
    public String toString() {
        return motorLeverancier;
    }
}
