import oms.fulfillment.DeliveryService;
import oms.fulfillment.FulfillmentService;
import oms.fulfillment.PickupService;
import oms.order.InStoreOrder;
import oms.order.OnlineOrder;
import oms.order.Order;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Order Management System ====");

        while (true) {
            System.out.println("\nSelect Order Type:");
            System.out.println("1. Online Order");
            System.out.println("2. In-Store Order");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int orderTypeChoice = scanner.nextInt();
            scanner.nextLine();

            if (orderTypeChoice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter Order ID: ");
            String orderId = scanner.nextLine();

            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("\nSelect Fulfillment Type:");
            System.out.println("1. Delivery");
            System.out.println("2. Pickup");
            System.out.print("Choice: ");
            int fulfillmentChoice = scanner.nextInt();
            scanner.nextLine();

            FulfillmentService fulfillmentService;
            if (fulfillmentChoice == 1) {
                fulfillmentService = new DeliveryService();
            } else {
                fulfillmentService = new PickupService();
            }

            Order order;
            if (orderTypeChoice == 1) {
                order = new OnlineOrder(orderId, amount, fulfillmentService);
            } else {
                order = new InStoreOrder(orderId, amount, fulfillmentService);
            }

            System.out.println("\n--- Processing Order ---");
            order.processOrder();
        }

        scanner.close();
    }
}