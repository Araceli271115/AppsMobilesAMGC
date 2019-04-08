package com.example.directorioempleado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.directorioempleado.BD.EmpleadoOperaciones;
import com.example.directorioempleado.Modelo.Empleado;


public class Vista_Rapida_Empleado extends AppCompatActivity {

    long id;
    String nombre;
    String apellidoP;
    String apellidoM;
    String nomina;
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

    Button eliminar;
    Button modificar;
    EmpleadoOperaciones operacion;
    Empleado empleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__rapida__empleado);

        id = getIntent().getExtras().getLong("id");
        nombre = getIntent().getExtras().getString("nombre");
        apellidoP = getIntent().getExtras().getString("apellidoP");
        apellidoM = getIntent().getExtras().getString("apellidoM");
        nomina = getIntent().getExtras().getString("nomina");
        telefono = getIntent().getExtras().getString("telefono");
        puesto = getIntent().getExtras().getString("puesto");
        estatus = getIntent().getExtras().getString("estatus");

        eliminar = (Button) findViewById(R.id.buttonEliminar);
        modificar = (Button) findViewById(R.id.buttonModificar);

        operacion = new EmpleadoOperaciones(this);
        operacion.conectarBD();
        empleado = new Empleado();


        campoId = (EditText) findViewById(R.id.EditTextId);
        campoId.setText("" + id);

        campoNombre = (EditText) findViewById(R.id.EditTextNombre);
        campoNombre.setText(nombre);

        campoApellidoP = (EditText) findViewById(R.id.EditTextApellidoP);
        campoApellidoP.setText(apellidoP);

        campoApellidoM = (EditText) findViewById(R.id.EditTextApellidoM);
        campoApellidoM.setText(apellidoM);

        campoNomina = (EditText) findViewById(R.id.EditTextNomina);
        campoNomina.setText(nomina);

        campoTelefono = (EditText) findViewById(R.id.EditTextTelefono);
        campoTelefono.setText(telefono);

        campoPuesto = (EditText) findViewById(R.id.EditTextPuesto);
        campoPuesto.setText(puesto);

        campoEstatus = (EditText) findViewById(R.id.EditTextEstatus);
        campoEstatus.setText(estatus);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operacion.eliminarEmpleado(empleado);
                Toast t = Toast.makeText(Vista_Rapida_Empleado.this, "Registro de Empleado eliminado!", Toast.LENGTH_SHORT);
                t.show();
                Intent i = new Intent(Vista_Rapida_Empleado.this, MainActivity.class);
                startActivity(i);
            }
        });


        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Vista_Rapida_Empleado.this,
                        Form_Empleado.class);
                i.putExtra("id", id+"");
                i.putExtra("mod_add", "Modificar");

                startActivity(i);
            }
        });

    }


}
