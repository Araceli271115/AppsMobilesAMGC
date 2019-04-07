package com.example.directorioempleado;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    DAOEmpleado dao;
    ArrayList<Empleado> lista;
    Empleado e;
    Button guardar ;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new DAOEmpleado(this);
        lista = dao.verTodos();
        list = (ListView) findViewById(R.id.Lista);
        guardar = (Button) findViewById(R.id.btnAgregarMiembro);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getApplicationContext(), Formulario_Empleado.class);
                startActivity(ir);
            }
        });


    }


}
