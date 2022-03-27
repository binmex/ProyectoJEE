package com.example.proyectojee.logic;

public class Student {
    private String code;
    private String surname;
    private String name;
    private String edad;
    private String modo;
    private String disciplina;
    private String evento;
    private String posicion;

    public Student() {
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        evento = evento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

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
