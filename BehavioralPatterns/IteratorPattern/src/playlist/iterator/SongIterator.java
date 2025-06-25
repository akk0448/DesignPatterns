package playlist.iterator;

import playlist.model.Song;

public interface SongIterator {

    boolean hasNext();

    Song next();
}
