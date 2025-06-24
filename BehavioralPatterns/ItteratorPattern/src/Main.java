import playlist.aggregate.Playlist;
import playlist.iterator.ForwardIterator;
import playlist.iterator.ReverseIterator;
import playlist.iterator.ShuffleIterator;
import playlist.iterator.SongIterator;
import playlist.model.Song;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        playlist.addSong(new Song("Let It Be", "The Beatles", "Rock"));
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen", "Rock"));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran", "Pop"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd", "Pop"));
        playlist.addSong(new Song("Viva La Vida", "Coldplay", "Alternative"));

        boolean running = true;

        while (running) {
            System.out.println("\n🎧 Playlist Manager");
            System.out.println("1. Play Songs (Forward)");
            System.out.println("2. Play Songs (Reverse)");
            System.out.println("3. Play Songs (Shuffle)");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            String choice = scanner.nextLine();

            SongIterator iterator = null;

            switch (choice) {
                case "1":
                    iterator = new ForwardIterator(playlist);
                    System.out.println("\n▶️ Playing Songs (Forward):");
                    break;
                case "2":
                    iterator = new ReverseIterator(playlist);
                    System.out.println("\n⏪ Playing Songs (Reverse):");
                    break;
                case "3":
                    iterator = new ShuffleIterator(playlist);
                    System.out.println("\n🔀 Playing Songs (Shuffle):");
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting Playlist Manager 🎵");
                    continue;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        scanner.close();
    }
}