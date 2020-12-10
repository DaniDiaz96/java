package com.cognizant.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Coffee extends Product {

    private Extra extra;

    public Coffee(String size) {
        super(calculateAmountBySize(size), "Coffee " + size);
    }

    public Coffee(String size, Extra extra) {
        super(calculateAmountBySize(size), "Coffee " + size + " with " + extra.getName());
        this.extra = extra;
    }

    public BigDecimal getExtra() {
        if (extra != null) {
            switch (extra.getName()) {
                case "extra milk":
                    return new BigDecimal("0.30");
                case "foamed milk":
                    return new BigDecimal("0.50");
                case "special roast":
                    return new BigDecimal("0.90");
            }
        }
        return ZERO;
    }

    private static BigDecimal calculateAmountBySize(String size) {
        switch (size) {
            case "large":
                return new BigDecimal("3.50");
            case "medium":
                return new BigDecimal("3.00");
            case "small":
                return new BigDecimal("2.50");
        }
        return ZERO;
    }
}
