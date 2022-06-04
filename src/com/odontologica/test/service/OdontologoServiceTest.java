package com.odontologica.test.service;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.impl.OdontologoDao;
import com.odontologica.main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {


    private OdontologoService odontologoService = new OdontologoService();



    @Test
    public void _01_deberíaConsultarExitosamenteTodosLosOdontologosDeLaBaseDeDatos(){
        //DADOS

        //CUANDO
       Collection<Odontologo> resultado = odontologoService.buscarTodos();


        //ENTONCES
        Assertions.assertTrue(resultado.size() > 0);


    }



}