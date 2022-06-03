package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Domicilio;
import com.odontologica.main.model.Paciente;
import com.odontologica.main.persistence.dao.Dao;

import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements Dao<Paciente> {

    private Logger logger = Logger.getLogger(PacienteDao.class);

    private ConfiguracionJDBC jdbc = new ConfiguracionJDBC();



    @Override
    public List<Paciente> consultarTodos() {


        List<Paciente> resultado = new ArrayList<>();

        //[1a] Cargar el controlador
        jdbc.cargarElControlador();

        //[1b]
        //[2] Crear el statement
        try(Connection conn = jdbc.conectarConBaseDeDatos(); Statement stmt = conn.createStatement()){

            //[3] Ejecutamos el statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes");

            //[4] Procesar el ResultSet
            while(rs.next()){
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));

                Domicilio d = new Domicilio(rs.getInt("id_domicilio"), null);
                p.setDomicilio(d);

                resultado.add(p);
            }

        } catch (SQLException ex) {
            logger.error("Ha ocurrido en error al consultar los pacientes." + ex.getMessage());
        }

        //[5] Retornar el resultado de la búsqueda
        return resultado;
    }

    @Override
    public Paciente consultarPorId(int id) {


        // jdbc.cargarElControlador();


        PreparedStatement preparedStatement = null;

        Paciente paciente = null;

        try (Connection con = jdbc.conectarConBaseDeDatos(); PreparedStatement stmt=con.prepareStatement("SELECT * FROM pacientes where id=?")) {



            //preparedStatement = con.prepareStatement("SELECT * FROM pacientes where id=?");

            stmt.setLong(1, id);

            ResultSet resultado = stmt.executeQuery();

            while(resultado.next()){
                int IdPaciente = resultado.getInt("id");
                String nombrePaciente = resultado.getString("nombre");
                String apellidoPaciente = resultado.getString("apellido");
                String dniPaciente = resultado.getString("dni");
                String fechaIngresoPaciente = resultado.getString("fecha_ingreso");


                System.out.println(IdPaciente + nombrePaciente + apellidoPaciente + dniPaciente + fechaIngresoPaciente);

                paciente = new Paciente();
                paciente.setId(IdPaciente);
                paciente.setNombre(nombrePaciente);
                paciente.setApellido(apellidoPaciente);
                paciente.setDni(dniPaciente);
                paciente.setFecha_ingreso(fechaIngresoPaciente);


            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return paciente;


    }

    @Override
    public Paciente crear(Paciente entidad) {
        return null;
    }
}
