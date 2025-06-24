import sdv.document.Document;
import sdv.document.ProxyDocument;
import sdv.model.User;

import java.util.Scanner;

public class SecureViewerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your role (ADMIN/USER): ");
        String role = sc.nextLine();

        User currentUser = new User(name, role.toUpperCase());

        Document secureDoc = new ProxyDocument("Secret-Design-Specs");

        System.out.println("\n--- Attempting to Access Document ---\n");
        secureDoc.displayContent(currentUser);
    }
}