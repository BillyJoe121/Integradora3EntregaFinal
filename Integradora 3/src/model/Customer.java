package model;

import java.util.ArrayList;
import java.time.Instant;


public class Customer extends User {

    private Playlist[] playlistsEstandar;
    private ArrayList<Playlist> playlistsPremium;
    private TypeCustomer typeCustomer;
    private Instant date;


    public Customer(String idNumber, String nickName, int typeCustomer){
        super(idNumber, nickName);
        this.date = Instant.now();

        if(typeCustomer == 1){
            this.typeCustomer = TypeCustomer.ESTANDAR;
            this.playlistsEstandar = new Playlist[20];
            this.playlistsPremium = null;

        }
        else if(typeCustomer == 2){
            this.typeCustomer = TypeCustomer.PREMIUM;
            this.playlistsEstandar = null ;
            this.playlistsPremium = new ArrayList<>();
        }

    }
    
    public String addPlaylist(){
        message = "";



        return message;
    }


    
}
