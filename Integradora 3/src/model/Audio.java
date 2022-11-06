package model;

public  abstract class Audio implements Reproduce {

    private Double duration;
    private String producer;
    private String name;
    private String url;

    public Audio(double duration, String producer, String name, String url){
        this.duration = duration;
        this.producer = producer;
        this.name = name;
        this.url = url;

    }
    
    
}
