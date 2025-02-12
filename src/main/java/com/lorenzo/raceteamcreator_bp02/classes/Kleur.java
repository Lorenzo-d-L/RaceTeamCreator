package com.lorenzo.raceteamcreator_bp02.classes;

public class Kleur {
    private String kleur;

    public Kleur(String kleur) {
        this.kleur = kleur;
    }

    public String getName() {
        return kleur;
    }

    @Override
    public String toString() {
        return kleur;
    }
}
