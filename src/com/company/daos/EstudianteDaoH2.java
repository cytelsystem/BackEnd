package com.company.daos;

import org.apache.log4j.Logger;

import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2<T> implements IDao<Estudiante> {
    private static final Logger logger = Logger.getLogger(EstudianteDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/Estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Estudiante guardar(Estudiante estudiante) {

        Connection connetion = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connetion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connetion.prepareStatement("INSERT INTO estudiantes VALUES(?,?,?)");

            preparedStatement.setLong(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            logger.error("No se puede establecer la conexion");
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            logger.info("Driver Funcionando");
        }

        return estudiante;

    }



    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            logger.error("No se puede establecer la conexion");
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            logger.info("Driver Funcionando");
        }


    }

    @Override
    public Estudiante buscar(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Estudiante estudiante = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes where id=?");

            preparedStatement.setLong(1, id);

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()){
                Long IdEstudiante = resultado.getLong("id");
                String nombreEstudiante = resultado.getString("nombre");
                String apellidoEstudiante = resultado.getString("nombre");

                System.out.println(IdEstudiante + nombreEstudiante + apellidoEstudiante);

                estudiante = new Estudiante();
                estudiante.setId(IdEstudiante);
                estudiante.setNombre(nombreEstudiante);
                estudiante.setApellido(apellidoEstudiante);

            }

            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            logger.info("Driver Funcionando");
        }




        return estudiante;

    }

    @Override
    public List<Estudiante> BuscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Estudiante> estudiantes = new ArrayList();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement  = connection.prepareStatement("SELECT * FROM estudiantes");


            ResultSet resultado =  preparedStatement.executeQuery();

            while(resultado.next()){
                Long IdEstudiante = resultado.getLong("id");
                String nombreEstudiante = resultado.getString("nombre");
                String apellidoEstudiante = resultado.getString("nombre");



                Estudiante estudiante = new Estudiante();
                estudiante.setId(IdEstudiante);
                estudiante.setNombre(nombreEstudiante);
                estudiante.setApellido(apellidoEstudiante);

                estudiantes.add(estudiante);

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            logger.info("Driver Funcionando");
        }

        return estudiantes;


    }
}
