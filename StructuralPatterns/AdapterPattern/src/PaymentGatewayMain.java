import pgs.adapter.PayPalAdapter;
import pgs.adapter.RazorpayAdapter;
import pgs.adapter.StripeAdapter;
import pgs.processor.PaymentProcessor;
import pgs.service.PaymentService;

import java.util.Scanner;

public class PaymentGatewayMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Welcome to Console Payment Gateway System ====");

        while (true) {
            System.out.println("\nChoose a Payment Gateway:");
            System.out.println("1. PayPal");
            System.out.println("2. Stripe");
            System.out.println("3. Razorpay");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            System.out.print("Enter amount to pay (₹): ");
            double amount = scanner.nextDouble();

            PaymentProcessor processor = switch (choice) {
                case 1 -> new PayPalAdapter();
                case 2 -> new StripeAdapter();
                case 3 -> new RazorpayAdapter();
                default -> null;
            };

            if (processor == null) {
                System.out.println("❌ Invalid choice. Please try again.");
                continue;
            }

            PaymentService service = new PaymentService(processor);
            service.processPayment(amount);
        }

        scanner.close();
    }
}