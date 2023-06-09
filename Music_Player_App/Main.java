package Music_Player_App;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);

        // Added Album in a Arraylist
        albums.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);

        // Added Album in a Arraylist
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway to hell",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList("Lose yourself",playList_1);

        play(playList_1);

    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            System.out.print("\nEnter Choice : ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist Complete\n");
                    System.out.println("********Thanks for Visit my Music App***********");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("No Song Available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("You are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }
                default:
                    System.out.println("Invalid Choice.");
            }

        }
    }

    private static void printMenu(){
        System.out.println("Available Options.....");
        System.out.println("0 - To Quit\n"+
                "1 - To Play Next Song\n"+
                "2 - To Play Previous Song\n"+
                "3 - To Replay the Current Song\n"+
                "4 - List of All Songs \n"+
                "5 - Print all Available Options\n"+
                "6 - Delete Current Song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("<------------------------------------------------------>");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("<------------------------------------------------------>");
    }
}
