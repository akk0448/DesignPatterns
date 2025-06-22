package oms.order;

import oms.fulfillment.FulfillmentService;

public class InStoreOrder extends Order {

    public InStoreOrder(String orderId, double amount, FulfillmentService fulfillmentService) {
        super(orderId, amount, fulfillmentService);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing in-store order...");
        fulfillmentService.fulfill(orderId);
    }
}
