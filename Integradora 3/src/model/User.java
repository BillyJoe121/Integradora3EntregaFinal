package model;
import java.time.Instant;


public abstract class User {
 
    private String idNumber;
    private String nickName;


    public User(String idNumber, String nickName){
    
        this.idNumber = idNumber;
        this.nickName = nickName;
    }
      
    public String getIdNumber(){
        return this.idNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public String getnickName(){
        return this.nickName;
    }

    public void setnickName(String nickName){
        this.nickName = nickName;
    }



}
