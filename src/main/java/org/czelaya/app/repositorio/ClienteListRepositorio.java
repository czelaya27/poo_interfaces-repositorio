package org.czelaya.app.repositorio;

import org.czelaya.app.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {

    private final List<Cliente> clientes;

    public ClienteListRepositorio() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public List<Cliente> findAll() {
        return this.clientes;
    }

    @Override
    public Cliente findById(Integer id) {
        Cliente resultado = null;
        for (Cliente c : clientes) {
            if (c.getId() != null && c.getId().equals(id)) {
                resultado = c;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void save(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        Cliente c = this.findById(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            this.clientes.remove(cliente);
        }
    }

    @Override
    public List<Cliente> findAll(String campo, Orden orden) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.clientes);
        listaOrdenada.sort((Cliente a, Cliente b) -> {
                    int resultado = 0;
                    if (orden == Orden.ASC) {
                        resultado = ordenar(campo, a, b);
                    } else if (orden == Orden.DESC) {
                        resultado = ordenar(campo, b, a);
                    }
                    return resultado;
                }
        );
        return listaOrdenada;
    }

    @Override
    public List<Cliente> findAll(int page, int limit) {
        return clientes.subList(page * limit, Math.min(page * limit + limit, clientes.size()));
    }

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int totalRegistros() {
        return this.clientes.size();
    }
}
