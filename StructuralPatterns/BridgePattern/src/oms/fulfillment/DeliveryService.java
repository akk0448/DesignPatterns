package oms.fulfillment;

public class DeliveryService implements FulfillmentService {

    @Override
    public void fulfill(String orderId) {
        System.out.println("Delivery scheduled for Order ID: " + orderId);
    }
}