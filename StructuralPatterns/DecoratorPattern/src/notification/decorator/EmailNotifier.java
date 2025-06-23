package notification.decorator;

import notification.core.Notifier;

public class EmailNotifier extends NotifierDecorator {

    public EmailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("📧 Email sent: " + message);
    }
}