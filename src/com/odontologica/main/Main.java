package com.odontologica.main;

import com.odontologica.main.Model.Odontologo;
import com.odontologica.main.persistence.dao.impl.OdontologoDAOH2;
import com.odontologica.main.Service.OdontologoService;


public class Main {

    public static void main(String[] args) {



        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Main.class);

        OdontologoService odontologoService = new OdontologoService();  // Instancio OdontologoService
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

        //********************************Crear un nuevo objeto (Registro) Odontologo**************************************************************//


//        Odontologo odontologo = new Odontologo(); //Instancio Odontologo
//
//        odontologo.setNombre("Adela");
//        odontologo.setApellido("Sanchez");
//        odontologo.setNumeroMatricula("9024215");
//        odontologoService.guardaOdontologoService(odontologo); // le paso por parametro la informacion creada en el objeto odontologo

        //****************Consultar Todos los registro de la base de datos tabla Odontologo*********************************************************//

        // Debe existir un metodo toString en el Odontologo

//            int ListarTodo = odontologoService.listarTodosServices().size();
//
//            for (int i=0; i< ListarTodo; i++) {
//                Odontologo registros = odontologoService.listarTodosServices().get(i);
//                logger.info(registros);
//            }

        //***************************************Consultar por un Solo ID tabla Odontologo***********************************************************//

//        logger.info(odontologoService.buscarOdontologoService(25));

        //****************************************Eliminar Registro por ID tabla Odontologo********************************************************//
//         odontologoService.eliminar(27L);

        //*****************************************************************************************************************************************//


    }
}
