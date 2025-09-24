package org.czelaya.app;

import org.czelaya.app.modelo.Cliente;
import org.czelaya.app.repositorio.*;
import org.czelaya.app.repositorio.excepciones.*;
import org.czelaya.app.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) throws AccesoDatoException {
        try {
            OrdenablePaginableCrudRepositorio<Cliente> repositorio = new ClienteListRepositorio();
            repositorio.save(new Cliente("Juan", "Perez"));
            repositorio.save(new Cliente("Stefhani", "Lopez"));
            repositorio.save(new Cliente("Cristian", "Zelaya"));
            Cliente cliente = new Cliente("Cristian", "Zelaya");
            repositorio.save(cliente);
            repositorio.save(cliente);
            //repositorio.save(null);
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
            repositorio.delete(1);
            repositorio.delete(3);
            repositorio.findAll().forEach(System.out::println);
            System.out.println("---------------------------");
            System.out.println("Total: " + repositorio.totalRegistros());
        } catch (LecturaAccesoDatoException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (RegistroDuplicadoDatoException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
            e.printStackTrace(System.out);
        }catch (EscrituraAccesoDatoException e) {
            System.out.println("Error al escribir datos: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoException e) {
            System.out.println("Generica -> Error al acceder a datos: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}