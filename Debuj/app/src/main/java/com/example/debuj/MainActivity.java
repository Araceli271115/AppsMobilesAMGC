package com.example.debuj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Integer> lista;
    Random numRandom;
    private int suma;
    private int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList();
        numRandom = new Random();
        suma =0;

        for (int i = 0; i <20 ; i++) {
            try{
              lista.add(numRandom.nextInt(50)+1);
            }catch(Exception e){
                System.out.println("No pudo crearse un número random");
            }
            suma =suma +  lista.get(i);
        }
        resultado=suma/20;


    }
}
