package model;
import java.util.ArrayList;
import java.util.Scanner;


import static java.lang.Math.*;
import java.util.Random;

public class NeoTunesController{

    

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private Customer customerComparative;
    private Producer producerComparative;
    private ArrayList<Playlist> playlist;


    public NeoTunesController(){

        users = new  ArrayList<User>();
        audios = new ArrayList<Audio>();
        playlist = new ArrayList<Playlist>();
        customerComparative = new Customer(null, null, 1);
        producerComparative = new Producer(null, null, 0, null);


        
    }

    public String addProducer(String idNumber, String nickName, int type, String urlImage){
        String message;
        User newProducer = new Producer(idNumber, nickName, type, urlImage);
        users.add(newProducer);
        message = "Producer added successfully.";

        return message;
    }

    public String addCustomer(String idNumber, String nickName, int typeCustomer){
        String message;
        User newCustomer = new Customer(idNumber, nickName, typeCustomer);
        users.add(newCustomer);
        message = "Customer added successfully.";

        return message;
    }

    public String addSong(String artistSearched, String name, String album, int genre, String url, double durationSong, double price ){
        String message = "";
        User userToAdd = searchProducerBynickName(artistSearched);
        
        if(userToAdd == null){
            message = "The user does not exist.";
        }
        else{
            Song newSong = new Song(artistSearched, name, album, genre, url, durationSong, price);
            audios.add(newSong);
            message = "Song added successfully.";
        }

        return message;
    }

    public String addPodcast(String ccSearched, String namePod, String description, int category, String url, double durationPod){
        String message = "";
        User userToAdd = searchProducerBynickName(ccSearched);

        if(userToAdd == null){
            message = "The user does not exist.";
        }
        else if(category == -1 || category > 4){
            message = "Invalid category.";
        }
        else{
            PodCast newPodcast = new PodCast( ccSearched, namePod, description, category, url, durationPod);
            audios.add(newPodcast);
            message = "Podcast added successfully.";
        }

        return message;

    }

    public User searchProducerBynickName(String searched){
        User result = null;
        boolean isFounded = false;
        for (User iterator : users) {
            if(iterator instanceof Producer){
               if( iterator.getnickName().equalsIgnoreCase(searched)){
                result = iterator;
                isFounded = true;
               }
            }
        }
        
        return result;
    }    

    public String createPlaylist(String customerToPlaylist, int typePlaylist, String namePlaylist){
        String message = "";

        User customer = searchCustomerBynickName(customerToPlaylist);
        int position = users.indexOf(customer);

        if(position >= 0){
            message = "The user does not exists.";
        }        
        else if(typePlaylist == -1 || typePlaylist > 3){
            message = "type of Playlist invalid.";
        }
        
        else {
            Playlist newPlaylist = new Playlist(typePlaylist, namePlaylist);
            playlist.add(newPlaylist);


        }


        return message;
    }
    
    public User searchCustomerBynickName(String searched){
        User result = null;
        boolean isFounded = false;
        for (User iterator : users) {
            if(iterator instanceof Customer){
               if( iterator.getnickName().equalsIgnoreCase(searched)){
                result = iterator;
                isFounded = true;
               }
            }
        }
        
        return result;
    }   


}