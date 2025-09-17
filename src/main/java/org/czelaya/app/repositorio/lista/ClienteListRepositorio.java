package org.czelaya.app.repositorio.lista;

import org.czelaya.app.modelo.Cliente;
import org.czelaya.app.repositorio.AbstractaListRepositorio;
import org.czelaya.app.repositorio.Orden;

import java.util.ArrayList;
import java.util.List;

// aquí van las propias las que no se pueden reutilizar
public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void update(Cliente cliente) {
        Cliente c = this.findById(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
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

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
