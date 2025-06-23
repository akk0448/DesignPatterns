package ecs.service;

public class ShippingService {

    public void shipOrder(String address) {
        System.out.println("🚚 Shipping to: " + address);
        System.out.println("📦 Order Dispatched Successfully.");
    }
}