package com.odontologica.Test.service;

import com.odontologica.main.persistence.dao.impl.OdontologoDAOH2;
import com.odontologica.main.Model.Odontologo;
import com.odontologica.main.Service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OdontologoServiceTest {

        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OdontologoServiceTest.class);

        OdontologoService odontologoService = new OdontologoService();  // Instancio OdontologoService

    @Test
    void guardaOdontologoEnBaseDatos() {

        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

       Odontologo odontologo = new Odontologo(); //Instancio Odontologo

        odontologo.setNombre("Hector");
        odontologo.setApellido("moreno");
        odontologo.setNumeroMatricula("79904519");
        odontologoService.guardaOdontologoService(odontologo); // le paso por parametro la informacion creada en el objeto odontologo

    }

    @Test
    void eliminarOdontologoPorID() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()
        odontologoService.eliminar(16L);
    }




    @Test
    void buscarOdontoPorID() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()
        odontologoService.buscarOdontologoService(17);
    }

    @Test
    public void _01_deberíaConsultarExitosamenteTodosLosOdontologosDeLaBaseDeDatos(){

        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()
        List<Odontologo> resultado = odontologoService.listarTodosServices();

        Assertions.assertTrue(resultado.size() > 0);


    }


    @Test
    void ListarTodosOdontologos() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

           int ListarTodo = odontologoService.listarTodosServices().size();

            for (int i=0; i< ListarTodo; i++) {
                Odontologo registros = odontologoService.listarTodosServices().get(i);
            }

    }



}



