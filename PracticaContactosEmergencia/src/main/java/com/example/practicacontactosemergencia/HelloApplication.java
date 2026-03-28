package com.example.practicacontactosemergencia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/com/example/practicacontactosemergencia/contact-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Contactos de Emergencia");
        stage.setScene(scene);
        stage.show();
    }
}