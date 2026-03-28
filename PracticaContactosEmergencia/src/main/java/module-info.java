module com.example.practicacontactosemergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicacontactosemergencia to javafx.fxml;
    opens com.example.practicacontactosemergencia.controller to javafx.fxml;
    opens com.example.practicacontactosemergencia.model to javafx.fxml;
    exports com.example.practicacontactosemergencia;
}