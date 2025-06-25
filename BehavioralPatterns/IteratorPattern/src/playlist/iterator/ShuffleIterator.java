package playlist.iterator;

import playlist.aggregate.Playlist;
import playlist.model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleIterator implements SongIterator {

    private final List<Song> shuffledSongs;
    private int index = 0;

    public ShuffleIterator(Playlist playlist) {
        shuffledSongs = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public Song next() {
        return shuffledSongs.get(index++);
    }
}