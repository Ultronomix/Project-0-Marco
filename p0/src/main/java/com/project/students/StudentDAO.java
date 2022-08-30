package com.project.students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.common.datasource.ConnectionFactory;

public class StudentDAO {
    
    public List <Student> getAllStudents(){

        String sql = "select student.id as student_id, student.first_name as student_first_name, student.last_name as student_last_name, student.email as student_email, student.password as student_password, faculty.name as faculty_name, program.name as program_name , program.duration as program_duration "
       + "from student" + 
        " join faculty" +
       " on student.faculty_id = faculty.id " +
        "join program "+ 
        "on student.program_id = program.id;";

        ArrayList<Student> students = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getInstent().getConnection()){

            System.out.println("Connection successful!");

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()){
                Student student =new Student();
                student.setId(rs.getString("student_id"));
                student.setFirstName(rs.getString("student_first_name"));
                student.setLastName(rs.getString("student_last_name"));
                student.setEmail(rs.getString("student_email"));
                student.setPassword(rs.getString("student_password"));
                student.setFacultyName(rs.getString("faculty_name"));
                student.setProgramName(rs.getString("program_name"));
                student.setProgramDuration(rs.getString("program_duration"));

                students.add(student);

            }


        }catch(SQLException e){
            System.out.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }

        return students;

    }
}
