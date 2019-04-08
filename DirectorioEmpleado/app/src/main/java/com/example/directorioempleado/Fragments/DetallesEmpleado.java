package com.example.directorioempleado.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.directorioempleado.BD.EmpleadoOperaciones;
import com.example.directorioempleado.MainActivity;
import com.example.directorioempleado.Modelo.Empleado;
import com.example.directorioempleado.R;

public class DetallesEmpleado extends AppCompatActivity {

    public static Empleado empleado;
    EmpleadoOperaciones operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_empleado);

        operacion = new EmpleadoOperaciones(this);
        operacion.conectarBD();
        empleado =operacion.ObtenerEmpleado(Long.parseLong(getIntent().getExtras().getString("idEmpleado")));


                BottomNavigationView bottomBar = findViewById(R.id.bottombar);
        final Intent intent = new Intent(this, MainActivity.class);

        Fragment fragmentSeleccionado = new Foto();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragmentSeleccionado = null;

                switch (menuItem.getItemId()) {
                    case R.id.item_Foto:
                        fragmentSeleccionado = new Foto();
                        break;
                    case R.id.item_DPersonal:
                        fragmentSeleccionado = new DatosPersonales();

                        break;
                    case R.id.item_DLaboral:
                        fragmentSeleccionado = new DatosLaborales();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();
                return true;
            }
        });
    }
}
