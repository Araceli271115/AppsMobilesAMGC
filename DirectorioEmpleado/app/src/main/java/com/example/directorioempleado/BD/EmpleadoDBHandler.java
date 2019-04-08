package com.example.directorioempleado.BD;
//Es una clase auxiliar que administra la base de datos

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmpleadoDBHandler extends SQLiteOpenHelper {

    private static final String BD = "directorio.db";
    private static final int VERSION = 1; //cada vez que la estructura de la base de datos cambie se incrementa en 1

    public static final String TABLA_EMPLEADO = "empleado";
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APELLIDOP = "apellidoP";
    public static final String COL_APELLIDOM = "apellidoM";
    public static final String COL_TEL = "telefono";
    public static final String COL_CORREO = "correo";
    public static final String COL_NACIONALIDAD = "nacionalidad";
    public static final String COL_FECHANAC = "fechaNacimiento";
    public static final String COL_ESTADOCIVIL = "estadoCivil";
    public static final String COL_CALLE = "calle";
    public static final String COL_COLONIA = "colonia";
    public static final String COL_CIUDAD = "ciudad";
    public static final String COL_ESTADO = "estado";
    public static final String COL_PAIS = "pais";
    public static final String COL_NOMINA = "nomina";
    public static final String COL_PUESTO = "puesto";
    public static final String COL_RFC = "rfc";
    public static final String COL_CURP = "curp";
    public static final String COL_NSS = "nss";
    public static final String COL_CONTACTO = "contacto";
    public static final String COL_ESCOLARIDAD = "escolaridad";
    public static final String COL_ESTATUS = "estatus";

    //definimos una declaracion para crear la tabla empleado
    private static final String TABLA =
            "CREATE TABLE " + TABLA_EMPLEADO + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOMBRE + " TEXT, " +
                    COL_APELLIDOP + " TEXT, " +
                    COL_APELLIDOM + " TEXT, " +
                    COL_TEL + " TEXT, " +
                    COL_CORREO + " TEXT, " +
                    COL_NACIONALIDAD + " TEXT, " +
                    COL_FECHANAC + " TEXT, " +
                    COL_ESTADOCIVIL + " TEXT, " +
                    COL_CALLE + " TEXT, " +
                    COL_COLONIA + " TEXT, " +
                    COL_CIUDAD + " TEXT, " +
                    COL_ESTADO + " TEXT, " +
                    COL_PAIS + " TEXT, " +
                    COL_NOMINA + " INTEGER, " +
                    COL_PUESTO + " TEXT, " +
                    COL_RFC + " TEXT, " +
                    COL_CURP + " TEXT, " +
                    COL_NSS + " INTEGER, " +
                    COL_CONTACTO + " TEXT, " +
                    COL_ESCOLARIDAD + " TEXT, " +
                    COL_ESTATUS + " TEXT)";


    public EmpleadoDBHandler(Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    //se llama a este metodo en caso de que la base de datos no exista y deseamos
    //obtener una conexion a la BD
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA);
    }

    @Override
    //si la base de datos ya existe pero se cambia la version de la BD se invoca este metodo
    //se elimina la tabla existente y creamos el nuevo numero de version actualizado
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_EMPLEADO);
        db.execSQL(TABLA);
    }
}
