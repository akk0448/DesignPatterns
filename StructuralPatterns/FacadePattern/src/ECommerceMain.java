import ecs.facade.CheckoutFacade;
import ecs.service.CartService;
import ecs.service.InventoryService;
import ecs.service.PaymentService;

import java.util.Scanner;

public class ECommerceMain {

    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        CartService cart = new CartService();
        PaymentService payment = new PaymentService();
        CheckoutFacade checkout = new CheckoutFacade(inventory, cart, payment);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- E-Commerce Checkout System ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> inventory.listProducts();
                case 2 -> {
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    inventory.getProductById(id).ifPresentOrElse(product -> {
                        if (inventory.isAvailable(id, qty)) {
                            cart.addToCart(product, qty);
                            System.out.println("✅ Added to cart.");
                        } else {
                            System.out.println("❌ Not enough stock.");
                        }
                    }, () -> System.out.println("❌ Product not found."));
                }
                case 3 -> cart.viewCart();
                case 4 -> checkout.checkout();
                case 5 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid choice.");
            }

        } while (choice != 5);
    }
}