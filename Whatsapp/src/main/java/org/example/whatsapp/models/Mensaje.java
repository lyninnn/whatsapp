package org.example.whatsapp.models;

import java.time.LocalDateTime;

public class Mensaje {
    private int emisor;
    private int receptor;
    private String contenido;
    private LocalDateTime fechaEnvio;

    public Mensaje() {
    }

    public Mensaje( int emisor, int receptor, String contenido, LocalDateTime fechaEnvio) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    }

    public int getEmisor() {
        return emisor;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}

