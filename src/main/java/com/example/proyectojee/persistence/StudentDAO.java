package com.example.proyectojee.persistence;
import com.example.proyectojee.logic.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase interface donde se almacenan todos los metodos necesarios para crear el Crud
 */
public interface StudentDAO extends java.lang.AutoCloseable{
    /**
     * Metodo para agregar un estudite
     * @param student objeto con toda la informacion que se desea agregar
     */
    void addStudent(Student student);

    /**
     * Metodo para modificar un objeto ya creado en la base de datos MYSQL
     * @param student objeto que se desea actualizar en la base de datos
     */
    void updateStudent(Student student);

    /**
     * Metodo que elimina un objeto de la base de datos MYSQL
     * @param code key con la que se identifica el elemto a eliminar en la base de datos
     */
    void delete( String code);

    /**
     * Metodo que busca un elemento de la base de datos mediante la key
     * @param code key del elemento que se desea buscar
     * @return retorna el objeto al que hace referencia
     */
    Student findByCode(String code);

    /**
     * Metodo que obtine todos los datos de la base de datos
     * @return  un ArrayList con todos los elemntos de la base de datos
     */
    ArrayList<Student> getAllStudents();
}
