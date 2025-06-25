package playlist.aggregate;

import playlist.model.Song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public int size() {
        return songs.size();
    }

    public Song get(int index) {
        return songs.get(index);
    }
}