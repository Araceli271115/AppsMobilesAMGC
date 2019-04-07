package com.example.directorioempleado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOEmpleado {
    SQLiteDatabase cx;
    ArrayList<Empleado> lista;
    Empleado e;
    Context ct;
    String nombreBD ="BDEmpleados";
    String tabla="create table if not exists Empleado(nombre text, apellidoP text, apellidoM text, telefono text, correo text, nacionalidad text, fechaNacimieto text, estadoCivil text, calle text, colonia text,  ciudad text, estado text, pais text, nomina integer,  puesto text,  rfc text, curp text,  nss integer, contacto text, escolaridad text, estatustext )";
    public DAOEmpleado(Context c) {
    this.ct=c;
    cx=ct.openOrCreateDatabase(nombreBD,Context.MODE_WORLD_WRITEABLE,null);
    cx.execSQL(tabla);
    }

    public boolean insertar(Empleado e){
        return true;
    }
    public boolean eliminar(Empleado e){
        return true;
    }
    public boolean editar(Empleado e){
        return true;
    }
    public ArrayList<Empleado> verTodos(Empleado e){
        return lista;
    }
    public Empleado verUno(String nombre){
        return e;
    }

}
