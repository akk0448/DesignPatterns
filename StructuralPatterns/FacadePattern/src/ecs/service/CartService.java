package ecs.service;

import ecs.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartService {

    private final Map<Product, Integer> cartItems = new HashMap<>();

    public void addToCart(Product product, int quantity) {
        cartItems.merge(product, quantity, Integer::sum);
    }

    public void viewCart() {
        System.out.println("\n--- Cart Items ---");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double cost = product.getPrice() * quantity;
            System.out.printf("%s x %d = ₹%.2f%n", product.getName(), quantity, cost);
            total += cost;
        }
        System.out.printf("Total Amount: ₹%.2f%n", total);
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}