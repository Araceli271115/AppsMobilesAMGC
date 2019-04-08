package com.example.directorioempleado.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.directorioempleado.Modelo.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoOperaciones {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            EmpleadoDBHandler.COL_ID,
            EmpleadoDBHandler.COL_ID,
            EmpleadoDBHandler.COL_NOMBRE,
            EmpleadoDBHandler.COL_APELLIDOP,
            EmpleadoDBHandler.COL_APELLIDOM,
            EmpleadoDBHandler.COL_TEL,
            EmpleadoDBHandler.COL_CORREO,
            EmpleadoDBHandler.COL_NACIONALIDAD,
            EmpleadoDBHandler.COL_FECHANAC,
            EmpleadoDBHandler.COL_ESTADOCIVIL,
            EmpleadoDBHandler.COL_CALLE,
            EmpleadoDBHandler.COL_COLONIA,
            EmpleadoDBHandler.COL_CIUDAD,
            EmpleadoDBHandler.COL_ESTADO,
            EmpleadoDBHandler.COL_PAIS,
            EmpleadoDBHandler.COL_NOMINA,
            EmpleadoDBHandler.COL_PUESTO,
            EmpleadoDBHandler.COL_RFC,
            EmpleadoDBHandler.COL_CURP,
            EmpleadoDBHandler.COL_NSS,
            EmpleadoDBHandler.COL_CONTACTO,
            EmpleadoDBHandler.COL_ESCOLARIDAD,
            EmpleadoDBHandler.COL_ESTATUS};

    public EmpleadoOperaciones(Context context) {
        dbhandler = new EmpleadoDBHandler(context);
    }

    public void conectarBD() {
        Log.i(LOGTAG, "Conexión con BD");
        database = dbhandler.getWritableDatabase();
    }

    public void desconectarBD() {
        Log.i(LOGTAG, "Conexión Cerrada de la BD");
        dbhandler.close();
    }

    //Agrega un empleado a la base de datos
    // ponemos todos los valores de los campos requeridos con el objeto ContentValues
    //Insertamos en la base de datos
    //la operacion inserción devolvera el Id del empleado generado automaticamente
    public Empleado AgregarEmpleado(Empleado e) {
        ContentValues values = new ContentValues();
        values.put(EmpleadoDBHandler.COL_NOMBRE, e.getNombre());
        values.put(EmpleadoDBHandler.COL_APELLIDOP, e.getApellidoP());
        values.put(EmpleadoDBHandler.COL_APELLIDOM, e.getApellidoM());
        values.put(EmpleadoDBHandler.COL_TEL, e.getTelefono());
        values.put(EmpleadoDBHandler.COL_CORREO, e.getCorreo());
        values.put(EmpleadoDBHandler.COL_NACIONALIDAD, e.getNacionalidad());
        values.put(EmpleadoDBHandler.COL_FECHANAC, e.getFechaNacimieto());
        values.put(EmpleadoDBHandler.COL_ESTADOCIVIL, e.getEstadoCivil());
        values.put(EmpleadoDBHandler.COL_CALLE, e.getCalle());
        values.put(EmpleadoDBHandler.COL_COLONIA, e.getColonia());
        values.put(EmpleadoDBHandler.COL_CIUDAD, e.getCiudad());
        values.put(EmpleadoDBHandler.COL_ESTADO, e.getEstado());
        values.put(EmpleadoDBHandler.COL_PAIS, e.getPais());
        values.put(EmpleadoDBHandler.COL_NOMINA, e.getNomina());
        values.put(EmpleadoDBHandler.COL_PUESTO, e.getPuesto());
        values.put(EmpleadoDBHandler.COL_RFC, e.getRfc());
        values.put(EmpleadoDBHandler.COL_CURP, e.getCurp());
        values.put(EmpleadoDBHandler.COL_NSS, e.getNss());
        values.put(EmpleadoDBHandler.COL_CONTACTO, e.getContacto());
        values.put(EmpleadoDBHandler.COL_ESCOLARIDAD, e.getEscolaridad());
        values.put(EmpleadoDBHandler.COL_ESTATUS, e.getEstatus());
        long insertid = database.insert(EmpleadoDBHandler.TABLA_EMPLEADO, null, values);
        e.setId(insertid);
        return e;

    }

    // Obtener un solo empleado por el ID y devuleve un objeto Empleado
    //Se devuelve la primer fila
    public Empleado ObtenerEmpleado(long id) {

        Cursor cursor = database.query(
                EmpleadoDBHandler.TABLA_EMPLEADO,
                allColumns,
                EmpleadoDBHandler.COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Empleado e = new Empleado(
                Long.parseLong(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                Long.parseLong(cursor.getString(14)),
                cursor.getString(15),
                cursor.getString(16),
                cursor.getString(17),
                Long.parseLong(cursor.getString(18)),
                cursor.getString(19),
                cursor.getString(20),
                cursor.getString(21));


        // retorna empleado
        return e;
    }

    //obtener todos los empleados
    //devuelve la lista con todos los empleados
    public List<Empleado> ObtenerTodosEmpleados() {

        Cursor cursor = database.query(
                EmpleadoDBHandler.TABLA_EMPLEADO,
                allColumns,
                null,
                null,
                null,
                null,
                null);

        List<Empleado> em = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Empleado e = new Empleado();
                e.setId(cursor.getLong(cursor.getColumnIndex(EmpleadoDBHandler.COL_ID)));
                e.setNombre(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_NOMBRE)));
                e.setApellidoP(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_APELLIDOP)));
                e.setApellidoM(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_APELLIDOM)));
                e.setTelefono(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_TEL)));
                e.setCorreo(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_CORREO)));
                e.setNacionalidad(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_NACIONALIDAD)));
                e.setFechaNacimieto(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_FECHANAC)));
                e.setEstadoCivil(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_ESTADOCIVIL)));
                e.setCalle(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_CALLE)));
                e.setColonia(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_COLONIA)));
                e.setCiudad(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_CIUDAD)));
                e.setEstado(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_ESTADO)));
                e.setPais(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_PAIS)));
                e.setNomina(cursor.getLong(cursor.getColumnIndex(EmpleadoDBHandler.COL_NOMINA)));
                e.setPuesto(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_PUESTO)));
                e.setRfc(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_RFC)));
                e.setCurp(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_CURP)));
                e.setNss(cursor.getLong(cursor.getColumnIndex(EmpleadoDBHandler.COL_NSS)));
                e.setContacto(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_CONTACTO)));
                e.setEscolaridad(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_ESCOLARIDAD)));
                e.setEstatus(cursor.getString(cursor.getColumnIndex(EmpleadoDBHandler.COL_ESTATUS)));
                em.add(e);
            }
        }
        // RETORNA TODOS LOS EMPLEADOS
        return em;
    }

    // MODIFICAR EMPLEADO
    //se colocan nuevos valores en el objeto ContentValues
    //luego s actualiza ka base de datos
    public int ModificarEmpleado(Empleado e) {

        ContentValues values = new ContentValues();
        values.put(EmpleadoDBHandler.COL_NOMBRE, e.getNombre());
        values.put(EmpleadoDBHandler.COL_APELLIDOP, e.getApellidoP());
        values.put(EmpleadoDBHandler.COL_APELLIDOM, e.getApellidoM());
        values.put(EmpleadoDBHandler.COL_TEL, e.getTelefono());
        values.put(EmpleadoDBHandler.COL_CORREO, e.getCorreo());
        values.put(EmpleadoDBHandler.COL_NACIONALIDAD, e.getNacionalidad());
        values.put(EmpleadoDBHandler.COL_FECHANAC, e.getFechaNacimieto());
        values.put(EmpleadoDBHandler.COL_ESTADOCIVIL, e.getEstadoCivil());
        values.put(EmpleadoDBHandler.COL_CALLE, e.getCalle());
        values.put(EmpleadoDBHandler.COL_COLONIA, e.getColonia());
        values.put(EmpleadoDBHandler.COL_CIUDAD, e.getCiudad());
        values.put(EmpleadoDBHandler.COL_ESTADO, e.getEstado());
        values.put(EmpleadoDBHandler.COL_PAIS, e.getPais());
        values.put(EmpleadoDBHandler.COL_NOMINA, e.getNomina());
        values.put(EmpleadoDBHandler.COL_PUESTO, e.getPuesto());
        values.put(EmpleadoDBHandler.COL_RFC, e.getRfc());
        values.put(EmpleadoDBHandler.COL_CURP, e.getCurp());
        values.put(EmpleadoDBHandler.COL_NSS, e.getNss());
        values.put(EmpleadoDBHandler.COL_CONTACTO, e.getContacto());
        values.put(EmpleadoDBHandler.COL_ESCOLARIDAD, e.getEscolaridad());
        values.put(EmpleadoDBHandler.COL_ESTATUS, e.getEstatus());


        // modificar la linea
        return database.update(EmpleadoDBHandler.TABLA_EMPLEADO, values,
                EmpleadoDBHandler.COL_ID + "=?",
                new String[]{String.valueOf(e.getId())});
    }

    // Eliminar un empleado

    public void EliminarEmpleado(Empleado e) {
        database.delete(EmpleadoDBHandler.TABLA_EMPLEADO,
                EmpleadoDBHandler.COL_ID + "=" + e.getId(),
                null);
    }

}
