package com.odontologica.main.Service;

import com.odontologica.main.persistence.dao.IDAO;
import com.odontologica.main.Model.Odontologo;
import java.util.List;

public class OdontologoService {

    private IDAO<Odontologo> odontologoIDAO; // comunicacion con la interface

    //******************************Getter***************************************//
    public IDAO<Odontologo> getOdontologoIDAO() {

        return odontologoIDAO;
    }
    //******************************Setter***********************************************//


    public void setOdontologoIDAO(IDAO<Odontologo> odontologoIDAO) {

        this.odontologoIDAO = odontologoIDAO;
    }

    //*****************************Metodos************************************************//

    public  Odontologo guardaOdontologoService(Odontologo o) {

        return odontologoIDAO.guardar(o);
    }



    public void eliminar(Long id) {
        odontologoIDAO.eliminar(id);
    }

    public  Odontologo buscarOdontologoService(int id) {

        return odontologoIDAO.buscarPorId(id);
    }

    public List<Odontologo> listarTodosServices() {

        return odontologoIDAO.buscarTodos();


    }

    //********************************************************************************//


}
