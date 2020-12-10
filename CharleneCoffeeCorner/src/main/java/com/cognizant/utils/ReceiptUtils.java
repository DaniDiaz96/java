package com.cognizant.utils;

import com.cognizant.model.Client;

import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;
import static java.math.BigDecimal.ZERO;

public final class ReceiptUtils {

    /**
     * Method to generate a client receipt
     *
     * @param clientList - List with all the clients
     */
    public static void generateReceipt(List<Client> clientList) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.println();
        clientList.forEach(client -> {
            printWriter.printf("Client: %s\n", client.getName());
            printProductLine(client, printWriter);
            printDiscountLine(printWriter, client);
            printWriter.printf("Total: %s CHF", client.getOrder().getTotalPrize().toPlainString());
            printWriter.println("\n");
        });
        printWriter.close();
    }

    private static void printProductLine(Client client, PrintWriter printWriter) {
        client.getOrder().getProducts().forEach(product ->
                printWriter.printf("Product: %s - %s CHF\n",
                        product.getName(), product.getAmount().add(product.getExtra()).toPlainString()));
    }

    private static void printDiscountLine(PrintWriter printWriter, Client client) {
        if (!client.getOrder().getDiscount().equals(ZERO)) {
            printWriter.printf("Discount: %s CHF\n", client.getOrder().getDiscount());
        } else {
            printWriter.printf("No discount applied\n");
        }
    }
}
