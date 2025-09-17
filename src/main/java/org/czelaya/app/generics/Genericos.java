package org.czelaya.app.generics;

import org.czelaya.app.modelo.Cliente;
import org.czelaya.app.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Genericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cristian", "Zelaya"));
        clientes.add(new Cliente("Juan", "Perez"));
        clientes.add(new Cliente("Stefhani", "Lopez"));

        imprimir(clientes);
        System.out.println("---------------------------");
        Cliente[] nombres = {new Cliente("Cristian", "Zelaya"), new Cliente("Stefhani", "Lopez")};
        List<Cliente> listaCliente = fromArrayToList(nombres);
        imprimir(listaCliente);
        Integer[] numeros = {1, 2, 3, 4, 5};
        List<Number> listaNumeros = fromArrayToList(numeros);
        imprimir(listaNumeros);

        List<String> listaClientes = fromArrayToList(new String[]{"Cristian", "Stefhani"}, new String[]{"Zelaya", "Lopez"});
        imprimir(listaClientes);

        List<ClientePremium> premium = fromArrayToList(new ClientePremium[]{new ClientePremium("Cristian", "Zelaya")});
        imprimir(premium);

        System.out.println(maximo(8, 20, 3));
    }

    public static <T> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public  static <T, G> List<T> fromArrayToList(T[] array, G[] generico) {
        for(G elemento: generico){
            System.out.println(elemento);
        }
        return Arrays.asList(array);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public static <T> void imprimir(List<T> lista) {
        lista.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
