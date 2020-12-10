package com.cognizant.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private final List<Product> products;
    private BigDecimal totalPrize;
    private BigDecimal discount;
    private boolean expiredOffer;

    public Order(List<Product> products) {
        this.products = products;
        this.totalPrize = BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;
        this.expiredOffer = false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(BigDecimal totalPrize) {
        this.totalPrize = totalPrize;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public boolean isExpiredOffer() {
        return expiredOffer;
    }

    public void setExpiredOffer(boolean expiredOffer) {
        this.expiredOffer = expiredOffer;
    }
}
