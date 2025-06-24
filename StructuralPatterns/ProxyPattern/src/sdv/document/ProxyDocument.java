package sdv.document;

import sdv.auth.AccessManager;
import sdv.auth.AuditLogger;
import sdv.model.User;

public class ProxyDocument implements Document {

    private final String title;
    private RealDocument realDocument;

    public ProxyDocument(String title) {
        this.title = title;
    }

    @Override
    public void displayContent(User user) {
        if (!AccessManager.hasAccess(user)) {
            AuditLogger.log(user.getUsername(), title, "ACCESS DENIED");
            System.out.println("❌ Access denied. You are not authorized to view this document.");
            return;
        }

        AuditLogger.log(user.getUsername(), title, "ACCESS GRANTED");

        if (realDocument == null) {
            realDocument = new RealDocument(title); // Lazy Initialization
        }

        realDocument.displayContent(user);
    }
}