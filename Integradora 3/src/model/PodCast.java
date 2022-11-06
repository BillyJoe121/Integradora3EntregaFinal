package model;

public class PodCast extends Audio  {

    private Category category;
    private String description;
    private double durationSong;
    private int numberReproductions;
    private Category type;

    public PodCast(String ccSearched, String name,  String description,int  category, String url, double durationPod){
        super(durationPod, ccSearched, name, url);

        if(category == 1){
            this.category = type.POLITIC;
        }
        else if(category == 2){
            this.category = type.ENTERTAINMENT;
        }
        else if(category == 3){
            this.category = type.VIDEOGAMES;
        }
        else if(category == 4){
            this.category = type.FASHION;
        }


        this.description = description;
        this.numberReproductions = 0;

    }
  
    
}
