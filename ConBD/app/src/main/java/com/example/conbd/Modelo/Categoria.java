package com.example.conbd.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.conbd.Base_Datos.BaseDatos;
import com.example.conbd.Config.Config_DB;

public class Categoria {
    private int id;
    private String nombre_categoria;
    private BaseDatos admin;
    private SQLiteDatabase base_datos;

    public Categoria(int id, String nombre_categoria) {
        this.id = id;
        this.nombre_categoria = nombre_categoria;
    }

    public Categoria() {

    }

    private void inicializar_bd(Context context) {
        admin = new BaseDatos(
                context,
                Config_DB.NAME_DB,
                null,
                Config_DB.VERSION_DB);
        base_datos = admin.getWritableDatabase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre_categoria='" + nombre_categoria + '\'' +
                '}';
    }

    public boolean save(Context context) {
        this.inicializar_bd(context);
        ContentValues valores_objeto = new ContentValues();
        if (this.id == 0) {
            //registrar
            valores_objeto.put("nombre_categoria", this.nombre_categoria);
            base_datos.insert("categoria", null, valores_objeto);
            base_datos.close();
            return true;
        } else {
            //actualizar
            valores_objeto.put("nombre_categoria", this.nombre_categoria);
            int actualizado = base_datos.update("categoria", valores_objeto, "id=" + this.id, null);
            base_datos.close();
            if (actualizado == 1) {
                return true;
            }
        }
        return false;

    }

    public void get(Context context, int id) {
        this.inicializar_bd(context);
        String query = "select * from categoria wher id=" + id;
        //leer de base de datos
        Cursor registro = base_datos.rawQuery(query, null);
        if (registro.moveToFirst()) {
            this.id = registro.getInt(0);
            this.nombre_categoria = registro.getString(1);
        }
        base_datos.close();
    }

    public void delete(Context context){
        this.inicializar_bd(context);
        //eliminar
        int eliminado=base_datos.delete("categoria","id=" + this.id, null);
        base_datos.close();
        if(eliminado==1){
            this.id=0;
            this.nombre_categoria="";
        }
    }
}
