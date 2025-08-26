import java.util.List;

public class PlaylistIterator implements Iterator {
    private List<Song> songs;
    private int position = 0;

    public PlaylistIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        if (this.hasNext()) {
            return songs.get(position++);
        }
        return null;
    }
}
