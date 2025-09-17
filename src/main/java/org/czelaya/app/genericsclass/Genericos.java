package org.czelaya.app.genericsclass;

public class Genericos {
    public static void main(String[] args) {
        Camion<Animal> transporte = new Camion<>(5);
        transporte.add(new Animal("Cisne"));
        transporte.add(new Animal("Gato"));
        transporte.add(new Animal("Perro"));
        transporte.add(new Animal("Tigre"));

        imprimir(transporte);

        Camion<Maquinaria> transMaquiaria = new Camion<>(2);

        transMaquiaria.add(new Maquinaria("Cuchillo"));
        transMaquiaria.add(new Maquinaria("Lavadora"));
        transMaquiaria.add(new Maquinaria("Lavadora"));

       imprimir(transMaquiaria);

        Camion<Automovil> transAuto = new Camion<>(2);
        transAuto.add(new Automovil("Ford"));
        transAuto.add(new Automovil("Chevrolet"));


        imprimir(transAuto);
    }

    public static <T> void imprimir(Camion<T> transporte) {
        for (T a : transporte) {
            if(a instanceof Automovil) {
                Automovil auto = (Automovil) a;
                System.out.println(auto.getMarca());
            } else if (a instanceof Maquinaria) {
                Maquinaria maq = (Maquinaria) a;
                System.out.println(maq.getTipo());
            } else {
                Animal animal = (Animal) a;
                System.out.println(animal.getNombre());
            }
        }
    }
}
