package com.example.directorioempleado;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    ArrayList<Empleado> lista;
    DAOEmpleado dao;
    Empleado e;
    Activity a;

    public Adaptador( Activity a,ArrayList<Empleado> lista, DAOEmpleado dao) {
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Empleado getItem(int i) {
        e = lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        e = lista.get(i);
        return e.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v = view;
        if (v != null) {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.vistarapida, null);
        }
        e = lista.get(posicion);
        TextView id = (TextView) v.findViewById(R.id.TextViewId);
        TextView nombre = (TextView) v.findViewById(R.id.TextViewNombre);
        TextView apellidoP = (TextView) v.findViewById(R.id.TextViewApellidoP);
        TextView apellidoM = (TextView) v.findViewById(R.id.TextViewApellidoP);
        TextView telefono = (TextView) v.findViewById(R.id.TextViewTelefono);
        TextView correo = (TextView) v.findViewById(R.id.TextViewCorreo);
        TextView nacionalidad = (TextView) v.findViewById(R.id.TextViewNacionalidad);
        TextView fechaNacimiento = (TextView) v.findViewById(R.id.TextViewFechaNacimiento);
        TextView estadoCivil = (TextView) v.findViewById(R.id.TextViewEstadoCivil);
        TextView calle = (TextView) v.findViewById(R.id.TextViewCalle);
        TextView colonia = (TextView) v.findViewById(R.id.TextViewColonia);
        TextView ciudad = (TextView) v.findViewById(R.id.TextViewCiudad);
        TextView estado = (TextView) v.findViewById(R.id.TextViewEstado);
        TextView pais = (TextView) v.findViewById(R.id.TextViewPais);
        TextView nomina = (TextView) v.findViewById(R.id.TextViewNomina);
        TextView puesto = (TextView) v.findViewById(R.id.TextViewPuesto);
        TextView rfc = (TextView) v.findViewById(R.id.TextViewRfc);
        TextView curp = (TextView) v.findViewById(R.id.TextViewCurp);
        TextView nss = (TextView) v.findViewById(R.id.TextViewNss);
        TextView contacto = (TextView) v.findViewById(R.id.TextViewContacto);
        TextView escolaridad = (TextView) v.findViewById(R.id.TextViewEscolaridad);
        TextView estatus = (TextView) v.findViewById(R.id.TextViewEstatus);
        Button detalles = (Button) v.findViewById(R.id.buttonDetalles);
        Button editar = (Button) v.findViewById(R.id.buttonModificar);
        Button eliminar = (Button) v.findViewById(R.id.buttonEliminar);
        Button atras = (Button) v.findViewById(R.id.btnRegresar);
        id.setText(e.getId());
        nombre.setText(e.getId());
        apellidoP.setText(e.getId());
        apellidoM.setText(e.getId());
        telefono.setText(e.getId());
        correo.setText(e.getId());
        nacionalidad.setText(e.getId());
        fechaNacimiento.setText(e.getId());
        estadoCivil.setText(e.getId());
        calle.setText(e.getId());
        colonia.setText(e.getId());
        ciudad.setText(e.getId());
        estado.setText(e.getId());
        pais.setText(e.getId());
        nomina.setText(e.getId());
        puesto.setText(e.getId());
        rfc.setText(e.getId());
        curp.setText(e.getId());
        nss.setText(e.getId());
        contacto.setText(e.getId());
        escolaridad.setText(e.getId());
        estatus.setText(e.getId());
        detalles.setTag(posicion);
        editar.setTag(posicion);
        eliminar.setTag(posicion);
        atras.setTag(posicion);

        detalles.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        editar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}
