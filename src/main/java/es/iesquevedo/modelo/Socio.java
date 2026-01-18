package es.iesquevedo.modelo;

public class Socio {
    private String dni;
    private String nombre;

    public Socio(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Socio{" + "dni='" + dni + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}

