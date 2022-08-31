package com.project.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.project.students.StudentDAO;

public class DeleteScreen extends Abstractscreen {

    public DeleteScreen(BufferedReader reader) {
        super("Delete screen", reader);
        
    }

    @Override
    public void render() throws IOException {
        
        System.out.println("Please insert the student's ID to be deleted");
        String deletedId = reader.readLine();

        StudentDAO sDao = new StudentDAO();
        int affectedRows=sDao.deleteStudent(deletedId);
        System.out.println("Student successfully deleted! affected rows: " + affectedRows);
    }
    
}
