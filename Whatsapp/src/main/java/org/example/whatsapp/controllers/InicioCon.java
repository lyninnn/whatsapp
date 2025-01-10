package org.example.whatsapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.whatsapp.models.Usuario;
import org.example.whatsapp.modeldaos.UsuarioDAO;

import java.util.List;

public class InicioCon {

    @FXML
    private ListView<Usuario> listUsuarios;
    @FXML
    private TextField txtMessage;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();

    // Método para cargar todos los usuarios
    public void initialize() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();  // Suponiendo que tienes un método en UsuarioDAO para obtener todos los usuarios
        usuariosList.setAll(usuarios);
        listUsuarios.setItems(usuariosList);
    }

    // Método para eliminar un usuario
    @FXML
    public void onEliminar() {
        Usuario usuarioSeleccionado = listUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            boolean exito = usuarioDAO.eliminarUsuario(usuarioSeleccionado.getId());
            if (exito) {
                mostrarAlerta("Éxito", "Usuario eliminado correctamente.");
                cargarUsuarios(); // Recargar la lista después de eliminar
            } else {
                mostrarAlerta("Error", "Hubo un problema al eliminar al usuario.");
            }
        } else {
            mostrarAlerta("Error", "Selecciona un usuario para eliminar.");
        }
    }

    // Método para modificar un usuario
    @FXML
    public void onModificar() {
        Usuario usuarioSeleccionado = listUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            // Mostrar ventana de modificación (aquí puedes abrir otro formulario para editar los datos del usuario)
            // Este es un ejemplo básico:
            String nuevoTelefono = "NuevoTelefono"; // Ejemplo
            usuarioSeleccionado.setTelefono(nuevoTelefono);
            boolean exito = usuarioDAO.modificarUsuario(usuarioSeleccionado);
            if (exito) {
                mostrarAlerta("Éxito", "Usuario modificado correctamente.");
                cargarUsuarios(); // Recargar la lista después de modificar
            } else {
                mostrarAlerta("Error", "Hubo un problema al modificar al usuario.");
            }
        } else {
            mostrarAlerta("Error", "Selecciona un usuario para modificar.");
        }
    }

    // Método para enviar un mensaje al usuario
    @FXML
    public void onSendMessage() {
        Usuario usuarioSeleccionado = listUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            String mensaje = txtMessage.getText().trim();
            if (!mensaje.isEmpty()) {
                // Aquí puedes agregar la lógica para enviar el mensaje al usuario seleccionado
                // Por ejemplo, almacenar en una base de datos de mensajes
                mostrarAlerta("Mensaje enviado", "Mensaje enviado a " + usuarioSeleccionado.getNombre());
                txtMessage.clear(); // Limpiar el campo de mensaje
            } else {
                mostrarAlerta("Error", "Escribe un mensaje antes de enviar.");
            }
        } else {
            mostrarAlerta("Error", "Selecciona un usuario para enviar el mensaje.");
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

