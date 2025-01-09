package org.example.whatsapp.models;

public class Usuario {
    private int id;
    private String nombre;
    private String telefono;
    private String contrasenia;

    // Constructor vacío (opcional)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre, String telefono,String contrasenia) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Método para imprimir los detalles del usuario (opcional)
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\''  +
                ", contraseña='" + contrasenia + '\''  +
                '}';
    }
}
