package com.cognizant.service;

import com.cognizant.model.Client;
import com.cognizant.model.Product;

import java.math.BigDecimal;

import static com.cognizant.utils.OrderUtils.checkFreeDrink;
import static com.cognizant.utils.OrderUtils.checkFreeExtra;
import static com.cognizant.utils.OrderUtils.isACoffee;
import static com.cognizant.utils.OrderUtils.isAOrangeJuice;
import static java.math.BigDecimal.ZERO;

public class OrderService {

    public OrderService() {
    }

    /**
     * Method to process a client order
     *
     * @param client - The requester client
     */
    public void processOrder(Client client) {
        client.getOrder().getProducts().forEach(product -> {
            markStampCard(client, product);
            updateClientOrderPrize(client, product);
            checkFreeOffer(client, product);
        });
    }

    private void markStampCard(Client client, Product product) {
        if (isACoffee(product) || isAOrangeJuice(product)) {
            client.getStampCard().setNumDrinks(client.getStampCard().getNumDrinks() + 1);
        }
    }

    private void updateClientOrderPrize(Client client, Product product) {
        client.getOrder().setTotalPrize(client.getOrder().getTotalPrize().add(getProductPrize(product)));
    }

    private BigDecimal getProductPrize(Product product) {
        if (isACoffee(product) && !product.getExtra().equals(ZERO)) {
            return product.getAmount().add(product.getExtra());
        } else {
            return product.getAmount();
        }
    }

    private void checkFreeOffer(Client client, Product product) {
        if (checkFreeDrink(client)) {
            applyFreeDrinkDiscount(client, product);
        }
        if (checkFreeExtra(client) && !product.getExtra().equals(ZERO) && !client.getOrder().isExpiredOffer()) {
            applyFreeExtraDiscount(client, product);
        }
    }

    private void applyFreeDrinkDiscount(Client client, Product product) {
        client.getOrder().setTotalPrize(client.getOrder().getTotalPrize().subtract(product.getAmount()));
        client.getOrder().setDiscount(product.getAmount());
        client.getStampCard().setNumDrinks(0);
    }

    private void applyFreeExtraDiscount(Client client, Product product) {
        client.getOrder().setTotalPrize(client.getOrder().getTotalPrize().subtract(product.getExtra()));
        client.getOrder().setDiscount(product.getExtra());
        client.getOrder().setExpiredOffer(true);
    }
}
 