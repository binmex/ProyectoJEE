package com.example.proyectojee.persistence;

/**
 * Calse que funviona como puente entre el servlet y la persistencia
 */
public class StudentDAOFactoty {
    /**
     * Contructor de la clase
     * @return un objeto de tipo StudentDAOImpl
     */
    public StudentDAO createStudentDAO() {
        return new StudentDAOImpl();
    }

}