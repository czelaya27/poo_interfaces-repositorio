package org.czelaya.app;

import org.czelaya.app.modelo.Cliente;
import org.czelaya.app.repositorio.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio repositorio = new ClienteListRepositorio();
        repositorio.save(new Cliente("Juan", "Perez"));
        repositorio.save(new Cliente("Stefhani", "Lopez"));
        repositorio.save(new Cliente("Cristian", "Zelaya"));
        repositorio.findAll().forEach(System.out::println);

        System.out.println("---------------------------");
        // paginable
        List<Cliente> paginable = repositorio.findAll(0, 2);
        paginable.forEach(System.out::println);

        System.out.println("-------- Ordenar ASC ----------");
        List<Cliente> ordenAsc = repositorio.findAll("nombre", Orden.ASC);
        ordenAsc.forEach(System.out::println);

        System.out.println("-------- Ordenar DESC ----------");
        List<Cliente> ordenDesc = repositorio.findAll("nombre", Orden.DESC);
        ordenDesc.forEach(System.out::println);

        System.out.println("---------- Editar -------------");
        Cliente cristianActualizar = new Cliente("Cristian", "Ventura");
        cristianActualizar.setId(3);
        repositorio.update(cristianActualizar);
        Cliente cristian = repositorio.findById(3);
        System.out.println(cristian);

        System.out.println("---------- Eliminar -------------");
        repositorio.delete(3);
        repositorio.findAll().forEach(System.out::println);
        System.out.println("---------------------------");
        System.out.println("Total: " + repositorio.totalRegistros());
    }
}