package com.example.proyectojee.persistence;

import com.example.proyectojee.logic.Student;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    /**
     * variable que inicializa el driver de la conecion con el mysql
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * variable que indica la ubicacion de la base de datos
     */
    private static final String URL = "jdbc:mysql://localhost/estudiantes";
    /**
     * variable del usuario de la base de datos
     */
    private static final String USER = "participantes";
    /**
     * variable que contiene la contraseña de la base de datos
     */
    private static final String PASSWD = "binylau";

    /**
     * Metodo que agrga datos a la base de datos MYSQL
     * @param student   Objeto de tipo estudiante con la informacion que se desea agregar a la base de datos
     */
    @Override
    public void addStudent(Student student) {
        try {
            //System.out.println("aqui estamos");
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();
            //System.out.println("aqui estamos 2");
            String code = student.getCode();
            String surName = student.getSurname();
            String name = student.getName();
            String edad = student.getEdad();
            String modo = student.getModo();
            String disciplina = student.getDisciplina();
            String evento = student.getEvento();
            String posicion = student.getPosicion();
            //System.out.println(student.getCode());
            //JOptionPane.showMessageDialog(null,code+" "+surName);


            final String query = "INSERT INTO parcticipants VALUES(" + "'" + code + "','" + name + "','" + surName + "','" + edad + "','" + disciplina + "','" + modo+ "','" + evento + "','" + posicion + "')";

            System.out.println(query);

            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Metodo para modificar un objeto ya existente en la base de datos
     * @param student objeto que se desea modificar en la base de datos MYSQL
     */
    @Override
    public void updateStudent(Student student) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD)) {
            Statement statement = connection.createStatement();
            String id = student.getCode();
            //falta revisar bien esta sintasix
            final String query = "UPDATE parcticipants SET nombre = student.getName() WHERE code= student.getCode";
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar datos de la base de datos MYSQL
     * @param code identificador o key conla que se reconoce el elemento a eliminar
     */
    @Override
    public void delete(String code) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();
            System.out.println("lo que llega: "+code);
            String query = "DELETE from parcticipants WHERE parcticipants . code=" + "'" + code + "'  ";
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Metodo para buscar un usuario con la key por la que se identifique
     * @param code Key con la que se hace referencia al elemton a buscar
     * @return en caso de encontrar el elmento retorna el objeto en caso contrario retorna null
     */
    @Override
    public Student findByCode(String code) {
        if (getAllStudents()!= null){
            for (Student st: getAllStudents()) {
                if (st.getCode().equals(code)){
                    return st;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Student> participants = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("select * from parcticipants")
        ) {

            while (result.next()) {
                String code = result.getString("code");
                String surName = result.getString("surname");
                String name = result.getString("nombre");
                String edad = result.getString("edad");
                String modo = result.getString("mode");
                String disciplina = result.getString("discipline");
                String evento = result.getString("evento");
                String posicion = result.getString("position");

                Student participant = new Student(code, surName, name, edad, modo, disciplina, evento, posicion );
                participants.add(participant);
            }
            return participants;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    @Override
    public void close() throws Exception {

    }
}
