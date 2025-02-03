package com.lorenzo.raceteamcreator_bp02.classes;

public class MotorSport {
    private String F1;
    private String DTM;

    public MotorSport(String F1, String DTM) {
        this.F1 = F1;
        this.DTM = DTM;
    }

    public String getF1() {
        return F1;
    }

    public void setF1(String f1) {
        F1 = f1;
    }

    public String getDTM() {
        return DTM;
    }

    public void setDTM(String DTM) {
        this.DTM = DTM;
    }
}
