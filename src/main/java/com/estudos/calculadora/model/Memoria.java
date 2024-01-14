package com.estudos.calculadora.model;

public class Memoria {

    private static final Memoria instancia = new Memoria();

    private String textoAtual = "";

    private Memoria() {
    }

    public static Memoria getInstance() {
        return instancia;
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

}
