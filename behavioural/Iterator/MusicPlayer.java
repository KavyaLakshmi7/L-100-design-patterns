import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();

        System.out.println("Create your playlist:");
        while (true) {
            System.out.print("Enter song title (or type 'done' to finish): ");
            String title = sc.nextLine();
            if (title.equalsIgnoreCase("done")) break;

            System.out.print("Enter artist name: ");
            String artist = sc.nextLine();

            playlist.addSong(new Song(title, artist));
        }

        System.out.println("\nPlaying your playlist:");
        Iterator iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            System.out.println("Now playing: " + iterator.next());
            System.out.print("Press Enter to play next song...");
            sc.nextLine();
        }

        System.out.println("End of playlist");
        sc.close();
    }
}
