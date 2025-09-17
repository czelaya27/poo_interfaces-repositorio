package org.czelaya.app.modelo;

public class Cliente extends BaseEntity{
    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
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
