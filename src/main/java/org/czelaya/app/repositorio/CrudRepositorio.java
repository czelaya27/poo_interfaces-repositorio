package org.czelaya.app.repositorio;

import org.czelaya.app.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> findAll();

    T findById(Integer id) throws AccesoDatoException;

    void save(T cliente) throws AccesoDatoException;

    void update(T cliente) throws AccesoDatoException;

    void delete(Integer id) throws AccesoDatoException;
}
