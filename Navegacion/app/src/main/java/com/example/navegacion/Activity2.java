package com.example.navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void activity1(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        String nombre= getIntent().getExtras().getString("nombre");
        Toast toast = new Toast.makeText(this, nombre, Toast.LENGTH_LONG);
        toast.show();
    }
}
