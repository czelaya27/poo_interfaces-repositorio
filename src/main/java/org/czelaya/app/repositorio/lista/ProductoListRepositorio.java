package org.czelaya.app.repositorio.lista;

import org.czelaya.app.modelo.Producto;
import org.czelaya.app.repositorio.AbstractaListRepositorio;
import org.czelaya.app.repositorio.Orden;
import org.czelaya.app.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void update(Producto producto) throws LecturaAccesoDatoException {
        Producto p = this.findById(producto.getId());
        p.setNombre(producto.getNombre());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> findAll(String campo, Orden orden) {
        List<Producto> listaOrdenada = new ArrayList<>(this.clientes);
        listaOrdenada.sort((Producto a, Producto b) -> {
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

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
