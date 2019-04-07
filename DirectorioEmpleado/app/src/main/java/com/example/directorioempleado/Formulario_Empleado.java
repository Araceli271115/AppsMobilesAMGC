package com.example.directorioempleado;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario_Empleado extends AppCompatActivity {
    DAOEmpleado dao;
    Empleado e;
    private Intent main;
    private EditText id;
    private EditText nombre;
    private EditText apellidoP;
    private EditText apellidoM;
    private EditText telefono;
    private EditText correo;
    private EditText nacionalidad;
    private EditText fechaNacimiento;
    private EditText estadoCivil;
    private EditText calle;
    private EditText colonia;
    private EditText ciudad;
    private EditText estado;
    private EditText pais;
    private EditText nomina;
    private EditText puesto;
    private EditText rfc;
    private EditText curp;
    private EditText nss;
    private EditText contacto;
    private EditText escolaridad;
    private EditText estatus;
    Button guardar;
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_empleado);
        dao = new DAOEmpleado(this);


        id = (EditText) findViewById(R.id.EditTextId);
        nombre = (EditText) findViewById(R.id.EditTextId);
        apellidoP = (EditText) findViewById(R.id.EditTextId);
        apellidoM = (EditText) findViewById(R.id.EditTextId);
        telefono = (EditText) findViewById(R.id.EditTextId);
        correo = (EditText) findViewById(R.id.EditTextId);
        nacionalidad = (EditText) findViewById(R.id.EditTextId);
        fechaNacimiento = (EditText) findViewById(R.id.EditTextId);
        estadoCivil = (EditText) findViewById(R.id.EditTextId);
        calle = (EditText) findViewById(R.id.EditTextId);
        colonia = (EditText) findViewById(R.id.EditTextId);
        ciudad = (EditText) findViewById(R.id.EditTextId);
        estado = (EditText) findViewById(R.id.EditTextId);
        pais = (EditText) findViewById(R.id.EditTextId);
        nomina = (EditText) findViewById(R.id.EditTextId);
        puesto = (EditText) findViewById(R.id.EditTextId);
        rfc = (EditText) findViewById(R.id.EditTextId);
        curp = (EditText) findViewById(R.id.EditTextId);
        nss = (EditText) findViewById(R.id.EditTextId);
        contacto = (EditText) findViewById(R.id.EditTextId);
        escolaridad = (EditText) findViewById(R.id.EditTextId);
        estatus = (EditText) findViewById(R.id.EditTextId);
        guardar = (Button) findViewById(R.id.buttonAgregar);
        cancelar = (Button) findViewById(R.id.buttonCancelar);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    e = new Empleado(Integer.parseInt(id.getText().toString()),
                            nombre.getText().toString(),
                            apellidoP.getText().toString(),
                            apellidoM.getText().toString(),
                            telefono.getText().toString(),
                            correo.getText().toString(),
                            nacionalidad.getText().toString(),
                            fechaNacimiento.getText().toString(),
                            estadoCivil.getText().toString(),
                            calle.getText().toString(),
                            colonia.getText().toString(),
                            ciudad.getText().toString(),
                            estado.getText().toString(),
                            pais.getText().toString(),
                            Integer.parseInt(nomina.getText().toString()),
                            puesto.getText().toString(),
                            rfc.getText().toString(),
                            curp.getText().toString(),
                            Integer.parseInt(nss.getText().toString()),
                            contacto.getText().toString(),
                            escolaridad.getText().toString(),
                            estatus.getText().toString());
                    dao.insertar(e);


                } catch (Exception e) {
                    Toast.makeText(getApplication(), "Error al insertar", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplication(), "Nuevo Contacto Agregado", Toast.LENGTH_SHORT).show();
                startActivity(main);
            }
        });
    }
}