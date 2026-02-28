package com.example.demologindashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMensaje;

    @FXML
    protected void login() {

        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        if (correo.isEmpty() || correo.length() < 4) {
            lblMensaje.setText("Usuario mínimo 4 caracteres");
            return;
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            lblMensaje.setText("Correo inválido");
            return;
        }

        if (password.length() < 6) {
            lblMensaje.setText("Password mínimo 6 caracteres");
            return;
        }

        abrirDashboard(correo);
    }

    private void abrirDashboard(String usuario) {

        Stage stage = (Stage) txtCorreo.getScene().getWindow();

        VBox root = new VBox();
        root.setSpacing(20);
        root.setStyle("-fx-alignment: center;");

        Label mensaje = new Label("Bienvenido, " + usuario);

        root.getChildren().add(mensaje);

        Scene scene = new Scene(root, 400, 200);

        stage.setScene(scene);
    }
}