import newsfeed.observer.EmailSubscriber;
import newsfeed.observer.Observer;
import newsfeed.subject.NewsAgency;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer alice = new EmailSubscriber("Alice");
        Observer bob = new EmailSubscriber("Bob");

        agency.registerObserver(alice);
        agency.registerObserver(bob);

        agency.setNews("🚨 Breaking: Observer Pattern Simplified!");
        agency.setNews("🎯 Update: Java 21 Released!");
    }
}