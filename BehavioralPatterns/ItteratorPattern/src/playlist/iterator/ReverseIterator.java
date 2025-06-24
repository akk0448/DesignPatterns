package playlist.iterator;

import playlist.aggregate.Playlist;
import playlist.model.Song;

public class ReverseIterator implements SongIterator {

    private final Playlist playlist;
    private int index;

    public ReverseIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = playlist.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Song next() {
        return playlist.get(index--);
    }
}