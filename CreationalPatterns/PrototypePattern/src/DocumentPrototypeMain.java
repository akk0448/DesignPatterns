import dtms.manager.DocumentManager;
import dtms.model.*;

import java.util.Scanner;

public class DocumentPrototypeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentManager manager = new DocumentManager();

        // Register Resume
        Resume resume = Resume.builder()
                .withTitle("Software Engineer Resume")
                .withName("John Doe")
                .withEmail("john.doe@example.com")
                .withContent("Skilled in Java, Spring Boot, Microservices.")
                .build();
        manager.registerPrototype("resume", resume);

        // Register Report
        Report report = Report.builder()
                .withTitle("Q2 Financial Report")
                .withAuthor("Finance Team")
                .withDepartment("Finance")
                .withContent("Detailed quarterly performance summary.")
                .build();
        manager.registerPrototype("report", report);

        // Register base Letter (no attachment)
        manager.registerPrototype("letter", Letter.builder()
                .withSender("HR Department")
                .withRecipient("Employee")
                .withSubject("Annual Review Notice")
                .withBody("Your annual performance review is scheduled.")
                .build());

        // Register Letter with Resume
        manager.registerPrototype("letterWithResume", Letter.builder()
                .withSender("HR Department")
                .withRecipient("John Doe")
                .withSubject("Job Offer")
                .withBody("Please find your offer attached.")
                .withAttachment(resume)
                .build());

        // Register Letter with Report
        manager.registerPrototype("letterWithReport", Letter.builder()
                .withSender("Audit Department")
                .withRecipient("Board Members")
                .withSubject("Q2 Review Attached")
                .withBody("Please review the attached Q2 report.")
                .withAttachment(report)
                .build());

        // Start Menu Loop
        boolean running = true;
        while (running) {
            System.out.println("\n===== 📄 Document Management Menu =====");
            System.out.println("1. List Available Prototypes");
            System.out.println("2. Clone and View a Document");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> manager.listAvailablePrototypes();
                case "2" -> {
                    System.out.print("Enter document type to clone (e.g., resume, report, letter, letterWithResume): ");
                    String docType = scanner.nextLine().trim();
                    try {
                        Document cloned = manager.getClonedDocument(docType);
                        cloned.display();
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                }
                case "3" -> {
                    running = false;
                    System.out.println("👋 Exiting Document Management System.");
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}