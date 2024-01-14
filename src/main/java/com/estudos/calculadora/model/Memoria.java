package com.estudos.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
    }

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

    public void processarComando(String texto) {

        TipoComando tipoComando = detectarTipoComando(texto);

        if (texto.equals("AC")) {
            textoAtual = "";
        } else {
            textoAtual += texto;
        }

        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));

    }

    //TODO REFATORAR ESSE METODO
    private TipoComando detectarTipoComando(String texto) {

        if (textoAtual.isEmpty() && texto.equals("0")) {
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {

            if (texto.equals("AC")) {
                return TipoComando.ZERAR;
            } else if (texto.equals("/")) {
                return TipoComando.DIV;
            } else if (texto.equals("*")) {
                return TipoComando.MULT;
            } else if (texto.equals("+")) {
                return TipoComando.SOMA;
            } else if (texto.equals("-")) {
                return TipoComando.SUB;
            } else if (texto.equals("=")) {
                return TipoComando.IGUAL;
            } else if (texto.equals(",")) {
                return TipoComando.VIRGULA;
            }


        }

        return null;

    }

}
