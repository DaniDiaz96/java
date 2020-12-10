package com.cognizant.model;

public class Client {

    private final String name;
    private final Order order;
    private final StampCard stampCard;

    public Client(String name, Order order) {
        this.name = name;
        this.order = order;
        this.stampCard = new StampCard(0);
    }

    public String getName() {
        return name;
    }

    public Order getOrder() {
        return order;
    }

    public StampCard getStampCard() {
        return stampCard;
    }
}
