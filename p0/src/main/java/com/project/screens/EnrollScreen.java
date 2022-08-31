package com.project.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.project.students.Student;
import com.project.students.StudentDAO;

public class EnrollScreen extends Abstractscreen {

    public EnrollScreen(BufferedReader reader) {
        super("Enroll screen", reader);

    }

    @Override
    public void render() throws IOException {
        Student student = new Student();

        System.out.println("Please insert some information");
        System.out.println();
        boolean formComplete = false;
        while (!formComplete) {

            System.out.print("Student's first name -Must not be empty- >");
            String firstName = reader.readLine();

            if (firstName == null || firstName.trim().equals("")) {
                System.out.println("Invalid first name provided. Returning to top of form");
                continue;
            }

            student.setFirstName(firstName);

            System.out.print("Student's last name -Must not be empty- >");
            String lastName = reader.readLine();

            if (lastName == null || lastName.trim().equals("")) {
                System.out.println("Invalid last name provided. Returning to top of form");
                continue;
            }

            student.setLastName(lastName);

            System.out.print("Student's Email -Must be unique- >");
            String email = reader.readLine();

            if (email == null || lastName.trim().equals("") || !email.contains("@")) {
                System.out.println("Invalid Email name provided. Returning to top of form");
                continue;
            }

            student.setEmail(email);

            System.out.print("Student's password -Must be 8 characters or more - >");
            String password = reader.readLine();

            if (password == null || password.trim().equals("") || password.length() <= 7) {
                System.out.println("Invalid Email name provided. Returning to top of form");
                continue;
            }

            student.setPassword(password);

            System.out.println(
                    "Select the student's program\n1)Associate degree\n2)Bachelor degree\n3)Master degree\n4)PHD");

            String programSelection = reader.readLine();

            switch (programSelection) {
                case "1":
                    student.setProgramName("Associate degree");
                    break;

                case "2":
                    student.setProgramName("Bachelor degree");
                    break;

                case "3":
                    student.setProgramName("Master degree");
                    break;

                case "4":
                    student.setProgramName("PHD");
                    break;

                default:
                    System.out.println("Invalid program selection Returning to top of form");
                    continue;
            }

            System.out.println(
                    "Select the student's faculty\n1)Faculty of Arts\n2)Faculty of Economics\n3)Faculty of Engineering\n4)Faculty of Music\n5)Faculty of Philosophy");

            String facultySelection = reader.readLine();

            switch (facultySelection) {
                case "1":
                    student.setFacultyName("Faculty of Arts");
                    break;

                case "2":
                    student.setFacultyName("Faculty of Economics");
                    break;

                case "3":
                    student.setFacultyName("Faculty of Engineering");
                    break;

                case "4":
                    student.setFacultyName("Faculty of Music");
                    break;

                case "5":
                    student.setFacultyName("Faculty of Philosophy");
                    break;

                default:
                    System.out.println("Invalid program selection Returning to top of form");
                    continue;
            }

            StudentDAO sDao = new StudentDAO();
           String newStudentId = sDao.enrollNewStudent(student, facultySelection);
           System.out.println("Student successfully persisted! Generated id: " + newStudentId);
           
           formComplete = true;
        }
    }
}