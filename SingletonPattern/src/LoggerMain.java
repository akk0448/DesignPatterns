import ls.logger.Logger;

import java.util.Scanner;

public class LoggerMain {

    private static final Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> logger.info("UserService - User created successfully.");
                case 2 -> logger.warn("InventoryService - Low stock alert.");
                case 3 -> logger.error("PaymentService - Transaction failed.");
                case 4 -> logger.debug("AuthService - Token validated.");
                case 5 -> logger.trace("AuditService - Trace log for debugging.");
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }

            System.out.println();

        } while (choice != 6);
    }

    private static void printMenu() {
        System.out.println("""
                ==== Logger Menu ====
                1. Log INFO
                2. Log WARN
                3. Log ERROR
                4. Log DEBUG
                5. Log TRACE
                6. Exit
                """);
    }
}