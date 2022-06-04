package DAO;

import DAO.util.ConfiguracionJDBC;
import Model.Odontologo;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDAO<Odontologo> {

    private Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into odontologos (Nombre, Apellido, NumeroMatricula) VALUES (?,?,?)");


            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNumeroMatricula());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (SQLException e) {
            logger.info("problemas con el stamwent");
            e.printStackTrace();
        } finally {
            logger.info("Conexion Crear y preparedStatement OK");
        }

        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Odontologo odontologo = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                int idOdontologo = resultado.getInt("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");


                odontologo = new Odontologo();

                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setNumeroMatricula(NumeroMatriculaOdontologo);

            }

            preparedStatement.executeQuery();
            preparedStatement.close();

        }catch (SQLException e) {
            logger.info("problemas con el stamwent");
            e.printStackTrace();
        } finally {
            logger.info("Conexion Crear y preparedStatement OK");
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos");



            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                int idOdontologo = resultado.getInt("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");


                Odontologo odontologo = new Odontologo();



                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setNumeroMatricula(NumeroMatriculaOdontologo);

                odontologos.add(odontologo);

            }





            preparedStatement.executeQuery();
            preparedStatement.close();

        }catch (SQLException e) {
            logger.info("problemas con el stamwent");
            e.printStackTrace();
        } finally {
            logger.info("Conexion Crear y preparedStatement OK");
        }

        return odontologos;
    }
}