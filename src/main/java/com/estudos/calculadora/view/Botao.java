package com.estudos.calculadora.view;

import javax.swing.*;
import java.awt.*;

public class Botao extends JButton {

    public Botao(String texto, Color cor) {

        setText(texto);
        setFont(new Font("courier", Font.PLAIN, 50));
        setOpaque(true);
        setBackground(cor);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
