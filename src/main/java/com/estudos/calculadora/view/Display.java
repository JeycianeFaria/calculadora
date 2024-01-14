package com.estudos.calculadora.view;

import com.estudos.calculadora.model.Memoria;
import com.estudos.calculadora.model.MemoriaObservador;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoriaObservador {

    //TODO pesquisar como diminuir tamanho dos numeros quando vamso adicionando muitos no display.

    private final JLabel label;

    public Display() {

        Memoria.getInstance().adicionarObservador(this);

        setBackground(new Color(40, 44, 52));

        label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 60));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 70));

        add(label);

    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }

}
