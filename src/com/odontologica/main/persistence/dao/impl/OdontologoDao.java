package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDao<T> implements Dao<Odontologo> {
    //******************************Crear**************************************//

    private Logger logger = Logger.getLogger(OdontologoDao.class);

    //ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "" );  // instanc
    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Odontologo crear(Odontologo odontologo) {

        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into odontologos (Nombre, Apellido, NumeroMatricula) VALUES (?,?,?)");


            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNumeroMatricula());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            logger.info("problemas con el stamwent");
            e.printStackTrace();
        } finally {
            logger.info("Conexion Crear y preparedStatement OK");
        }

        return odontologo;

    }


    //****************************************************************************//


    @Override
    public Odontologo eliminar(int id) {
        return null;
    }

    @Override
    public Odontologo consultarPorId(int id) {
        return null;
    }

    //******************************Todos***********************************//
    @Override
    public List<Odontologo> consultarTodos() {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList();

        try (Connection con = jdbc.conectarConBaseDeDatos()) {

            preparedStatement  = con.prepareStatement("SELECT * FROM odontologos ");


            ResultSet resultado =  preparedStatement.executeQuery();

            while(resultado.next()){
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String MatriculaOdontologo = resultado.getString("NumeroMatricula");



                Odontologo odontologo = new Odontologo();
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setNumeroMatricula(MatriculaOdontologo);

                odontologos.add(odontologo);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            logger.info("Conexion y statement BuscarTodos OK");
        }

        System.out.println(odontologos.get(1).toString());


        return odontologos;



    }
    //****************************************************************************//
}
