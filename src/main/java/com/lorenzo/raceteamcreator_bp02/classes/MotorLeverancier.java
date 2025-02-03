package com.lorenzo.raceteamcreator_bp02.classes;

public class MotorLeverancier {
    private String Mercedes;
    private String Ferrari;
    private String Renault;
    private String Honda;
    private String RedBullPowertrains;

    public MotorLeverancier(String Mercedes, String Ferrari, String Renault, String Honda, String RedBullPowertrains) {
        this.Mercedes = Mercedes;
        this.Ferrari = Ferrari;
        this.Renault = Renault;
        this.Honda = Honda;
        this.RedBullPowertrains = RedBullPowertrains;
    }

    public String getRedBullPowertrains() {
        return RedBullPowertrains;
    }

    public void setRedBullPowertrains(String redBullPowertrains) {
        RedBullPowertrains = redBullPowertrains;
    }

    public String getHonda() {
        return Honda;
    }

    public void setHonda(String honda) {
        Honda = honda;
    }

    public String getRenault() {
        return Renault;
    }

    public void setRenault(String renault) {
        Renault = renault;
    }

    public String getFerrari() {
        return Ferrari;
    }

    public void setFerrari(String ferrari) {
        Ferrari = ferrari;
    }

    public String getMercedes() {
        return Mercedes;
    }

    public void setMercedes(String mercedes) {
        Mercedes = mercedes;
    }
}
