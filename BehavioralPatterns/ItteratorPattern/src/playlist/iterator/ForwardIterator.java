package playlist.iterator;

import playlist.aggregate.Playlist;
import playlist.model.Song;

public class ForwardIterator implements SongIterator {

    private final Playlist playlist;
    private int index = 0;

    public ForwardIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.size();
    }

    @Override
    public Song next() {
        return playlist.get(index++);
    }
}