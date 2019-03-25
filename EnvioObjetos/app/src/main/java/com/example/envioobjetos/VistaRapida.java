package com.example.envioobjetos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class VistaRapida extends AppCompatActivity {

    private ArrayList<DatosPersona> lista_personas;
    private EditText edt_nombre;
    private EditText edt_apellidoP;
    private EditText edt_apellidoM;
    private Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_rapida);

        edt_nombre = (EditText) findViewById(R.id.EditTextNombre);
        edt_apellidoP = (EditText) findViewById(R.id.EditTextApellidoP);
        edt_apellidoM = (EditText) findViewById(R.id.EditTextApellidoM);

        main = new Intent(this, MainActivity.class);

        //buscar objeto enviado desde activity VistaRapido
        if (getIntent().hasExtra("lista_personas")) { //preguntando si esta recibiendo lista_personas
            //vincularlo con lista local
            this.lista_personas = (ArrayList<DatosPersona>) getIntent().getExtras().getSerializable("lista_personas");
        }

    }

    public void guardar(View view) {
        if (!this.validar_vacios()) {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            lista_personas.add(new DatosPersona(
                    edt_nombre.getText().toString().trim(),
                    edt_apellidoP.getText().toString().trim(),
                    edt_apellidoM.getText().toString().trim()
                    //,Integer.valueOf(edt_edad.getText().toString().trim()
            ));
            main.putExtra("lista_personas", this.lista_personas);
            startActivity(main);
        }
    }

    public void cancelar(View view) {
        main.putExtra("lista_personas", this.lista_personas);
        startActivity(main);
    }

    private boolean validar_vacios() {
        return(edt_nombre.getText().toString().trim().length() > 0
                && edt_apellidoP.getText().toString().trim().length() > 0
                && edt_apellidoM.getText().toString().trim().length() > 0

        );
    }


}
