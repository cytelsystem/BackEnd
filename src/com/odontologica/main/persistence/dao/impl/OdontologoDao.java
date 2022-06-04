package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OdontologoDao<T> implements Dao<Odontologo> {
    //****************************************************************************//

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

    @Override
    public List<Odontologo> consultarTodos() {
        return null;
    }
}
