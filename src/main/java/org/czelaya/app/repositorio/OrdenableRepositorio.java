package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> findAll(String campo, Orden orden);
}
