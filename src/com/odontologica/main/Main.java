package com.odontologica.main;

import com.odontologica.main.model.Domicilio;
import com.odontologica.main.model.Odontologo;
import com.odontologica.main.model.Paciente;
import com.odontologica.main.persistence.dao.impl.OdontologoDao;
import com.odontologica.main.service.OdontologoService;
import com.odontologica.main.service.PacienteService;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.impl.DomicilioDao;
import com.odontologica.main.persistence.dao.impl.PacienteDao;

public class Main {
    public static void main(String[] args) {

//***********************************Crear un nuevo registro Odontologo************************************************//
//        Odontologo odontologo = new Odontologo();
//        odontologo.setNombre("ivonne");
//        odontologo.setApellido("perez");
//        odontologo.setNumeroMatricula("m5087");
//
//        OdontologoService odontologoService = new OdontologoService();
//        odontologoService.setOdontologoDao(new OdontologoDao());
//
//
//        odontologoService.guardarOdontologo(odontologo);

//***********************************Buscar Todos************************************************//
//          OdontologoService odontologoService = new OdontologoService();
//          odontologoService.setOdontologoIDao(new OdontologoDao());
//          odontologoService.buscarTodos();

//***********************************************************************************************//


//***********************************Crear un nuevo registro************************************************//
//        Estudiante estudiante = new Estudiante();
//        estudiante.setId(1L);
//        estudiante.setNombre("Hector javier");
//        estudiante.setApellido("moreno");
//
//        EstudianteService estudianteService = new EstudianteService();
//        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
//
//
//        Estudiante estudiante2 = new Estudiante();
//        estudiante2.setId(2L);
//        estudiante2.setNombre("Ivonne Astrid");
//        estudiante2.setApellido("Perez");
//
//
//
//        estudianteService.guardarEstudiante(estudiante);
//        estudianteService.guardarEstudiante(estudiante2);




//***********************************Eliminar************************************************//
//        EstudianteService estudianteService = new EstudianteService();
//        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
//        estudianteService.eliminarEstudiante(1L);


//***********************************Buscar por ID Paciente************************************************//
//        PacienteService pacienteService = new PacienteService();
//        pacienteService.setPacienteDao(new PacienteDao());
//        pacienteService.buscarPaciente(1);
//
//***********************************Buscar por ID Odontologo************************************************//
//        PacienteService pacienteService = new PacienteService();
//        pacienteService.setPacienteDao(new PacienteDao());
//        pacienteService.buscarPaciente(1);


//***********************************Buscar Todos************************************************//
//        EstudianteService estudianteService = new EstudianteService();
//        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
//        estudianteService.buscarTodos();
//***********************************************************************************************//


    }
}