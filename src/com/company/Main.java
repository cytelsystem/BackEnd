package com.company;

import com.company.daos.EstudianteDaoH2;
import com.company.entidades.Estudiante;
import com.company.servicios.EstudianteService;

public class Main {

    public static void main(String[] args) {

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
//



//        EstudianteService estudianteService = new EstudianteService();
//        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
//        estudianteService.eliminarEstudiante(1L);

        EstudianteService estudianteService = new EstudianteService();
        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
        estudianteService.buscarEstudiante(1L);

    }
}
