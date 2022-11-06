package model;

import java.util.ArrayList;
import java.util.Random;

public class Playlist implements Reproduce{

    
    public static final int ROWS = 6;
    public static final int COLUMNS = 6;
    private Random random;



    private ArrayList<Audio> playList;
    private String code;
    private String name;
    

    public Playlist(int type, String name){

        this.playList = new ArrayList<Audio>();
        this.name = name;
        this.code = generateCode(type);

    }

    public String generateCode(int type){

        String result = null;
        int counter = 1;
        int counterTwo = 1;
        int [][] matriz = generateMatriz();

        if(type == 1){
            for(int i = matriz.length -1; i >= 0; i++){
                result += matriz[i][0];
            }

            for(int i = 1; i < matriz.length - 1; i++){
                result += matriz[counter][counterTwo];
                counter += 1;
                counterTwo += 1;
            } 

            for(int i = matriz.length - 1; i >= 0; i++){
                result += matriz[i][matriz.length - 1];
            }
        }
        else if(type == 2){ 

            for(int i = 0; i < 2; i++){
                result += matriz[0][i];
            }
            for(int j = 1; j < 5; j++){
                result += matriz[j][2];
            } 
            for(int k = 5; k < 0; k--){
                result += matriz[k][3];
            }
            for(int u = 3; u > 5; u++){
                result += matriz[0][u];
            }
        }
        else if(type == 3){ 

                for (int i = 5; i >= 0; i--){
                    for(int j = 5;j >= 0;j--){
                        int sum = i + j;
                        if (sum%2 != 0){
                            if(sum != 1){
                                result += matriz[i][j]+" ";
                            }
                        }
                    }
                }
        }
        return result;

    }

    public int [][] generateMatriz(){
        random = new Random();
    
        int matriz[][] = new int[ROWS][COLUMNS];

        for(int i = 0; i < ROWS; i++){
            for(int j= 0; j < COLUMNS; j++){
                matriz[i][j] = random.nextInt(9); 
            }
        }
        return matriz;
    }
    
}
