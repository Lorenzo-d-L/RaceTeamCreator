package com.lorenzo.raceteamcreator_bp02.classes;

public class Kleur {
    private String kleur;

    // Constructor for the color
    public Kleur(String kleur) {
        this.kleur = kleur;
    }

    // Get the name of the color
    public String getName() {
        return kleur;
    }

    // Set the name of the color
    @Override
    public String toString() {
        return kleur;
    }

}
