package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

// aquí van las que se pueden reutilizar
public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected final List<T> clientes;

    public AbstractaListRepositorio() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        return this.clientes;
    }

    @Override
    public T findById(Integer id) {
        T resultado = null;
        for (T c : clientes) {
            if (c.getId() != null && c.getId().equals(id)) {
                resultado = c;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void save(T cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public void delete(Integer id) {
        T cliente = findById(id);
        if (cliente != null) {
            this.clientes.remove(cliente);
        }
    }

    @Override
    public List<T> findAll(int page, int limit) {
        return clientes.subList(page * limit, Math.min(page * limit + limit, clientes.size()));
    }

    @Override
    public int totalRegistros() {
        return this.clientes.size();
    }
}
