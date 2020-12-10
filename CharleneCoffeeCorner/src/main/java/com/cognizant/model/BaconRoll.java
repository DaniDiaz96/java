package com.cognizant.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class BaconRoll extends Product {

    public BaconRoll() {
        super(new BigDecimal("4.50"), "Bacon roll");
    }

    @Override
    public BigDecimal getExtra() {
        return ZERO;
    }
}
