package model;

public class Song extends Audio {

    private String album;
    private Genres genre;
    private double durationSong;
    private double price;
    private int numberReproductions;
    private int numberSells;
    private Genres types;


    public Song(String artistSearched, String name, String album, int genre, String url, double durationSong, double price){ 
        super(durationSong, artistSearched, name, url);

        this.album = album;

        if(genre == 1){
            this.genre = types.ROCK;
        }
        else if(genre == 2){
            this.genre = types.POP;
        }
        else if(genre == 3){
            this.genre = types.TRAP;
        }
        else if(genre == 4){
            this.genre = types.HOUSE;
        }

        this.durationSong = durationSong;
        this.price = price;
        this.numberReproductions = 0;
        this.numberSells = 0;

    }        
    
}
