package com.odontologica.main.service;


import com.odontologica.main.model.Domicilio;
import com.odontologica.main.model.Odontologo;
import com.odontologica.main.model.Paciente;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.impl.OdontologoDao;

import java.util.List;

public class OdontologoService {


    private Dao<Odontologo> odontologoIDao;  // instanciarlo

    public OdontologoService(Dao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public OdontologoService() {

    }

    //*******************getter y setter***********************************//

    public Dao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(Dao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
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

        List<Odontologo> odontologo = odontologoIDao.consultarTodos();

//        for(Odontologo p : odontologo){
//            Domicilio d = domicilioDao.consultarPorId(p.getDomicilio().getId());
//            p.setDomicilio(d);
//        }


        return odontologo;
        // return odontologoIDao.consultarTodos();
    }




    //**********************************************************************//
}
