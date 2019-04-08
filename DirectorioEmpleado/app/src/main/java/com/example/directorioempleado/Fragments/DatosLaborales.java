package com.example.directorioempleado.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.directorioempleado.R;


public class DatosLaborales extends Fragment {

    private EditText edtxtNomina;
    private EditText edtxtPuesto;
    private EditText edtxtRfc;
    private EditText edtxtCurp;
    private EditText edtxtNss;
    private EditText edtxtContacto;
    private EditText edtxtEscolaridad;
    private EditText edtxtEstatus;

    public DatosLaborales() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d_laborales, container, false);
        inicializarDatos(view);
        return view;
    }

    private void inicializarDatos(View view) {
        edtxtNomina = view.findViewById(R.id.EditTextNomina);
        edtxtNomina.setText(DetallesEmpleado.empleado.getNomina());

        edtxtPuesto = view.findViewById(R.id.EditTextPuesto);
        edtxtPuesto.setText(DetallesEmpleado.empleado.getPuesto());

        edtxtRfc = view.findViewById(R.id.EditTextRfc);
        edtxtRfc.setText(DetallesEmpleado.empleado.getRfc());

        edtxtCurp = view.findViewById(R.id.EditTextCurp);
        edtxtCurp.setText(DetallesEmpleado.empleado.getCurp());

        edtxtNss = view.findViewById(R.id.EditTextNss);
        edtxtNss.setText(DetallesEmpleado.empleado.getNss());

        edtxtContacto = view.findViewById(R.id.EditTextContacto);
        edtxtContacto.setText(DetallesEmpleado.empleado.getContacto());

        edtxtEscolaridad = view.findViewById(R.id.EditTextEscolaridad);
        edtxtEscolaridad.setText(DetallesEmpleado.empleado.getEscolaridad());

        edtxtEstatus = view.findViewById(R.id.EditTextEstatus);
        edtxtEstatus.setText(DetallesEmpleado.empleado.getEstatus());
    }


}
