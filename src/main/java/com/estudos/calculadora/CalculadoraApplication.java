package com.estudos.calculadora;

import com.estudos.calculadora.view.Display;
import com.estudos.calculadora.view.Teclado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class CalculadoraApplication extends JFrame {

    public CalculadoraApplication() {

        organizarLayout();

        setSize(417, 579);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void organizarLayout() {

        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(417, 150));
        add(display, BorderLayout.NORTH);

        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApplication.class, args);
    }

}
