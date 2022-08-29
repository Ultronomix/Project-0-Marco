package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) 
    {
        
        
        try{
        Properties prop = new Properties();

        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));


        Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username") ,prop.getProperty("password") );
       
        

        if (conn != null){
        System.out.println("Connection Successful!");
        }
        conn.close();

        }
        catch(IOException e){
           throw new RuntimeException("Could not read from properties file.", e);
        }
        
        catch(SQLException e){
            System.out.println("Unable to connect to the database!");
        } 
        
        
    }
}
