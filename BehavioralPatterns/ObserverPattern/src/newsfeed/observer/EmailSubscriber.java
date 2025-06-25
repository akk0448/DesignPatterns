package newsfeed.observer;

public class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println("[EMAIL] " + name + " received: " + news);
    }
}