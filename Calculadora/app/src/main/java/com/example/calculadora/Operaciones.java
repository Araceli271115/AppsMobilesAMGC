package com.example.calculadora;

public class Operaciones {

    /**
     *
     *El siguiente método valida si un numero se encuentra dentro de un rango de numeros especificado
     * @param numero int numero con el cual se trabajara o verificara si se encuentra dentro de un rango
     * @param limiteInferior valor minimo en el que se puede encontrar el número
     * @param limiteSuperior valor maximo en el cual se puede encontrar el número
     * @return verdadero o falso si el numero fue encontrado o no
     */
    public boolean validarRango(int numero, int limiteInferior, int limiteSuperior){
        return numero >= limiteInferior && numero <= limiteSuperior;
    }



}
