package com.lorenzo.raceteamcreator_bp02.classes;

import java.sql.Date;

public class Drivers {
    private String name;

    public Drivers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
