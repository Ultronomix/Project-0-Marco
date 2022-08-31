package com.project.students;

import java.util.Objects;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String programName;
    private String facultyName;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id ;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName ;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName ;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email ;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password ;
    }

    public String getFacultyName(){
        return facultyName;
    }
    public void setFacultyName(String facultyName){
        this.facultyName = facultyName ;
    }

    public String getProgramName(){
        return programName;
    }
    public void setProgramName(String programName){
        this.programName = programName ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && Objects.equals(facultyName, student.facultyName) && Objects.equals(programName, student.programName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, programName, facultyName);
    }

    @Override
    public String toString() {
        return "Student{" + "\n" +
                "id='" + id + '\'' + "\n" +
                "firstName='" + firstName + '\'' +  "\n" +
                "lastname='" + lastName + '\'' + "\n" +
                "email='" + email + '\'' + "\n" +
                "password='" + password + '\'' + "\n" +
                "programname='" + programName + '\'' + "\n" +
                "facultyname='" + facultyName + '\'' + "\n" +
                '}';
    }
}
