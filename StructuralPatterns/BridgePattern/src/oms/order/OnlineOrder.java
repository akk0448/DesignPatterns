package oms.order;

import oms.fulfillment.FulfillmentService;

public class OnlineOrder extends Order {

    public OnlineOrder(String orderId, double amount, FulfillmentService fulfillmentService) {
        super(orderId, amount, fulfillmentService);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing online order...");
        fulfillmentService.fulfill(orderId);
    }
}
