package com.example.directorioempleado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOEmpleado {
    SQLiteDatabase cx;
    ArrayList<Empleado> lista;
    Empleado e;
    Context ct;
    String nombreBD = "BDEmpleados";
    String tabla = "create table if not exists empleado(" +
            "nombre text," +
            " apellidoP text," +
            " apellidoM text, " +
            "telefono text," +
            " correo text," +
            " nacionalidad text," +
            " fechaNacimiento text," +
            " estadoCivil text," +
            " calle text," +
            " colonia text," +
            "  ciudad text," +
            " estado text," +
            " pais text," +
            " nomina integer," +
            "  puesto text," +
            "  rfc text," +
            " curp text," +
            "  nss integer," +
            " contacto text," +
            " escolaridad text," +
            " estatus text )";

    public DAOEmpleado(Context c) {
        this.ct = c;
        cx = ct.openOrCreateDatabase(nombreBD, Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(tabla);
    }

    public boolean insertar(Empleado e) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("id", e.getId());
        contenedor.put("nombre", e.getNombre());
        contenedor.put("apellidoP", e.getApellidoP());
        contenedor.put("apellidoM", e.getApellidoM());
        contenedor.put("telefono", e.getTelefono());
        contenedor.put("correo", e.getCorreo());
        contenedor.put("nacionalidad", e.getNacionalidad());
        contenedor.put("fechaNacimiento", e.getFechaNacimieto());
        contenedor.put("estadoCivil", e.getEstadoCivil());
        contenedor.put("calle", e.getCalle());
        contenedor.put("colonia", e.getColonia());
        contenedor.put("ciudad", e.getCiudad());
        contenedor.put("estado", e.getEstado());
        contenedor.put("pais", e.getPais());
        contenedor.put("nomina", e.getNomina());
        contenedor.put("puesto", e.getPuesto());
        contenedor.put("rfc", e.getRfc());
        contenedor.put("curp", e.getCurp());
        contenedor.put("nss", e.getNss());
        contenedor.put("contacto", e.getContacto());
        contenedor.put("escolaridad", e.getEscolaridad());
        contenedor.put("estatus", e.getEstatus());
        return (cx.insert("empleado", null, contenedor)) > 0;
    }

    public boolean eliminar(Empleado e) {
        return true;
    }

    public boolean editar(Empleado e) {
        return true;
    }

    public ArrayList<Empleado> verTodos() {
               
        return lista;
    }

    public Empleado verUno(int id) {
        return e;
    }

}
