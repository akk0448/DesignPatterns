package notification.decorator;

import notification.core.Notifier;

public class SMSNotifier extends NotifierDecorator {

    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("📱 SMS sent: " + message);
    }
}