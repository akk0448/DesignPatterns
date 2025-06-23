import notification.core.BasicNotifier;
import notification.core.Notifier;
import notification.decorator.EmailNotifier;
import notification.decorator.PushNotifier;
import notification.decorator.SMSNotifier;

import java.util.Scanner;

public class NotificationMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== User Notification System ===");
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        Notifier notifier = new BasicNotifier();

        System.out.println("Choose channels to send notification:");
        System.out.println("1. Email\n2. SMS\n3. Push\n4. All");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> notifier = new EmailNotifier(notifier);
            case 2 -> notifier = new SMSNotifier(notifier);
            case 3 -> notifier = new PushNotifier(notifier);
            case 4 -> notifier = new EmailNotifier(new SMSNotifier(new PushNotifier(notifier)));
            default -> System.out.println("No channel selected. Sending base only.");
        }

        notifier.send(message);
    }
}