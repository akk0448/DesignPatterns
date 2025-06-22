package oms.order;

import oms.fulfillment.FulfillmentService;

public abstract class Order {

    protected String orderId;
    protected double amount;
    protected FulfillmentService fulfillmentService;

    public Order(String orderId, double amount, FulfillmentService fulfillmentService) {
        this.orderId = orderId;
        this.amount = amount;
        this.fulfillmentService = fulfillmentService;
    }

    public abstract void processOrder();
}