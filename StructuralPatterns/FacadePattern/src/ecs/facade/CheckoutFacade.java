package ecs.facade;

import ecs.model.Product;
import ecs.service.CartService;
import ecs.service.InventoryService;
import ecs.service.PaymentService;

import java.util.Map;

public class CheckoutFacade {

    private final InventoryService inventoryService;
    private final CartService cartService;
    private final PaymentService paymentService;

    public CheckoutFacade(InventoryService inventoryService, CartService cartService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.paymentService = paymentService;
    }

    public boolean checkout() {
        Map<Product, Integer> cartItems = cartService.getCartItems();

        double total = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (!inventoryService.isAvailable(product.getId(), quantity)) {
                System.out.printf("❌ Not enough stock for: %s\n", product.getName());
                return false;
            }
            total += product.getPrice() * quantity;
        }

        if (paymentService.processPayment(total)) {
            for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
                inventoryService.reduceStock(entry.getKey().getId(), entry.getValue());
            }
            System.out.println("✅ Payment successful! Order placed.");
            cartService.clearCart();
            return true;
        }

        System.out.println("❌ Payment failed. Please try again.");
        return false;
    }
}