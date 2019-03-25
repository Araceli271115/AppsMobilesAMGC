package com.example.envioobjetos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<DatosPersona> lista_personas;
    private EditText edt_busqueda;
    private TextView txt_personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edt_busqueda = (EditText) findViewById(R.id.edt_busqueda);
        this.txt_personas = (TextView) findViewById(R.id.txt_personas);
        lista_personas = new ArrayList<>();

        //inicializar componentes


        //buscar objeto enviado desde activity VistaRapido
        if (getIntent().hasExtra("lista_personas")) { //preguntando si esta recibiendo lista_personas
            //vincularlo con lista local
            this.lista_personas = (ArrayList<DatosPersona>) getIntent().getExtras().getSerializable("lista_personas");
        }
        //mostrar las personas registradas
        this.muestra_personas();
    }

    public void registrar(View vista) {
        Intent ir = new Intent(this, VistaRapida.class);
        ir.putExtra("lista_personas", this.lista_personas);
        startActivity(ir);
    }


    private void muestra_personas() {

        if (this.lista_personas.isEmpty()) {
            txt_personas.setText("No hay personas registradas");
        } else {
            String lista_ = "";
            for (DatosPersona persona_temp : this.lista_personas) {
                lista_ += persona_temp.getNombre()
                        + " " + persona_temp.getApellidoP()
                        + " " + persona_temp.getApellidoM()
                        + "\n ________________________________ \n";
            }
            txt_personas.setText(lista_);
        }
    }

    public void buscar(View view) {
        if (this.lista_personas.isEmpty()) {
            Toast.makeText(this, "No hay elementos en la lista", Toast.LENGTH_LONG).show();
        } else {
            String encontrado = this.filtrar_personas();
            if (encontrado.length() > 0) {
                txt_personas.setText(encontrado);
            } else {
                Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show();
                this.muestra_personas();
            }
        }
    }

    private String filtrar_personas() {
        String coincidencias = "";
        return coincidencias;
    }
}
