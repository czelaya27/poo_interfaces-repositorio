package org.czelaya.app.modelo;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId;

    public Cliente() {
        this.id = ++ultimoId;
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() +
                "\nNombre: " + this.getNombre() +
                "\nApellido: " + this.getApellido();
    }
}
