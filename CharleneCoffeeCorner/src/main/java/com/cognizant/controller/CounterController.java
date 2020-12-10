package com.cognizant.controller;

import com.cognizant.model.Client;
import com.cognizant.service.OrderService;

import java.util.List;

import static com.cognizant.utils.ReceiptUtils.generateReceipt;

public class CounterController {

    private final OrderService orderService;

    public CounterController() {
        this.orderService = new OrderService();
    }

    /**
     * Method to handle clients orders
     *
     * @param clientList - List with all the clients
     */
    public void handleClients(List<Client> clientList) {
        clientList.forEach(orderService::processOrder);
        generateReceipt(clientList);
    }
}
