package com.project.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.common.datasource.ConnectionFactory;

public class StudentDAO {

    public List<Student> getAllStudents() {

        String sql = "select student.id as student_id, " +
                "student.first_name as student_first_name, " +
                "student.last_name as student_last_name, " +
                "student.email as student_email, " +
                "student.password as student_password, " +
                "student.program_name as program_name, " +
                "faculty.name as faculty_name " +
                "from student" +
                " join faculty" +
                " on student.faculty_id=faculty.id;";

        ArrayList<Student> students = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstent().getConnection()) {

            System.out.println("Connection successful!");

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("student_id"));
                student.setFirstName(rs.getString("student_first_name"));
                student.setLastName(rs.getString("student_last_name"));
                student.setEmail(rs.getString("student_email"));
                student.setPassword(rs.getString("student_password"));
                student.setProgramName(rs.getString("program_name"));
                student.setFacultyName(rs.getString("faculty_name"));

                students.add(student);

            }

        } catch (SQLException e) {
            System.out.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }

        return students;

    }

    public void getStudent(String givenId) {

        String sql = "select student.id as student_id, " +
                "student.first_name as student_first_name, " +
                "student.last_name as student_last_name, " +
                "student.email as student_email, " +
                "student.password as student_password, " +
                "student.program_name as program_name, " +
                "faculty.name as faculty_name " +
                "from student " +
                "join faculty " +
                "on student.faculty_id=faculty.id " +
                "where student.id = " + givenId + ";";

        try (Connection conn = ConnectionFactory.getInstent().getConnection()) {

            System.out.println("Connection successful!");

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("student_id"));
                student.setFirstName(rs.getString("student_first_name"));
                student.setLastName(rs.getString("student_last_name"));
                student.setEmail(rs.getString("student_email"));
                student.setPassword(rs.getString("student_password"));
                student.setProgramName(rs.getString("program_name"));
                student.setFacultyName(rs.getString("faculty_name"));

                System.out.println(student);
            }

            

        } catch (SQLException e) {
            System.out.println("Something went wrong when communicating with the Database");
            e.printStackTrace();
        }

    }

    public String enrollNewStudent(Student student, String facultyId) {

        

        String sql = "insert into student(first_name,last_name,email,password,program_name,faculty_id)" +
                " values(?,?,?,?,?," + "'"+ facultyId +"'"+ ");";

        try (Connection conn = ConnectionFactory.getInstent().getConnection()) {

            PreparedStatement pStat = conn.prepareStatement(sql, new String[] { "id" });
            pStat.setString(1, student.getFirstName());
            pStat.setString(2, student.getLastName());
            pStat.setString(3, student.getEmail());
            pStat.setString(4, student.getPassword());
            pStat.setString(5, student.getProgramName());

            pStat.executeUpdate();

            ResultSet rs = pStat.getGeneratedKeys();
            rs.next();
            student.setId(rs.getString("id"));

        } catch (SQLException e) {
            System.out.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }

        return student.getId();
    }
}
