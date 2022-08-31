package com.project.screens;

import java.io.BufferedReader;

public abstract class Abstractscreen implements Screen{

    protected String name;
    protected BufferedReader reader;

    public Abstractscreen(String name, BufferedReader reader) {
        this.name = name;
        this.reader = reader;
    }

    public String getName() {
        return name;
    }

    

}
