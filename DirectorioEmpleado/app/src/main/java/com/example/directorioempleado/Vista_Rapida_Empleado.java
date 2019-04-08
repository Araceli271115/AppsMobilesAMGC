package com.example.directorioempleado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.directorioempleado.BD.EmpleadoOperaciones;

public class Vista_Rapida_Empleado extends AppCompatActivity {

    long id;
    String nombre;
    String apellidoP;
    String apellidoM;
    long nomina;
    String telefono;
    String puesto;
    String estatus;

    EditText campoId;
    EditText campoNombre;
    EditText campoApellidoP;
    EditText campoApellidoM;
    EditText campoNomina;
    EditText campoTelefono;
    EditText campoPuesto;
    EditText campoEstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__rapida__empleado);
        id = getIntent().getExtras().getLong("id");
        nombre = getIntent().getExtras().getString("nombre");
        apellidoP = getIntent().getExtras().getString("apellidoP");
        apellidoM = getIntent().getExtras().getString("apellidoM");
        nomina = getIntent().getExtras().getLong("nomina");
        telefono = getIntent().getExtras().getString("telefono");
        puesto = getIntent().getExtras().getString("puesto");
        estatus = getIntent().getExtras().getString("estatus");

        campoId = (EditText) findViewById(R.id.EditTextId);
        campoId.setText("" + id);

        campoNombre = (EditText) findViewById(R.id.EditTextNombre);
        campoNombre.setText(nombre);

        campoApellidoP = (EditText) findViewById(R.id.EditTextApellidoP);
        campoApellidoP.setText(apellidoP);

        campoApellidoM = (EditText) findViewById(R.id.EditTextApellidoM);
        campoApellidoM.setText(apellidoM);

        campoNomina = (EditText) findViewById(R.id.EditTextNomina);
        campoNomina.setText("" + nomina);

        campoTelefono = (EditText) findViewById(R.id.EditTextTelefono);
        campoTelefono.setText(telefono);

        campoPuesto = (EditText) findViewById(R.id.EditTextPuesto);
        campoPuesto.setText(puesto);

        campoEstatus = (EditText) findViewById(R.id.EditTextEstatus);
        campoEstatus.setText(estatus);


    }


}
