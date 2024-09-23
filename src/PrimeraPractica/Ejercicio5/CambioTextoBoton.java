package PrimeraPractica.Ejercicio5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioTextoBoton {

    public static void main(String[] args) {
        // Creamos el JFrame principal
        JFrame ventana = new JFrame("Cambio de texto en el botón");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 150); // Establecemos el tamaño de la ventana

        // Creamos el botón con el texto inicial
        JButton boton = new JButton("Haz clic aquí");

        // Añadimos el botón a la ventana
        ventana.add(boton);

        // Hacemos visible la ventana
        ventana.setVisible(true);

        // Definimos la acción al hacer clic en el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiamos el texto del botón cuando se hace clic
                boton.setText("Texto cambiado ");
            }
        });
    }
}
