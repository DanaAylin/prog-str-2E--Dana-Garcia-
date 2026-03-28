package com.example.practicacontactosemergencia.controller;

import com.example.practicacontactosemergencia.model.Contacto;
import com.example.practicacontactosemergencia.service.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactController {

    private String[] arrParentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    private ComboBox<String> comboParentescos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTel;

    @FXML
    private ListView<Contacto> listContactos;

    private ObservableList<Contacto> listaObservable = FXCollections.observableArrayList();

    private ContactService service = new ContactService();

    @FXML
    public void initialize() {
        comboParentescos.getItems().addAll(arrParentescos);
        listContactos.setItems(listaObservable);
    }

    @FXML
    public void onAddContact() {

        String name = txtNombre.getText().trim();
        String tel = txtTel.getText().trim();
        String parent = comboParentescos.getValue();

        if (name.isEmpty()) {
            System.out.println("Nombre vacío");
            return;
        }

        if (tel.length() != 10) {
            System.out.println("Tel inválido");
            return;
        }

        if (parent == null) {
            System.out.println("Selecciona parentesco");
            return;
        }

        Contacto contact = new Contacto(name, tel, parent);
        service.addContact(contact);

        listaObservable.add(contact);

        txtNombre.clear();
        txtTel.clear();
        comboParentescos.setValue(null);
    }
}