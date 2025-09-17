package org.czelaya.app.modelo;

public class Producto extends BaseEntity{
    private String nombre;
    private String descripcion;
    private Double precio;

    public Producto(String nombre, String descripcion, double precio) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() +
                "\nNombre: "  + this.getNombre() +
                "\nDescripción: " + this.getDescripcion() +
                "\nPrecio: $" + this.getPrecio();
    }
}
