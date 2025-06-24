package sdv.document;

import sdv.model.User;

public class RealDocument implements Document {

    private final String title;
    private final String content;

    public RealDocument(String title) {
        this.title = title;
        this.content = "Confidential contents of document '" + title + "'.\nLoaded securely...";
        simulateHeavyLoading();
    }

    private void simulateHeavyLoading() {
        System.out.println("📂 Loading '" + title + "' document...");
        try {
            Thread.sleep(1000); // Simulate load delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void displayContent(User user) {
        System.out.println("📄 Title: " + title);
        System.out.println("📑 Content: " + content);
    }
}