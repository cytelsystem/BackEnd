package DAO;

import java.util.List;

public interface IDAO<T> {

    public T guardar(T t);
    public void eliminar(Long id);
    public T buscarPorId(int id);
    public List<T> buscarTodos();


}
