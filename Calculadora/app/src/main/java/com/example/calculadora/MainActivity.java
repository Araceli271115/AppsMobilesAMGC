package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCero,btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho,
            btnNueve, btnDel,btnAc, btnA, btnPorcentaje, btnFactorial, btnRaiz, btnExpo,
            btnSuma, btnResta, btnMultiplica, btnDivide, btnPunto, btnIgual;
    TextView mostrarResultado;
    TextView captura;
    String entradaPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCero=(Button)findViewById(R.id.Cero);
        btnUno = (Button)findViewById(R.id.Uno);
        btnDos = (Button)findViewById(R.id.Dos);
        btnTres = (Button)findViewById(R.id.Tres);
        btnCuatro = (Button)findViewById(R.id.Cuatro);
        btnCinco = (Button)findViewById(R.id.Cinco);
        btnSeis = (Button)findViewById(R.id.Seis);
        btnSiete = (Button)findViewById(R.id.Siete);
        btnOcho = (Button)findViewById(R.id.Ocho);
        btnNueve = (Button)findViewById(R.id.Nueve);
        btnDel = (Button)findViewById(R.id.Del);
        btnAc = (Button)findViewById(R.id.Ac);
        btnA = (Button)findViewById(R.id.A);
        btnPorcentaje = (Button)findViewById(R.id.Porcentaje);
        btnFactorial = (Button)findViewById(R.id.Factorial);
        btnRaiz = (Button)findViewById(R.id.Raiz);
        btnExpo = (Button)findViewById(R.id.Exponente);
        btnSuma = (Button)findViewById(R.id.Mas);
        btnResta = (Button)findViewById(R.id.Menos);
        btnMultiplica = (Button)findViewById(R.id.Multiplicar);
        btnDivide = (Button)findViewById(R.id.Division);
        btnPunto = (Button)findViewById(R.id.Punto);
        btnIgual = (Button)findViewById(R.id.Resultado);
        mostrarResultado = (TextView)findViewById(R.id.Res);
        captura = (TextView)findViewById(R.id.Entrada);


     btnUno.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             entradaPantalla = mostrarResultado.getText().toString();
             entradaPantalla = entradaPantalla + "1";
             captura.setText(entradaPantalla);
         }
     });
    }
}
