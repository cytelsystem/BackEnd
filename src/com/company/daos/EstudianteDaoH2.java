package com.company.daos;

import com.company.daos.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2<T> implements IDao<Estudiante> {
    private static final Logger logger = Logger.getLogger(EstudianteDaoH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Estudiantes", "sa", "" );  // instanciar

    @Override
    public Estudiante guardar(Estudiante estudiante) {

        // jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT INTO estudiantes VALUES(?,?,?)"); // estament



            preparedStatement.setLong(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            logger.info("Conexion y statement OK");
        }

        return estudiante;

    }



    @Override
    public void eliminar(Long id) {

        // jdbc.cargarElControlador();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            logger.info("Conexion y statement OK");
        }


    }

    @Override
    public Estudiante buscar(Long id) {

        // jdbc.cargarElControlador();


        PreparedStatement preparedStatement = null;

        Estudiante estudiante = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM estudiantes where id=?");

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


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            logger.info("Conexion buscar porID OK");
        }


        return estudiante;

    }

    @Override
    public List<Estudiante> BuscarTodos() {

        // jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Estudiante> estudiantes = new ArrayList();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement  = connetion.prepareStatement("SELECT * FROM estudiantes");


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


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            logger.info("Conexion y statement BuscarTodos OK");
        }

        System.out.println(estudiantes.get(1));

        return estudiantes;


    }
}
