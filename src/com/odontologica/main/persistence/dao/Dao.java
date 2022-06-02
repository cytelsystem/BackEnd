package com.odontologica.main.persistence.dao;

import java.util.List;

public interface Dao<T> {
    List<T> consultarTodos();

    T consultarPorId(int id);

    T crear(T entidad);
}
