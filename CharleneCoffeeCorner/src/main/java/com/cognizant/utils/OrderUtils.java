package com.cognizant.utils;

import com.cognizant.model.BaconRoll;
import com.cognizant.model.Client;
import com.cognizant.model.Coffee;
import com.cognizant.model.OrangeJuice;
import com.cognizant.model.Product;

import static java.math.BigDecimal.ZERO;

public final class OrderUtils {

    /**
     * Method to check if a client has a free drink
     *
     * @param client - The requester client
     * @return - The condition's result
     */
    public static boolean checkFreeDrink(Client client) {
        return client.getStampCard().getNumDrinks() == 5;
    }

    /**
     * Method to check if a client has a free extra
     *
     * @param client - The requester client
     * @return - The condition's result
     */
    public static boolean checkFreeExtra(Client client) {
        return orderContainsADrink(client) && orderContainsASnack(client) && orderContainsAExtra(client);
    }

    /**
     * Method to check if the client`s order has a snack
     *
     * @param client - The requester client
     * @return - The condition's result
     */
    public static boolean orderContainsASnack(Client client) {
        return client.getOrder().getProducts().stream().anyMatch(OrderUtils::isASnack);
    }

    /**
     * Method to check if the client`s order has a drink
     *
     * @param client - The requester client
     * @return - The condition's result
     */
    public static boolean orderContainsADrink(Client client) {
        return client.getOrder().getProducts().stream().anyMatch(OrderUtils::isACoffee)
                && client.getOrder().getProducts().stream().anyMatch(OrderUtils::isAOrangeJuice);
    }

    /**
     * Method to check if the client`s order has a extra
     *
     * @param client - The requester client
     * @return - The condition's result
     */
    public static boolean orderContainsAExtra(Client client) {
        return client.getOrder().getProducts().stream().anyMatch(OrderUtils::isACoffee)
                && client.getOrder().getProducts().stream().anyMatch(product -> !product.getExtra().equals(ZERO));
    }

    /**
     * Method to check if a product is a coffee
     *
     * @param product - The requester client
     * @return - The condition's result
     */
    public static boolean isACoffee(Product product) {
        return product instanceof Coffee;
    }

    /**
     * Method to check if a product is a orange juice
     *
     * @param product - The requester client
     * @return - The condition's result
     */
    public static boolean isAOrangeJuice(Product product) {
        return product instanceof OrangeJuice;
    }

    /**
     * Method to check if a product is a snack
     *
     * @param product - The requester client
     * @return - The condition's result
     */
    public static boolean isASnack(Product product) {
        return product instanceof BaconRoll;
    }
}
