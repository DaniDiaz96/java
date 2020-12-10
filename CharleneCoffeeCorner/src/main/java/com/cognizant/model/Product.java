package com.cognizant.model;

import java.math.BigDecimal;

public abstract class Product {

    private final String name;
    private final BigDecimal amount;

    public Product(BigDecimal amount, String name) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public abstract BigDecimal getExtra();
}
