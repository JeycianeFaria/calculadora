package com.estudos.calculadora.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener {

    private final Color CINZA_ESCURO = new Color(68, 68, 68);
    private final Color CINZA_CLARO = new Color(99, 99, 99);
    private final Color LARANJA = new Color(242, 163, 60);


    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridwidth = 3;
        adicionarBotao("AC", CINZA_ESCURO, constraints, 0, 0);
        constraints.gridwidth = 1;
        adicionarBotao("/", LARANJA, constraints, 3, 0);

        adicionarBotao("7", CINZA_CLARO, constraints, 0, 1);
        adicionarBotao("8", CINZA_CLARO, constraints, 1, 1);
        adicionarBotao("9", CINZA_CLARO, constraints, 2, 1);
        adicionarBotao("*", LARANJA, constraints, 3, 1);

        adicionarBotao("4", CINZA_CLARO, constraints, 0, 2);
        adicionarBotao("5", CINZA_CLARO, constraints, 1, 2);
        adicionarBotao("6", CINZA_CLARO, constraints, 2, 2);
        adicionarBotao("-", LARANJA, constraints, 3, 2);

        adicionarBotao("1", CINZA_CLARO, constraints, 0, 3);
        adicionarBotao("2", CINZA_CLARO, constraints, 1, 3);
        adicionarBotao("3", CINZA_CLARO, constraints, 2, 3);
        adicionarBotao("+", LARANJA, constraints, 3, 3);

        constraints.gridwidth = 2;
        adicionarBotao("0", CINZA_CLARO, constraints, 0, 4);
        constraints.gridwidth = 1;
        adicionarBotao(",", CINZA_CLARO, constraints, 2, 4);
        adicionarBotao("=", LARANJA, constraints, 3, 4);

    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints constraints, int x, int y) {

        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);

        constraints.gridx = x;
        constraints.gridy = y;

        add(botao, constraints);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            System.out.println(botao.getText());
        }

    }
}
