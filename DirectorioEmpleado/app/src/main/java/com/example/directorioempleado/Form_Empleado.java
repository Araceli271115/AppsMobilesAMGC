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

public class Form_Empleado extends AppCompatActivity {
    //   private static final String EXTRA_EMP_ID = "com.example.directorioempleado.id";
    //private static final String EXTRA_ADD_UPDATE = "com.example.directorioempleado.guardar";


    private Empleado newEmployee;
    // private Empleado oldEmployee;
    private String mode;
    private long empId;
    private EmpleadoOperaciones employeeData;


    //private EditText id;
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
        setContentView(R.layout.activity_form_empleado);

        newEmployee = new Empleado();
        //  oldEmployee = new Empleado();


        nombre = (EditText) findViewById(R.id.EditTextNombre);
        apellidoP = (EditText) findViewById(R.id.EditTextApellidoP);
        apellidoM = (EditText) findViewById(R.id.EditTextApellidoM);
        telefono = (EditText) findViewById(R.id.EditTextTelefono);
        correo = (EditText) findViewById(R.id.EditTextCorreo);
        nacionalidad = (EditText) findViewById(R.id.EditTextNacionalidad);
        fechaNacimiento = (EditText) findViewById(R.id.EditTextFechaNacimiento);
        estadoCivil = (EditText) findViewById(R.id.EditTextEstadoCivil);
        calle = (EditText) findViewById(R.id.EditTextCalle);
        colonia = (EditText) findViewById(R.id.EditTextColonia);
        ciudad = (EditText) findViewById(R.id.EditTextCiudad);
        estado = (EditText) findViewById(R.id.EditTextEstado);
        pais = (EditText) findViewById(R.id.EditTextPais);
        nomina = (EditText) findViewById(R.id.EditTextNomina);
        puesto = (EditText) findViewById(R.id.EditTextPuesto);
        rfc = (EditText) findViewById(R.id.EditTextRfc);
        curp = (EditText) findViewById(R.id.EditTextCurp);
        nss = (EditText) findViewById(R.id.EditTextNss);
        contacto = (EditText) findViewById(R.id.EditTextContacto);
        escolaridad = (EditText) findViewById(R.id.EditTextEscolaridad);
        estatus = (EditText) findViewById(R.id.EditTextEstatus);
        guardar = (Button) findViewById(R.id.buttonAgregar);
        cancelar = (Button) findViewById(R.id.buttonCancelar);

        employeeData = new EmpleadoOperaciones(this);
        employeeData.conectarBD();


        // mode = getIntent().getStringExtra(EXTRA_ADD_UPDATE);
        //  if (mode.equals("Update")) {

        //    guardar.setText("Modificar Empleado");
        //  empId = getIntent().getLongExtra(EXTRA_EMP_ID, 0);
        //initializeEmployee(empId);

//}


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (mode.equals("Agregar")) {

                newEmployee.setNombre(nombre.getText().toString());
                newEmployee.setApellidoP(apellidoP.getText().toString());
                newEmployee.setApellidoM(apellidoM.getText().toString());
                newEmployee.setTelefono(telefono.getText().toString());
                newEmployee.setCorreo(correo.getText().toString());
                newEmployee.setNacionalidad(nacionalidad.getText().toString());
                newEmployee.setFechaNacimieto(fechaNacimiento.getText().toString());
                newEmployee.setEstadoCivil(estadoCivil.getText().toString());
                newEmployee.setCalle(calle.getText().toString());
                newEmployee.setColonia(colonia.getText().toString());
                newEmployee.setCiudad(ciudad.getText().toString());
                newEmployee.setEstado(estado.getText().toString());
                newEmployee.setPais(pais.getText().toString());
                newEmployee.setNomina(Long.parseLong(nomina.getText().toString()));
                newEmployee.setPuesto(puesto.getText().toString());
                newEmployee.setRfc(rfc.getText().toString());
                newEmployee.setCurp(curp.getText().toString());
                newEmployee.setNss(Long.parseLong(nss.getText().toString()));
                newEmployee.setContacto(contacto.getText().toString());
                newEmployee.setEscolaridad(escolaridad.getText().toString());
                newEmployee.setEstatus(estatus.getText().toString());
                employeeData.AgregarEmpleado(newEmployee);
                Toast t = Toast.makeText(Form_Empleado.this, "Empleado " + newEmployee.getNombre() + "ha sido agregado!", Toast.LENGTH_SHORT);
                t.show();
                Intent i = new Intent(Form_Empleado.this, MainActivity.class);
                startActivity(i);


              /* } else {

                    oldEmployee.setNombre(nombre.getText().toString());
                    oldEmployee.setApellidoP(apellidoP.getText().toString());
                    oldEmployee.setApellidoM(apellidoM.getText().toString());
                    oldEmployee.setTelefono(telefono.getText().toString());
                    oldEmployee.setCorreo(correo.getText().toString());
                    oldEmployee.setNacionalidad(nacionalidad.getText().toString());
                    oldEmployee.setFechaNacimieto(fechaNacimiento.getText().toString());
                    oldEmployee.setEstadoCivil(estadoCivil.getText().toString());
                    oldEmployee.setCalle(calle.getText().toString());
                    oldEmployee.setColonia(colonia.getText().toString());
                    oldEmployee.setCiudad(ciudad.getText().toString());
                    oldEmployee.setEstado(estado.getText().toString());
                    oldEmployee.setPais(pais.getText().toString());
                    oldEmployee.setNomina(Long.parseLong(nomina.getText().toString()));
                    oldEmployee.setPuesto(puesto.getText().toString());
                    oldEmployee.setRfc(rfc.getText().toString());
                    oldEmployee.setCurp(curp.getText().toString());
                    oldEmployee.setNss(Long.parseLong(nss.getText().toString()));
                    oldEmployee.setContacto(contacto.getText().toString());
                    oldEmployee.setEscolaridad(escolaridad.getText().toString());
                    oldEmployee.setEstatus(estatus.getText().toString());
                    employeeData.ModificarEmpleado(oldEmployee);
                    Toast t = Toast.makeText(Form_Empleado.this, "Empleado " + oldEmployee.getNombre() + " ha sido modificado !", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(Form_Empleado.this, MainActivity.class);
                    startActivity(i);

                }*/
            }
        });
    }
/*
    private void initializeEmployee(long empId) {
        oldEmployee = employeeData.ObtenerEmpleado(empId);
        nombre.setText(oldEmployee.getNombre());
        apellidoP.setText(oldEmployee.getApellidoP());
        apellidoM.setText(oldEmployee.getApellidoM());
        telefono.setText(oldEmployee.getTelefono());
        correo.setText(oldEmployee.getCorreo());
        nacionalidad.setText(oldEmployee.getNacionalidad());
        fechaNacimiento.setText(oldEmployee.getFechaNacimieto());
        estadoCivil.setText(oldEmployee.getEstadoCivil());
        calle.setText(oldEmployee.getCalle());
        colonia.setText(oldEmployee.getColonia());
        ciudad.setText(oldEmployee.getCiudad());
        estado.setText(oldEmployee.getEstado());
        pais.setText(oldEmployee.getPais());
        nomina.setText((int) oldEmployee.getNomina());
        puesto.setText(oldEmployee.getPuesto());
        rfc.setText(oldEmployee.getRfc());
        curp.setText(oldEmployee.getCurp());
        nss.setText((int) oldEmployee.getNss());
        contacto.setText(oldEmployee.getContacto());
        escolaridad.setText(oldEmployee.getEscolaridad());
        estatus.setText(oldEmployee.getEstatus());


    }*/

}
