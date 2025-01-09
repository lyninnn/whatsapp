package org.example.whatsapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/whatsappapp";
    private static final String USER = "root"; // Cambia según tu configuración
    private static final String PASSWORD = ""; // Cambia según tu configuración

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos");
        }
    }
}

