package com.cognizant;

import com.cognizant.controller.CounterController;
import com.cognizant.model.BaconRoll;
import com.cognizant.model.Client;
import com.cognizant.model.Coffee;
import com.cognizant.model.OrangeJuice;
import com.cognizant.model.Order;
import com.cognizant.model.Product;

import java.util.List;

import static com.cognizant.model.Extra.EXTRA_MILK;
import static com.cognizant.model.Extra.FOAMED_MILK;
import static com.cognizant.model.Extra.SPECIAL_ROAST;

public class CharleneCoffeeCornerApplication {

    public static void main(String[] args) {
        CounterController counterController = new CounterController();
        List<Client> clientList = initClientsOrders();
        counterController.handleClients(clientList);
    }

    private static List<Client> initClientsOrders() {
        List<List<Product>> clientOrderProducts = List.of(
                List.of(new Coffee("large", EXTRA_MILK),
                        new Coffee("small", SPECIAL_ROAST),
                        new OrangeJuice()),
                List.of(new Coffee("medium", FOAMED_MILK),
                        new BaconRoll(),
                        new OrangeJuice()),
                List.of(new Coffee("small"),
                        new OrangeJuice(),
                        new OrangeJuice(),
                        new Coffee("large"),
                        new Coffee("large")));
        return List.of(
                new Client("Daniel", new Order(clientOrderProducts.get(0))),
                new Client("Juan", new Order(clientOrderProducts.get(1))),
                new Client("Isabel", new Order(clientOrderProducts.get(2))));
    }
}
