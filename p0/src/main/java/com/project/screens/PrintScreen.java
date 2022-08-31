package com.project.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.project.students.Student;
import com.project.students.StudentDAO;

public class PrintScreen extends Abstractscreen {

    public PrintScreen(BufferedReader reader) {
        super("Print Screen", reader);
        
    }

    @Override
    public void render() throws IOException {

        System.out.println("Please make a selection\n1) Print data for all students\n2)Print data for single student with a given ID");
        
        String input = reader.readLine();

        StudentDAO sDao = new StudentDAO();

        switch(input){
            case "1" :
            
            List<Student> students = sDao.getAllStudents();
        
            for(Student student : students){
                System.out.println(student);
                System.out.println();
                }
            break;

            case "2" : System.out.println("Please enter the student ID");
            String givenId = reader.readLine();
            sDao.getStudent(givenId);
        }
        
        
        
    }
    
}
