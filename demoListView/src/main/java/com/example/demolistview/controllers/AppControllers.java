package com.example.demolistview.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import com.example.demolistview.services.PersonService;


import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;


    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAdd(){
        try {
            String name=txtName.getText();
            String email=txtEmail.getText();
            String EdadText=txtEdad.getText();

            int Edad = Integer.parseInt(EdadText);
            service.addPerson(name, email, Edad);
            lblMsg.setText("Persona creada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();
        }catch (NumberFormatException e){
            lblMsg.setText("Hubo un error, la edad debe ser mayor a 18");
            lblMsg.setStyle("-fx-text-fill: red");

        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");

        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }


    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados con exito");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText("Error al cargar los archivos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
}