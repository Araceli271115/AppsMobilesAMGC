package com.example.conbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.conbd.Modelo.Categoria;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Categoria nuevo = new Categoria();
        nuevo.setNombre_categoria("Bebidas");
        nuevo.save(this);
    }
}
