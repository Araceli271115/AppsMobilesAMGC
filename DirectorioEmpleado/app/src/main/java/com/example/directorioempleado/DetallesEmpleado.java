package com.example.directorioempleado;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class DetallesEmpleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomBar = findViewById(R.id.bottombar);


        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragmentSeleccionado = null;

                switch (menuItem.getItemId()){
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
