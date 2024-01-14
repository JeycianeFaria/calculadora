package com.estudos.calculadora.model;

@FunctionalInterface
public interface MemoriaObservador {

    void valorAlterado(String novoValor);

}
