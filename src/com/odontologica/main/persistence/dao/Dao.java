package com.odontologica.main.persistence.dao;

import java.util.List;

public interface Dao<T> {


    public T crear(T t);
    public T eliminar(int id);
    public T consultarPorId(int id);
    public List<T> consultarTodos();
}
