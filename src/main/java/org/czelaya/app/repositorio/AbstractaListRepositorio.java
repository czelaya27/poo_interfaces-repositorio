package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.BaseEntity;
import org.czelaya.app.repositorio.excepciones.*;

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
    public T findById(Integer id) throws LecturaAccesoDatoException{
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("Id invalido debe de ser mayo a 0");
        }
        T resultado = null;
        for (T c : clientes) {
            if (c.getId() != null && c.getId().equals(id)) {
                resultado = c;
                break;
            }
        }
        if (resultado == null) {
            throw new LecturaAccesoDatoException("No se encontro el cliente con id: " + id);
        }
        return resultado;
    }

    @Override
    public void save(T cliente) throws EscrituraAccesoDatoException {
        if (cliente == null) {
            throw new EscrituraAccesoDatoException("Error al insertar un objecto null");
        }
        if(this.clientes.contains(cliente)){
            throw new RegistroDuplicadoDatoException("Ya existe un cliente con el id: " + cliente.getId());
        }
        this.clientes.add(cliente);
    }

    @Override
    public void delete(Integer id) throws LecturaAccesoDatoException {
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
