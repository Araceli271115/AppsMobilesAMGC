package com.example.conbd.Config;

public class Config_DB {
    public static final String NAME_DB="inventario";
    public static final int VERSION_DB=1;
    public static final String [] SCRIPT_DB={"CREATE TABLE categoria (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "nombre_categoria VARCHAR(50)\n" +
            ");"};
}
