package org.example.whatsapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.whatsapp.modeldaos.UsuarioDAO;
import org.example.whatsapp.models.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private TextField txtUsuario; // Campo para el nombre de usuario

    @FXML
    private PasswordField txtPassword; // Campo para la contraseña

    @FXML
    private Button btnLogin; // Botón para iniciar sesión

    @FXML
    private Button btnRegistrar; // Botón para registrar usuario

    private UsuarioDAO usuarioDAO = new UsuarioDAO(); // DAO para manejar usuarios

    @FXML
    public void onLogin() {
        String nombreUsuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (nombreUsuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "El nombre de usuario y la contraseña no pueden estar vacíos.");
            return;
        }

        Usuario usuario = usuarioDAO.obtenerUsuarioPorNombreYPassword(nombreUsuario, password);

        if (usuario != null) {
            mostrarAlerta("Éxito", "Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    public void onRegistrar() {
        try {
            // Cargar la nueva vista de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("usuarioView.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual y reemplazarla con la nueva
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Registrar Usuario");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la página de registro.");
        }
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
