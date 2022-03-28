package com.example.proyectojee.persistence;

import com.example.proyectojee.logic.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {
    private final StudentDAOFactoty factory = new StudentDAOFactoty();
    @Test
    void addStudent() {
        Student s = new Student("63", "set","Diego","19","single","futbolt","intercursos","25");
        //Student d = new Student("007", "Aguilar","Robinson","19","single","futbolt","nacionales","1");
        factory.createStudentDAO().addStudent(s);
        //factory.createStudentDAO().addStudent(d);
    }

    @Test
    void updateStudent() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByCode() {
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void close() {
    }
}