package com.cognizant.model;

public enum Extra {

    EXTRA_MILK("extra milk"),
    FOAMED_MILK("foamed milk"),
    SPECIAL_ROAST("special roast");

    private final String name;

    Extra(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
