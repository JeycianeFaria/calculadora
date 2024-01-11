package com.estudos.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CalculadoraApplication extends JFrame {

    public CalculadoraApplication(){

        setSize(417,579);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApplication.class, args);
    }

}
