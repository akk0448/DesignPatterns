package oms.fulfillment;

public class PickupService implements FulfillmentService {

    @Override
    public void fulfill(String orderId) {
        System.out.println("Pickup ready for Order ID: " + orderId);
    }
}
