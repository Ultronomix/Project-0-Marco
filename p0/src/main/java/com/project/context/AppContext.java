package com.project.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.screens.Screen;
import com.project.screens.WelcomeScreen;

public class AppContext {

    private static boolean appRunning;
    private BufferedReader reader;

    public AppContext() {
        appRunning = true;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startApp() {
        while (appRunning) {
            try {
                Screen currentScreen = new WelcomeScreen(reader);
                currentScreen.render();
            } catch (IOException e) {
                System.out.println("Could not load the welcome screen");
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        appRunning = false;
    }


}