package org.czelaya.app.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> findAll(int page, int limit);
}
