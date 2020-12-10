package com.cognizant.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class OrangeJuice extends Product {

    public OrangeJuice() {
        super(new BigDecimal("3.95"), "Orange juice");
    }

    @Override
    public BigDecimal getExtra() {
        return ZERO;
    }
}
