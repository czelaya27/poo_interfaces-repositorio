package org.czelaya.app;

import org.czelaya.app.modelo.Producto;
import org.czelaya.app.repositorio.Orden;
import org.czelaya.app.repositorio.OrdenablePaginableCrudRepositorio;
import org.czelaya.app.repositorio.excepciones.AccesoDatoException;
import org.czelaya.app.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) throws AccesoDatoException {
        System.out.println("Ejemplo de uso de repositorio de productos");

        OrdenablePaginableCrudRepositorio<Producto> repositorio = new ProductoListRepositorio();
        repositorio.save(new Producto("PC", "Lenovo", 2500));
        repositorio.save(new Producto("Tablet", "Apple", 1500));
        repositorio.save(new Producto("Smartphone", "Samsung", 1000));

        repositorio.findAll().forEach(System.out::println);

        System.out.println("--------------- Orden ASC --------------------");
        List<Producto> ordenAsc = repositorio.findAll("nombre", Orden.ASC);
        ordenAsc.forEach(System.out::println);

        System.out.println("--------------- Orden DESC --------------------");
        List<Producto> ordenDesc = repositorio.findAll("nombre", Orden.DESC);
        ordenDesc.forEach(System.out::println);

        System.out.println("--------------- PAGINACION --------------------");
        List<Producto> paginable = repositorio.findAll(0, 3);
        paginable.forEach(System.out::println);

        System.out.println("--------------- TOTAL DE REGISTROS --------------------");
        System.out.println(repositorio.totalRegistros());

        System.out.println("--------------- ELIMINAR --------------------");
        repositorio.delete(2);
        repositorio.findAll().forEach(System.out::println);

        System.out.println("--------------- TOTAL DE REGISTROS --------------------");
        System.out.println(repositorio.totalRegistros());

        System.out.println("--------------- EDITAR --------------------");
        Producto productoActualizar = new Producto("PC", "HP", 2500);
        productoActualizar.setId(1);
        repositorio.update(productoActualizar);
        Producto producto = repositorio.findById(1);
        System.out.println(producto);
    }
}
