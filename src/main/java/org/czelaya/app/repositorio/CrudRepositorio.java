package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> findAll();

    Cliente findById(Integer id);

    void save(Cliente cliente);

    void update(Cliente cliente);

    void delete(Integer id);
}
