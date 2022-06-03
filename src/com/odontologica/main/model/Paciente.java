package com.odontologica.main.model;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha_ingreso;
    private Domicilio domicilio;

    public Paciente(){

    }

    public Paciente(int id, String nombre, String apellido, String dni, String fecha_ingreso, Domicilio domicilio) {
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.dni = dni;
        this.fecha_ingreso = fecha_ingreso;
        this.domicilio = domicilio;
    }

    //    public Paciente(int id, String apellido, String nombre) {
//        this.setId(id);
//        this.setApellido(apellido);
//        this.setNombre(nombre);
//    }

    //************************************seter y geter**************************************//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    //**********************************************************************************************//

}
