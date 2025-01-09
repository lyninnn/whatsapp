package org.example.whatsapp.modeldaos;

import org.example.whatsapp.models.Sesion;

import java.sql.*;

public class SesionDAO {
    private Connection connection;

    public SesionDAO() {
    }

    public void actualizarSesion(Sesion sesion) throws SQLException {
        String sql = "INSERT INTO sesion (usuario, ultimaConexion) VALUES (?, ?) ON DUPLICATE KEY UPDATE ultimaConexion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sesion.getUsuario());
            stmt.setTimestamp(2, Timestamp.valueOf(sesion.getUltimaConexion()));
            stmt.setTimestamp(3, Timestamp.valueOf(sesion.getUltimaConexion()));
            stmt.executeUpdate();
        }
    }

    public Sesion obtenerSesion(String usuario) throws SQLException {
        String sql = "SELECT * FROM sesion WHERE usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Sesion(
                            rs.getInt("id"),
                            rs.getString("usuario"),
                            rs.getTimestamp("ultimaConexion").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }
}
