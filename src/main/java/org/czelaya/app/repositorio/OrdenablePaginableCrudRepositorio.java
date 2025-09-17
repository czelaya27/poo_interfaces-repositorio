package org.czelaya.app.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio{
}
