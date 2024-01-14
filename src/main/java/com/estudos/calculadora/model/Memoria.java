package com.estudos.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private static final Memoria instancia = new Memoria();
    private final List<MemoriaObservador> observadores = new ArrayList<>();
    private String textoAtual = "";

    private Memoria() {
    }

    public static Memoria getInstance() {
        return instancia;
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void adicionarObservador(MemoriaObservador observador) {
        observadores.add(observador);
    }

    public void processarComando(String valor) {

        textoAtual += valor;
        observadores.forEach(o -> o.valorAlterado(textoAtual));

    }

}
