package org.czelaya.app.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> findAll(String campo, Orden orden);
}
