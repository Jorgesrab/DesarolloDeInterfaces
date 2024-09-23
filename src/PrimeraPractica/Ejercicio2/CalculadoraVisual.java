package PrimeraPractica.Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class CalculadoraVisual {

    public static void main(String[] args) {
        // Aqui configuramos la ventana
        JFrame ventana = new JFrame("Calculadora");
        ventana.setSize(300, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        // Aqui creamos un display separado de las teclas para la organizacion
        // y le añadimos el JTextField que en este caso estara vacio porque no es funcional
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        ventana.add(display, BorderLayout.NORTH);

        // Aqui creamos el panel GridLayout con la estructura de los botones de la calculadora
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // Aqui declaramos la cantidad de filas y columnas necesarias

        // Aqui los botones de la calculadora que se crean recorriendo el array con un for-each para mayor comodidad
        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Aqui agregamos los botones con el bucle
        for (String boton : botones) {
            JButton button = new JButton(boton);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(button);
        }

        // Añadimos el panel a la ventana
        ventana.add(panel);

        // mostramos la ventana
        ventana.setVisible(true);
    }
}
