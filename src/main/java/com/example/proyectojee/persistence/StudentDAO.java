package com.example.proyectojee.persistence;
import com.example.proyectojee.logic.Student;
import java.util.List;

public interface StudentDAO extends java.lang.AutoCloseable{
    void addStudent(Student tudent);
    void updateStudent(Student student);
    void delete( String code);
    Student findByCode(String code);
    List<Student> getAllStudents();
}
