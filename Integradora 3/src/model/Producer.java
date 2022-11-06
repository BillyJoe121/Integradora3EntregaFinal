package model;

import java.util.ArrayList;
import java.time.Instant;

public class Producer extends User {

    private ArrayList<Audio> audios = new ArrayList<>();
    private TypeProducer typeProducer;
    private String urlImage;
    private Instant date;

    public Producer(String idNumber, String nickName, int type, String urlImage){
        super(idNumber, nickName);

        this.urlImage = urlImage;
        if(type == 1){
            this.typeProducer = TypeProducer.ARTIST;
        }
        else if(type == 2){
            this.typeProducer = TypeProducer.CONTENTCREATOR;

        }

        this.audios = new ArrayList<>();
        this.date = Instant.now();

    }

    

    
}
