package com.example.proyectojee.persistence;

import com.example.proyectojee.logic.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/participantes";
    private static final String USER = "participantes";
    private static final String PASSWD = "binylau";

    @Override
    public void addStudent(Student student) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();

            String code = student.getCode();
            String surName = student.getSurname();
            String name = student.getName();
            String edad = student.getEdad();
            String modo = student.getModo();
            String disciplina = student.getDisciplina();
            String evento = student.getEvento();
            String posicion = student.getPosicion();


            final String query = "INSERT INTO student VALUES(" + "'" + code + "','" + name + "','" + surName + "','" + edad + "','" + disciplina + "','" + modo+ "','" + evento + "','" + posicion + "')";

            System.out.println(query);

            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void delete(String code) {

    }

    @Override
    public Student findByCode(String code) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("select * from student");
        ) {
            while (result.next()) {
                String code = result.getString("code");
                String surName = result.getString("surname");
                String name = result.getString("name");
                String edad = result.getString("edad");
                String modo = result.getString("modo");
                String disciplina = result.getString("disicplina");
                String evento = result.getString("evento");
                String posicion = result.getString("posicion");


                double subsidy = Double.valueOf(result.getString("subsidy"));

                students.add(new Student(code, surName, name, edad, modo, disciplina, evento, posicion));
            }

            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
