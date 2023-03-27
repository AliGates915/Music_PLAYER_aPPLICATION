package Music_Player_App;

public class Song {
    private String title;
    private double duration;
    public Song()
    { /*This is an Empty Constructor*/ }
    /**
    *This is a Song Constructor for Passing two Arguments.
    */
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    public String getTitle()
    {
        return title;
    }
    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{ " +
                "title = '" + title + '\'' +
                "\t || \t duration = " + duration +
                '}';
    }
}
