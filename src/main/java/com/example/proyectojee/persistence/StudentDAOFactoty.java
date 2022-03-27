package com.example.proyectojee.persistence;

public class StudentDAOFactoty {
    public StudentDAO createStudentDAO() {

        return new StudentDAOImpl();
    }

}