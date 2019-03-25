package com.example.envioobjetos;

import java.io.Serializable;

public class DatosPersona implements Serializable {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
   // private int edad;

    public DatosPersona(){

    }
    public DatosPersona(String nombre, String apellidoP, String apellidoM/*,int edad*/){
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        //this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

}
