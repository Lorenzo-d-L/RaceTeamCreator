package com.lorenzo.raceteamcreator_bp02.classes;

import java.sql.Date;

public class Drivers {
    private String name;

    // Constructor
    public Drivers(String name) {
        this.name = name;
    }

    // Get the name to display
    public String getName() {
        return name;
    }

    // Set the name so it can be displayed
    @Override
    public String toString() {
        return name;
    }

}
