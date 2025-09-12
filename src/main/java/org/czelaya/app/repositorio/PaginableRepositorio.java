package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> findAll(int page, int limit);
}
