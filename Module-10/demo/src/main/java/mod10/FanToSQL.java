//CSD420 Tyler O'Riley 09/28/2023 Assignment 10
//Java program using JDBC, JavaFX, and MySQL

package mod10;

import java.sql.*;
import java.util.ArrayList;

public class FanToSQL{

    Connection connection;
    Statement statement;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";               //private final variable to make the SQL connectors unchangeable and only accessible locally
    private final String URL = "jdbc:mysql://localhost:3306/databasedb?";
    private final String USERNAME = "student1";
    private final String PASSWORD = "pass";
        
    private Fan createSportsFan(ResultSet rs){
        //Fan fan = new Fan(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("FAVORITETEAM"));
        try{
            Fan fan = new Fan(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("FAVORITETEAM"));
            //fan.setId(rs.getInt("ID"));
            //fan.setFName(rs.getString("FIRSTNAME"));
            //fan.setLName(rs.getString("LASTNAME"));
            //fan.setFavTeam(rs.getString("FAVORITETEAM"));
            return fan;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new Fan();
    }
    
    public ArrayList<Fan> getFans(){        //Returns an ArrayList of Fan type
        String sqlCommand = "Select * from fans;";
        ArrayList<Fan> list = new ArrayList<>();
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  //Statements to establish MySQL connection and run sqlCommand of above string(line 36)
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                Fan fan = createSportsFan(resultSet);
                list.add(fan);
            }
            resultSet.close();
            connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Fan> getFanById(int id){
        String sqlCommand = "Select * from fans where ID like '%" + id + "%'";  //SQL command to match inputed id with Fan PRIMARY KEY ID
        ArrayList<Fan> list = new ArrayList<>();
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            
            while(resultSet.next()){
                Fan fan = createSportsFan(resultSet);
                list.add(fan);
            }
            resultSet.close();
            connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}