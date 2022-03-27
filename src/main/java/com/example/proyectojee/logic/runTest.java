package com.example.proyectojee.logic;

import com.example.proyectojee.persistence.StudentDAOImpl;

import java.util.ArrayList;

public class runTest {
    public static void main(String[] args) {
        StudentDAOImpl test = new StudentDAOImpl();

        ArrayList<Student> out = (ArrayList<Student>) test.getAllStudents();

        out.forEach(student -> System.out.println(student));
    }
}
