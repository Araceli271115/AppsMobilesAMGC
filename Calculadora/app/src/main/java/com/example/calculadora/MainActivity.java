package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho,
            btnNueve, btnDel, btnAc, btnPorcentaje, btnFactorial, btnRaiz, btnExpo,
            btnSuma, btnResta, btnMultiplica, btnDivide, btnPunto, btnIgual;

    TextView pantallaCaptura;
    String valorIngresado = "";
    String valorIngresado2 = "";
    double resultado;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDel = R.id.Del;
        btnAc = R.id.Ac;
        btnPorcentaje = R.id.Porcentaje;
        btnFactorial = R.id.Factorial;
        btnRaiz = R.id.Raiz;
        btnExpo = R.id.Exponente;
        btnSuma = R.id.Mas;
        btnResta = R.id.Menos;
        btnMultiplica = R.id.Multiplicar;
        btnDivide = R.id.Division;
        btnPunto = R.id.Punto;
        btnIgual = R.id.Resultado;
        pantallaCaptura = (TextView) findViewById(R.id.Entrada);
    }


    public void numeros(View view) {
        switch (view.getId()) {
            case R.id.Cero:
                valorIngresado = valorIngresado + "0";
                break;
            case R.id.Uno:
                valorIngresado = valorIngresado + "1";
                break;
            case R.id.Dos:
                valorIngresado = valorIngresado + "2";
                break;
            case R.id.Tres:
                valorIngresado = valorIngresado + "3";
                break;
            case R.id.Cuatro:
                valorIngresado = valorIngresado + "4";
                break;
            case R.id.Cinco:
                valorIngresado = valorIngresado + "5";
                break;
            case R.id.Seis:
                valorIngresado = valorIngresado + "6";
                break;
            case R.id.Siete:
                valorIngresado = valorIngresado + "7";
                break;
            case R.id.Ocho:
                valorIngresado = valorIngresado + "8";
                break;
            case R.id.Nueve:
                valorIngresado = valorIngresado + "9";
                break;
            case R.id.Punto:
                valorIngresado = valorIngresado + ".";
                break;
        }
        pantallaCaptura.setText(valorIngresado);
    }

    public void operaciones(View view) {
        switch (view.getId()) {
            case R.id.Mas:
                operador = "+";
                break;
            case R.id.Menos:
                operador = "-";
                break;
            case R.id.Multiplicar:
                operador = "*";
                break;
            case R.id.Division:
                operador = "/";
                break;
            case R.id.Exponente:
                operador = "exponente";
                break;
            case R.id.Raiz:
                operador = "raiz";
                break;
            case R.id.Factorial:
                operador = "factorial";
                break;
        }
        valorIngresado2 = valorIngresado;
        valorIngresado = "";
    }

    public void resultado(View view) {

        if (!operador.equals("") && !valorIngresado2.equals("") && !valorIngresado.equals("")) {
            switch (operador) {
                case "+":
                    resultado = Double.parseDouble(valorIngresado2) + Double.parseDouble(valorIngresado);
                    break;
                case "-":
                    resultado = Double.parseDouble(valorIngresado2) - Double.parseDouble(valorIngresado);
                    break;
                case "*":
                    resultado = Double.parseDouble(valorIngresado2) * Double.parseDouble(valorIngresado);
                    break;
                case "/":
                    resultado = Double.parseDouble(valorIngresado2) / Double.parseDouble(valorIngresado);
                    break;
                case "exponente":
                    resultado = (Double) Math.pow(Double.parseDouble(valorIngresado2), Double.parseDouble(valorIngresado));
                    break;
                case "raiz":
                    resultado = (Double) Math.pow(Double.parseDouble(valorIngresado), (1 / Double.parseDouble(valorIngresado2)));
                    break;

            }
            if (operador.equals( "factorial") && valorIngresado.equals("")) { // no puede ir un numero despues de factorial
                resultado = 1;
                for (int i = Integer.parseInt(valorIngresado2); i > 0; i--) {
                    resultado = resultado * i;
                }
            }else{
                Toast.makeText(MainActivity.this, "Error Ingresaste un valor despues del signo factorial ", Toast.LENGTH_LONG).show();
            }


            pantallaCaptura.setText("" + resultado); // se imprime el resultado el la pantalla
            valorIngresado = resultado+"";  // para que el valor se quede guardado

        } else {
            Toast.makeText(MainActivity.this, "Error ", Toast.LENGTH_LONG).show();
        }


    }


    public void borrado(View view) {
        valorIngresado = pantallaCaptura.getText().toString();
        switch (view.getId()) {
            case R.id.Ac:
                valorIngresado = "";
                valorIngresado2 = "";
                operador = "";
                resultado = 0;
                break;
            case R.id.Del:
                if (!valorIngresado.equals("")) {  // marcaba error porque ya no encontraba subString
                    if (valorIngresado.equals(resultado + "")) {    //no puede borrrar si es el resultado
                        Toast.makeText(MainActivity.this, "Error no puedes eliminar elementos del resultado", Toast.LENGTH_LONG).show();
                    } else {
                        valorIngresado = valorIngresado.substring(0, valorIngresado.length() - 1);
                        break;
                    }
                }
        }
        pantallaCaptura.setText(valorIngresado);
    }
}
