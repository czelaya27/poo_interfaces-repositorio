package org.czelaya.app.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T cliente);

    void update(T cliente);

    void delete(Integer id);
}
