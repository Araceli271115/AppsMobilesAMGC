package com.example.directorioempleado.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.directorioempleado.R;

public class DatosPersonales extends Fragment {
    private EditText edtxtNombre;
    private EditText edtxtApellidoP;
    private EditText edtxtApellidoM;
    private EditText edtxtTelefono;
    private EditText edtxtCorreo;
    private EditText edtxtNacionalidad;
    private EditText edtxtFechaNac;
    private EditText edtxtEstadoCivil;
    private EditText edtxtCalle;
    private EditText edtxtColonia;
    private EditText edtxtCiudad;
    private EditText edtxtEstado;
    private EditText edtxtPais;


    public DatosPersonales() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d_personales, container, false);
        inicializarDatos(view);
        return view;
    }

    private void inicializarDatos(View view) {
        edtxtNombre = view.findViewById(R.id.EditTextNombre);
        edtxtNombre.setText(DetallesEmpleado.empleado.getNombre());

        edtxtApellidoP = view.findViewById(R.id.EditTextApellidoP);
        edtxtApellidoP.setText(DetallesEmpleado.empleado.getApellidoP());

        edtxtApellidoM = view.findViewById(R.id.EditTextApellidoM);
        edtxtApellidoM.setText(DetallesEmpleado.empleado.getApellidoM());

        edtxtTelefono = view.findViewById(R.id.EditTextTelefono);
        edtxtTelefono.setText(DetallesEmpleado.empleado.getTelefono());

        edtxtCorreo = view.findViewById(R.id.EditTextCorreo);
        edtxtCorreo.setText(DetallesEmpleado.empleado.getCorreo());

        edtxtNacionalidad = view.findViewById(R.id.EditTextNacionalidad);
        edtxtNacionalidad.setText(DetallesEmpleado.empleado.getNacionalidad());

        edtxtFechaNac = view.findViewById(R.id.EditTextFechaNacimiento);
        edtxtFechaNac.setText(DetallesEmpleado.empleado.getFechaNacimieto());

        edtxtEstadoCivil = view.findViewById(R.id.EditTextEstadoCivil);
        edtxtEstadoCivil.setText(DetallesEmpleado.empleado.getEstadoCivil());

        edtxtCalle = view.findViewById(R.id.EditTextCalle);
        edtxtCalle.setText(DetallesEmpleado.empleado.getCalle());

        edtxtColonia = view.findViewById(R.id.EditTextColonia);
        edtxtColonia.setText(DetallesEmpleado.empleado.getColonia());

        edtxtCiudad = view.findViewById(R.id.EditTextCiudad);
        edtxtCiudad.setText(DetallesEmpleado.empleado.getCiudad());

        edtxtEstado = view.findViewById(R.id.EditTextEstado);
        edtxtEstado.setText(DetallesEmpleado.empleado.getEstado());

        edtxtPais = view.findViewById(R.id.EditTextPais);
        edtxtPais.setText(DetallesEmpleado.empleado.getPais());

    }

}
