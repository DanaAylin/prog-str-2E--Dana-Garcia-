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
            result.add( name+ " , " + email+ " , "+ Edad);
        }
        return result;

    }

    public void updatePerson(int index, String name, String email, int edad) throws IOException {
        validate (name, email, edad);
        if (index<0){
            throw new IllegalArgumentException("El indice es invalido");
        }
        List<String> data=getCleanLines();
        data.set(index,name+ " , " + email+ " , "+ edad);
        repo.saveFile(data);
    }

    public void deletePerson(int index) throws IOException {
        if (index<0){
            throw new IllegalArgumentException("El indice es invalido");
        }
        List<String> data=getCleanLines();
        data.remove(index);
        repo.saveFile(data);
    }

    private List<String>getCleanLines() throws IOException {
        List<String> lines= repo.readAllLines();
        List<String> cleanLines= new ArrayList<>();
        for (String line: lines){
            if (line!=null && !line.isBlank());
            cleanLines.add(line);
        }
        return cleanLines;
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