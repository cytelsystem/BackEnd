package com.odontologica.main.service;


import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;

import java.util.List;

public class OdontologoService {


    private Dao<Odontologo> odontologoIDao;  // instanciarlo

//    public OdontologoService(Dao<Odontologo> odontologoDao) {  // constructor
//
//        this.odontologoIDao = odontologoDao;
//    }

    //*******************getter y setter***********************************//
    public Dao<Odontologo> getOdontologoDao() {
        return odontologoIDao;
    }

    public void setOdontologoDao(Dao<Odontologo> odontologoDao) {
        this.odontologoIDao = odontologoDao;
    }
    //*************************medotos*********************************************//

    public Odontologo guardarOdontologo(Odontologo e) {
        return odontologoIDao.crear(e);

    }

    public void eliminarOdontologo(int id) {

        odontologoIDao.eliminar(id);
    }

    public Odontologo buscarOdontologo(int id) {

        return odontologoIDao.consultarPorId(id);
    }

    public List<Odontologo> buscarTodos() {

        return odontologoIDao.consultarTodos();
    }




    //**********************************************************************//
}
