package com.example.demolistview.services;


import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    com.example.demolistview.repositories.PersonFileRepository repo =new PersonFileRepository();


    public List<String> loadDataForListView() throws IOException {


        List<String> lines= repo.readAllLines();
        List<String> result= new ArrayList<>();

        for(String line: lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            if (parts.length <3 )continue;
            String name= parts[0];
            String email=parts[1];
            String Edad=parts[2];
            result.add("Nombre:"+  name+ " , " + email+ " , "+ Edad);
        }
        return result;

    }
    public void addPerson(String name, String email, int Edad) throws IOException {
        validate(name, email, Edad);
        repo.appendNewLine(name+" , " + email+ " , "+ Edad);
    }
    private void validate(String name, String email, int Edad){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es incorrecto");
        }
        if (Edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor");
        }
    }
}