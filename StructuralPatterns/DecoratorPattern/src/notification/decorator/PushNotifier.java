package notification.decorator;

import notification.core.Notifier;

public class PushNotifier extends NotifierDecorator {

    public PushNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("🔔 Push notification sent: " + message);
    }
}