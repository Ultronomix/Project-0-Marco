package com.project;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project.students.Student;
import com.project.students.StudentDAO;


public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Welcome to University of Phoenix" + "\nPlease choose a servise" + "\n1) Print all students" + "\n2) Enroll a new student" + "\n3) Delete a student");
        
        int userChoice=5;
        try(Scanner sc = new Scanner(System.in)){
        userChoice = sc.nextInt();
        }catch(InputMismatchException e){
            System.err.println("Wrong input");
        }
        
       
        switch(userChoice){
            case 1 :
            StudentDAO sDao = new StudentDAO();
            List<Student> students = sDao.getAllStudents();
        
            for(Student student : students){
                System.out.println(student);
                System.out.println();
                }
            break;

            case 2 :
            System.out.println("enrolling a student");
            break;

            case 3 :
            System.out.println("Deleting a student");
            break;

            default : System.err.println("Invald choice!");
        }
    }

    
}
