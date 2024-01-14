package com.estudos.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
    }

    private static final Memoria instancia = new Memoria();
    private final List<MemoriaObservador> observadores = new ArrayList<>();
    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";

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

        if (tipoComando == null) {
            return;
        } else if (tipoComando.equals(TipoComando.ZERAR)) {
            textoAtual = "";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        } else if (tipoComando.equals(TipoComando.NUMERO) || tipoComando.equals(TipoComando.VIRGULA)) {
            textoAtual = substituir ? texto : textoAtual + texto;
            substituir = false;
        } else {
            substituir = true;
            textoAtual = obterResultadoOperacao();
            textoBuffer = textoAtual;
            ultimaOperacao = tipoComando;
        }

        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));

    }

    //TODO REFATORAR ESSE METODO
    private String obterResultadoOperacao() {
        if (ultimaOperacao == null || ultimaOperacao.equals(TipoComando.IGUAL)) {
            return textoAtual;
        }

        double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
        double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
        double resultado = 0;

        if (ultimaOperacao.equals(TipoComando.SOMA)) {
            resultado = numeroBuffer + numeroAtual;
        } else if (ultimaOperacao.equals(TipoComando.SUB)) {
            resultado = numeroBuffer - numeroAtual;
        } else if (ultimaOperacao.equals(TipoComando.MULT)) {
            resultado = numeroBuffer * numeroAtual;
        } else if (ultimaOperacao.equals(TipoComando.DIV)) {
            resultado = numeroBuffer / numeroAtual;
        }

        String resultadoString = Double.toString(resultado).replace(".", ",");

        boolean inteiro = resultadoString.endsWith(",0");

        return inteiro ? resultadoString.replace(",0", "") : resultadoString;
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
            } else if (texto.equals(",") && !textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            }


        }

        return null;

    }

}
