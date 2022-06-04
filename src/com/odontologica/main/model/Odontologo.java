package com.odontologica.main.model;

import com.odontologica.main.persistence.dao.Dao;

public class Odontologo {


    private String nombre;
    private String apellido;
    private String numeroMatricula;


    public Odontologo() {

    }

    public Odontologo(String nombre, String apellido, String numeroMatricula) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumeroMatricula(numeroMatricula);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
