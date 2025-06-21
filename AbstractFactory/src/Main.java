import bams.enums.ClientType;
import bams.factory.BankProductFactory;
import bams.model.Account;
import bams.model.Card;
import bams.model.Loan;
import bams.provider.BankFactoryProvider;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to BAMSystem ---");
            System.out.println("Select Client Type:");
            System.out.println("1. Individual");
            System.out.println("2. Business");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> handleClient(ClientType.INDIVIDUAL);
                case "2" -> handleClient(ClientType.BUSINESS);
                case "3" -> {
                    System.out.println("Exiting... Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }

        scanner.close();
    }

    private static void handleClient(ClientType type) {
        System.out.println("\nGenerating product bundle for: " + type.getDisplayName());

        BankProductFactory factory = BankFactoryProvider.getFactory(type);

        Account account = factory.createAccount();
        Card card = factory.createCard();
        Loan loan = factory.createLoan();

        account.displayDetails();
        card.displayDetails();
        loan.displayDetails();
    }
}
