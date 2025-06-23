package notification.core;

public class BasicNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Base Notification: " + message);
    }
}