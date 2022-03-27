package com.example.proyectojee.persistence;

import com.example.proyectojee.logic.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {
    private final StudentDAOFactoty factory = new StudentDAOFactoty();
    @Test
    void addStudent() {
        Student s = new Student("25", "bayona","laura","19","single","futbolt","intercursos","25");
        factory.createStudentDAO().addStudent(s);

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