package com.project.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.project.context.AppContext;

public class WelcomeScreen extends Abstractscreen {
    
    public WelcomeScreen (BufferedReader reader){
        super("Welcome",reader);
        
    }

    @Override
    public void render() throws IOException {

        System.out.println("Welcome to My University" + "\nPlease make a selection from the options below" + 
        "\n1) Get information about students" + "\n2) Enroll a new student" + "\n3) Delete a student" + "\n4)Exit");

        String userInput = reader.readLine();

        switch (userInput){
            case "1" :  new PrintScreen(reader).render();
            break;

            case "2" : new EnrollScreen(reader).render();
            break;

            case "3" :
            System.out.println("Deleting a student");
            break;

            case "4" :
            System.out.println("Exiting the application!");
            AppContext.shutdown();
            break;

            default : System.err.println("Invald choice!");
        }

        

    }
}
