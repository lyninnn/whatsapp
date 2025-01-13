package org.example.whatsapp.modeldaos;

import org.example.whatsapp.database.dbConfig;
import org.example.whatsapp.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Agregar un nuevo usuario
    public boolean agregarUsuario(String nombre,String telefono,String contraseña) {
        String query = "INSERT INTO usuarios (nombre, telefono,contraseña) VALUES (?, ?,?)";

        try (Connection conn = dbConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, telefono);
            pstmt.setString(3,contraseña);
            pstmt.executeUpdate();
            System.out.println("Usuario agregado exitosamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Usuario obtenerUsuarioPorNombreYPassword(String nombre,String contraseña){
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?";
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contraseña);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("contraseña")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra el usuario
    }


    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try (Connection conn = dbConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("contraseña")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Buscar un usuario por ID
    public Usuario buscarUsuarioPorId(int id) {
        String query = "SELECT * FROM usuarios WHERE idUsuario = ?";
        Usuario usuario = null;

        try (Connection conn = dbConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    // Eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        String query = "DELETE FROM usuarios WHERE idUsuario = ?";

        try (Connection conn = dbConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado exitosamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Modificar un usuario por ID
    public boolean modificarUsuario(Usuario usuario) {
        String query = "UPDATE usuarios SET nombre = ?, telefono = ?, contraseña = ? WHERE idUsuario = ?";
        boolean modificado = false;

        try (Connection conn = dbConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Establecer los parámetros de la consulta
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getTelefono());
            pstmt.setString(3, usuario.getContraseña());
            pstmt.setInt(4, usuario.getId());

            // Ejecutar la actualización
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                modificado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modificado;
    }

}
