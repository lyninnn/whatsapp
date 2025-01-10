package org.example.whatsapp.utilidades;
import org.example.whatsapp.models.Usuario;
public class UsuarioActual {

    public static Usuario usuario;


    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioActual.usuario = usuario;
    }
    public static void limpiarSesion() {
        usuario = null;
    }
}
