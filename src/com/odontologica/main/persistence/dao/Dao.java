package com.odontologica.main.persistence.dao;

import java.util.List;

public interface Dao<T> {

//    public T guardar(T t);
//    public void eliminar(Long id);
//    public T buscarPorId(int id);
//    public List<T> buscarTodos();

    public T crear(T t);
    public void eliminar(Long id);
    public T consultarPorId(int id);
    public List<T> consultarTodos();


}
