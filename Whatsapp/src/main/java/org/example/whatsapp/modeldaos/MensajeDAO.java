//package org.example.whatxapp.modeldaos;
//
//import org.example.whatxapp.models.Mensaje;
//
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MensajeDAO {
//    private Connection connection;
//
//    public MensajeDAO() {
//
//    }
//
//    public void guardarMensaje(Mensaje mensaje) throws SQLException {
//        String sql = "INSERT INTO mensaje (emisor, receptor, contenido, fechaEnvio) VALUES (?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, mensaje.getEmisor());
//            stmt.setString(2, mensaje.getReceptor());
//            stmt.setString(3, mensaje.getContenido());
//            stmt.setTimestamp(4, Timestamp.valueOf(mensaje.getFechaEnvio()));
//            stmt.executeUpdate();
//        }
//    }
//
//    public List<Mensaje> obtenerMensajes(String emisor, String receptor) throws SQLException {
//        String sql = "SELECT * FROM mensaje WHERE (emisor = ? AND receptor = ?) OR (emisor = ? AND receptor = ?) ORDER BY fechaEnvio";
//        List<Mensaje> mensajes = new ArrayList<>();
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, emisor);
//            stmt.setString(2, receptor);
//            stmt.setString(3, receptor);
//            stmt.setString(4, emisor);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    Mensaje mensaje = new Mensaje(
//                            rs.getInt("id"),
//                            rs.getString("emisor"),
//                            rs.getString("receptor"),
//                            rs.getString("contenido"),
//                            rs.getTimestamp("fechaEnvio").toLocalDateTime()
//                    );
//                    mensajes.add(mensaje);
//                }
//            }
//        }
//        return mensajes;
//    }
//}
