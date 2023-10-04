//CSD420 Tyler O'Riley 09/28/2023 Assignment 10
//Java program using JDBC, JavaFX, and MySQL

package mod10;

public class Fan {      //Class definition to define values that we want to be set
    private int id;
    private String fName;
    private String lName;
    private String favTeam;
    
    public Fan(){};     //Default constructor needs to be defined since a non-default constructor exists
    
    public Fan(int id, String fName, String lName, String favTeam){     //The CONSTRUCTOR to set each class member from the parameters passed in
        this.id = id;                                                   //REMEMBER, constructors are the blueprints to be used to construct things, but only when they are given information
        this.fName = fName;
        this.lName = lName;
        this.favTeam = favTeam;
    }
    
    public int getId(){ //GETTER, to get the id
        return id;
    }
    
    public void setId(int id){ //SETTER, to set the id in a object
        this.id = id;
    }
    
    public String getFName(){
        return fName;
    }
    
    public void setFName(String fname){
        this.fName = fname;
    }
    
    public String getLName(){
        return lName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public String getFavTeam(){
        return favTeam;
    }
    
    public void setFavTeam(String favTeam){
        this.favTeam = favTeam;
    }
}