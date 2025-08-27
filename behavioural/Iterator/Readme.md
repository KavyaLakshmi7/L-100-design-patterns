# 🎵 Iterator Pattern - Music Playlist Example

## 📌 Overview
The **Iterator Pattern** provides a way to access elements of a collection sequentially without exposing its underlying representation.  
In this example, we implement a **music playlist** where songs can be added and iterated through using a custom iterator.

---

## 🛠️ Components

1. **Iterator (Interface)**  
   - Defines methods `hasNext()` and `next()` for traversal.

2. **PlaylistIterator (Concrete Iterator)**  
   - Implements the `Iterator` interface.  
   - Keeps track of the current position while iterating through songs.

3. **Playlist (Aggregate / Collection)**  
   - Stores a list of `Song` objects.  
   - Provides a `createIterator()` method to return a `PlaylistIterator`.

4. **Song (Data Object)**  
   - Represents a song with a **title** and **artist**.

5. **MusicPlayer (Client)**  
   - Allows users to create a playlist.  
   - Iterates through the playlist using the `Iterator`.  

---

## 📂 Class Diagram

```

Iterator (interface)
├── hasNext()
└── next()

PlaylistIterator (implements Iterator)
├── List<Song> songs
├── int position
├── hasNext()
└── next()

Playlist
├── List<Song> songs
├── addSong(Song)
└── createIterator()

Song
├── title
├── artist
└── toString()

MusicPlayer (Client)

```

---

## ▶️ How It Works

1. User adds songs (title & artist) to the playlist.  
2. The `Playlist` creates an iterator (`PlaylistIterator`).  
3. The `Iterator` traverses through songs one by one.  
4. Each song is displayed as **Now playing: \<song\>**.  

---

## 💻 Example Run

```

Create your playlist:
Enter song title (or type 'done' to finish): Shape of You
Enter artist name: Ed Sheeran
Enter song title (or type 'done' to finish): Believer
Enter artist name: Imagine Dragons
Enter song title (or type 'done' to finish): done

Playing your playlist:
Now playing: Shape of You by Ed Sheeran
Press Enter to play next song...

Now playing: Believer by Imagine Dragons
Press Enter to play next song...

End of playlist

````

---

## ✅ Key Benefits
- **Encapsulation** – Internal structure of `Playlist` is hidden.  
- **Flexibility** – Multiple iterators can traverse the same collection independently.  
- **Simplicity** – Provides a clean way to loop through objects without exposing implementation details.  

---

## 📖 Real-World Use Cases
- Music/Video playlists  
- Browsing products in an online store  
- Iterating through files in a directory  
- Paging through results in a database query  

---

## 🚀 How to Run
1. Compile all `.java` files:  
   ```bash
   javac *.java
````

2. Run the program:

   ```bash
   java MusicPlayer
   ```
