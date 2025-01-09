package org.example.whatsapp.models;

import java.time.LocalDateTime;

public class Sesion {
    private int id;
    private String usuario;
    private LocalDateTime ultimaConexion;

    public Sesion(int id, String usuario, LocalDateTime ultimaConexion) {
        this.id = id;
        this.usuario = usuario;
        this.ultimaConexion = ultimaConexion;
    }

    public Sesion(String usuario, LocalDateTime ultimaConexion) {
        this.usuario = usuario;
        this.ultimaConexion = ultimaConexion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(LocalDateTime ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
}
