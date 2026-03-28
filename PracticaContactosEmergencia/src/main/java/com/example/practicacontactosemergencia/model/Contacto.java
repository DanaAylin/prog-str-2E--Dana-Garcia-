package com.example.practicacontactosemergencia.model;

public class Contacto {

    private String nombre;
    private String tel;
    private String parent;

    public Contacto(String nombre, String tel, String parent) {
        this.nombre = nombre;
        this.tel = tel;
        this.parent = parent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return nombre + " - " + tel + " - " + parent;
    }
}