package com.example.directorioempleado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.directorioempleado.BD.EmpleadoOperaciones;
import com.example.directorioempleado.Modelo.Empleado;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Button guardar;

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    EmpleadoOperaciones empleadosLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = (Button) findViewById(R.id.btnAgregarMiembro);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        Form_Empleado.class);
                i.putExtra("id", "0");
                i.putExtra("mod_add", "Agregar");

                startActivity(i);
            }
        });

        list = (ListView) findViewById(R.id.list_view);

        empleadosLista = new EmpleadoOperaciones(this);
        empleadosLista.conectarBD();

        // Pasar los resultados a la clase ListViewAdapter
        adapter = new ListViewAdapter(this, empleadosLista.ObtenerTodosEmpleados());

        // Enlaza el adaptador a la vista de lista
        list.setAdapter(adapter);

        // Localiza el EditText de listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        empleadosLista.desconectarBD();

        //////////////////////////////
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,
                        Vista_Rapida_Empleado.class);
                i.putExtra("id", adapter.getItem(position).getId());
                i.putExtra("nombre", adapter.getItem(position).getNombre());
                i.putExtra("apellidoP", adapter.getItem(position).getApellidoP());
                i.putExtra("apellidoM", adapter.getItem(position).getApellidoM());
                i.putExtra("nomina", adapter.getItem(position).getNomina());
                i.putExtra("telefono", adapter.getItem(position).getTelefono());
                i.putExtra("puesto", adapter.getItem(position).getPuesto());
                i.putExtra("estatus", adapter.getItem(position).getEstatus());
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
