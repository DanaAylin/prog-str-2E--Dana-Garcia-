package com.example.practicacontactosemergencia.service;

import com.example.practicacontactosemergencia.model.Contacto;
import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contacto> lista = new ArrayList<>();

    public void addContact(Contacto c) {
        lista.add(c);
    }

    public ArrayList<Contacto> getLista() {
        return lista;
    }
}