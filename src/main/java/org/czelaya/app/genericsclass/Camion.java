package org.czelaya.app.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{
    private final List<T> objetos;
    private final int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();    }

    public void add (T object){
        if (this.objetos.size() <= this.max) {
            this.objetos.add(object);
        } else {
            throw new RuntimeException("No hay espacio en el camion");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
