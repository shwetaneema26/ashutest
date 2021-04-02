package ashutest;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song first = this;

        while(nextSong != null && nextSong != first)
        {
            nextSong = nextSong.nextSong;
        }
        if(first == nextSong)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third  = new Song("bye");
        Song fourth  = new Song("my");


        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(fourth);

        System.out.println(first.isRepeatingPlaylist());
    }
}
