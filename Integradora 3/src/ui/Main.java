package ui;
import java.util.Scanner;
import model.*;


public class Main{

    private Scanner scan;
    private NeoTunesController neoTunesController;

    public Main(){
        scan = new Scanner(System.in);
        neoTunesController = new NeoTunesController();
    }

    public static void main(String[] args){

        Main main = new Main();
        int option = -1;

        do{
            option = main.showMenu();
            main.executeOption(option);
        }while(option != 0);
    }

    public int validateInteger(){
        int option = -1;

        if(scan.hasNextInt()){
            option = scan.nextInt();
        }
        else{
            scan.next();
            option = -1;
        }
        
        return option;
    }

    public double validateDouble(){
        double option = -1;

        if(scan.hasNextDouble()){
            option = scan.nextDouble();
        }
        else{
            scan.next();
            option = -1;
        }
        
        return option;
    }

    public int showMenu(){
        int option = -1;

        System.out.println();
        System.out.println("Welcome to the menu of the Real State Company, please choose an option");
        System.out.println("1. Register a new Producer. \n" +
        "2. Register a new Customer. \n" +
        "3. Register a new Song or Podcast. \n" +
        "4. Add a new Playlist. \n" +
        "5. Edit a Playlist. \n" +
        "6. Share a Playlist. \n" +
        "7. Simulate a song or podcast reproduction. \n" +
        "8. Buy a song. \n" +
        "9. Generate a report with all the data. \n" +
        "0. Exit.");
        System.out.println();

        option = validateInteger();

        return option;
    }

    /**
     * @param option
     */
    public void executeOption(int option){

        switch(option){

            case 1:

                System.out.println();
                String message = "";
                System.out.println("Please select the type of producer: \n" + 
                "1. Artist.\n" +
                "2. Content creator.");
                int typeProducer = validateInteger();
                if(typeProducer == -1 || typeProducer < 1 || typeProducer > 2){
                    System.out.println("Invalid Option.");
                }
                else{
                    System.out.println("Please type the id number:");
                    String idNumber = scan.next();
                    System.out.println("Please type the nickname: ");
                    String nickName = scan.next();
                    
                    System.out.println("Please type the url with the Image of the producer: ");
                    String urlImage = scan.next();

                    message = neoTunesController.addProducer(idNumber, nickName, typeProducer, urlImage);

                    System.out.println(message);
                }

                break;

            case 2:
            
                System.out.println();
                System.out.println("Please select the type of Customer: \n" + 
                "1. Estandar.\n" +
                "2. Premium.");
                int typeCustomer = validateInteger();
                if(typeCustomer == -1 || typeCustomer < 1 || typeCustomer > 2){
                    System.out.println("Invalid Option.");
                }
                else{
                    System.out.println("Please type the id number:");
                    String idNumber = scan.next();
                    System.out.println("Please type the nickname: ");
                    String nickName = scan.next();
                    

                    String messageTwo = neoTunesController.addCustomer(idNumber, nickName, typeCustomer);

                    System.out.println(messageTwo);

                }

                break;
            
            case 3:
            
                System.out.println();
                String messageThree = "";
                System.out.println("Please select the type of Producer to add the Audio: \n" + 
                "1. Artist.\n" +
                "2. Content Creator.");
                int typeProducerToAudio = validateInteger();
                if(typeProducerToAudio == -1 || typeProducerToAudio < 1 || typeProducerToAudio > 2){
                    System.out.println("Invalid Option.");
                }
                else if(typeProducerToAudio == 1){
                    System.out.println("Please type the name of the artist to add the song: ");
                    String artistSearched = scan.next();
                    System.out.println("Please type the name of the song: ");
                    String name = scan.next();
                    System.out.println("Please type the Album of the song: ");
                    String album = scan.next();
                    System.out.println("Please type the genre of the podcast: \n" + 
                    "1.ROCK. \n" + 
                    "2.POP.\n" +
                    "3.TRAP. \n" +
                    "4.HOUSE.");
                    int genre = validateInteger();
                    System.out.println("Please type the URL of the image of the song: ");
                    String url = scan.next();
                    System.out.println("Please type the duration of the song: ");
                    double durationSong = validateDouble();
                    System.out.println("Please type the duration of the price of the song: ");
                    double price = validateDouble();
                    if(durationSong == -1 || price == -1){
                        System.out.println("Invalid data typed, please type a valid duration and price");
                    }
                    else{
                        messageThree = neoTunesController.addSong(artistSearched, name, album, genre, url, durationSong, price);
                    }
                }
                else if(typeProducerToAudio == 2){
                    System.out.println("Please type the name of the content creator to add the podcast: ");
                    String ccSearched = scan.next();
                    System.out.println("Please type the name of the podcast: ");
                    String namePod = scan.next();
                    System.out.println("Please type the description of the podcast: ");
                    String description = scan.next();
                    System.out.println("Please type the category of the podcast: \n" + 
                    "1.POLITIC. \n" + 
                    "2.ENTERTAINMENT.\n" +
                    "3.VIDEOGAMES. \n" +
                    "4.FASHION.");
                    int category = validateInteger();
                    System.out.println("Please type the URL of the image of the podcast: ");
                    String url = scan.next();
                    System.out.println("Please type the duration of the podcast: ");
                    double durationPod = validateDouble();
                    if(durationPod == -1){
                        System.out.println("Invalid duration, type it again.");
                    }
                    else{
                        messageThree = neoTunesController.addPodcast(ccSearched, namePod, description, category, url, durationPod);
                    }

                }

                System.out.println(messageThree);

                break;

            case 4:
                System.out.println();
                System.out.println("Please type your nickname to add a newPlaylist: ");
                String customerToPlaylist = scan.next();
                System.out.println("Please select the type of playlist: \n" + 
                "1.Just Songs. \n" +
                "2.Just Podcasts." + 
                "3. Mixed.");
                int typePlaylist = validateInteger();
                System.out.println("Please type the name of the Playlist: ");
                String namePlaylist = scan.next();

                String messageFour = neoTunesController.createPlaylist(customerToPlaylist, typePlaylist, namePlaylist);

                System.out.println(messageFour);

                break;

            case 5:
                break;

        }

    }

}
