package com.example.proyectojee.logic;

/**
 * clase modelo
 */
public class Student {
    private String code;
    private String surname;
    private String name;
    private String edad;
    private String modo;
    private String disciplina;
    private String evento;
    private String posicion;

    /**
     * constructor de la clase
     * @param code String
     * @param surname  String
     * @param name  String
     * @param edad  String
     * @param modo String
     * @param disciplina String
     * @param evento String
     * @param posicion String
     */

    public Student(String code, String surname, String name, String edad, String modo, String disciplina, String evento, String posicion) {
        this.code = code;
        this.surname = surname;
        this.name = name;
        this.edad = edad;
        this.modo = modo;
        this.disciplina = disciplina;
        this.evento = evento;
        this.posicion = posicion;
    }

    /**
     * metodo que devuelve el codigo
     * @return String con el codigo
     */
    public String getCode() {
        return code;
    }

    /**
     * metodo que ingresa el codigo
     * @param code String que se desea ingresar
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Metodo que obtiene el appellido
     * @return String con el apellido
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Metodo que ingresa el apellido
     * @param surname String que se dea ingresar
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Metodo que obtine el nombre del estudiante
     * @return String con el nombre del estudiante
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que ingresa el nombre del estudiante
     * @param name String con lo que se desea guardar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que obtiene la edad del estudiante
     * @return  String con el nombre del estudiante
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Metodo que ingresa la edad del estudainte
     * @param edad
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * metodo que obtiene la modalidad de la competicion
     * @return  String con la modalidad
     */
    public String getModo() {
        return modo;
    }

    /**
     * Metodo que ingresa la modalidad
     * @param modo  String con la modalidad que se desea ingresar
     */
    public void setModo(String modo) {
        this.modo = modo;
    }

    /**
     * Metodo que obtiene la disciplina del estudiante
     * @return  String con la disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * Metodo ingresa la disciplina del estudiante
     * @param disciplina String con la informacion que se desea ingresar
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Metodo que obtiene el evento
     * @return String con el evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * Metodo que ingreas el evento
     * @param evento String con el evento que se desea ingresar
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * metodo que obtiene la posicion del estudiante
     * @return String con la  posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * Metodo que ingresa la posicion
     * @param posicion String con informacion de la posicion
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * metodo toString
     * @return todos los datos del estudiante
     */
    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", edad='" + edad + '\'' +
                ", modo='" + modo + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", Evento='" + evento + '\'' +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
