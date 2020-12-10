package com.cognizant;

import com.cognizant.model.BaconRoll;
import com.cognizant.model.Client;
import com.cognizant.model.Coffee;
import com.cognizant.model.OrangeJuice;
import com.cognizant.model.Order;
import com.cognizant.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.cognizant.model.Extra.FOAMED_MILK;
import static com.cognizant.model.Extra.SPECIAL_ROAST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    private static OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void processOrder_withNoExtras() {
        Client client = new Client("c1",
                new Order(List.of(new Coffee("small"), new OrangeJuice(), new OrangeJuice())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("10.40"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withOneExtra() {
        Client client = new Client("c1",
                new Order(List.of(new Coffee("medium", FOAMED_MILK), new OrangeJuice(), new OrangeJuice())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("11.40"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withMoreThanOneExtra() {
        Client client = new Client("c1", new Order(List.of(new Coffee("medium", FOAMED_MILK),
                new Coffee("medium", SPECIAL_ROAST),
                new OrangeJuice())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("11.35"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withFreeExtra() {
        Client client = new Client("c1",
                new Order(List.of(new Coffee("medium", FOAMED_MILK), new BaconRoll(), new OrangeJuice())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("11.45"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withFreeDrink() {
        Client client = new Client("c1", new Order(List.of(new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"))));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("13.90"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withFreeExtraAndMoreThanOneExtra() {
        Client client = new Client("c1", new Order(List.of(new Coffee("medium", FOAMED_MILK),
                new Coffee("medium", SPECIAL_ROAST),
                new BaconRoll(),
                new OrangeJuice())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("15.35"), client.getOrder().getTotalPrize());
    }


    @Test
    void processOrder_withFreeDrinkAndMoreThanFiveDrinks() {
        Client client = new Client("c1", new Order(List.of(new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"),
                new Coffee("large", FOAMED_MILK))));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("17.90"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withFreeDrinkAndFreeExtra() {
        Client client = new Client("c1", new Order(List.of(new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"),
                new Coffee("large", FOAMED_MILK),
                new BaconRoll())));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("21.90"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withFreeDrinkAndFreeExtraAndMoreDrinks() {
        Client client = new Client("c1", new Order(List.of(new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"),
                new Coffee("large", FOAMED_MILK),
                new BaconRoll(),
                new OrangeJuice(),
                new Coffee("large", SPECIAL_ROAST))));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("30.25"), client.getOrder().getTotalPrize());
    }

    @Test
    void processOrder_withTwiceFreeDrinks() {
        Client client = new Client("c1", new Order(List.of(new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"),
                new Coffee("large", FOAMED_MILK),
                new Coffee("small"),
                new OrangeJuice(),
                new OrangeJuice(),
                new Coffee("large"),
                new Coffee("large"),
                new Coffee("large", FOAMED_MILK))));

        orderService.processOrder(client);

        assertEquals(new BigDecimal("35.80"), client.getOrder().getTotalPrize());
    }
}