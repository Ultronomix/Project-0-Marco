package com.project.common.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory{

    private Properties prop = new Properties();
    private static ConnectionFactory connfactory;
    private ConnectionFactory(){
        try{
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        }catch(IOException e){
            throw new RuntimeException("Could not read from properties file.", e);
        }
    }

    public Connection getConnection() throws SQLException{  
        return
        DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username") ,prop.getProperty("password") );       
    }

    public static ConnectionFactory getInstent(){
        if(connfactory == null){
            connfactory = new ConnectionFactory();
        }
         return connfactory;
    }
}