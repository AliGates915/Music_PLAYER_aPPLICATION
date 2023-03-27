package Music_Player_App;

import java.util.ArrayList;
import java.util.LinkedList;
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    public Album()
    { /*This is an Empty Constructor*/ }
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Song findSong(String title){

        for(Song checkedSong : songs){
            // This condition check the Song Already Exit in the list then new song is not added in the list,
            // Otherwise no exists in the list then we return null;
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//           System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
//            System.out.println("Song with name "+ title+ " already exist in the list");
            return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        // index start From '0' , Then trackNumber - 1;
        int index = trackNumber - 1;
        // 'index <= this.songs.size()' means that Size of Song is a Duration of Song, Greater than from index.
        // Then Automatically store song in a Sequence.
        if(index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("This Album does not have Song with TrackNumber "+trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title + "There is no such Song in Album.");
        return false;
    }
}
