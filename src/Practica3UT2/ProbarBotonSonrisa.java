package Practica3UT2;

import javax.swing.*;
import java.awt.*;

public class ProbarBotonSonrisa {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Prueba del Botón Sonrisa");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear una instancia del BotonSonrisa desde el JAR
        BotonSonrisa botonSonrisa = new BotonSonrisa("Acción (Sonríe para Activar)");
        botonSonrisa.setEnabled(false);  // Desactivar inicialmente el botón
        botonSonrisa.addActionListener(e -> {
            if (botonSonrisa.isSonrisaDetectada()) {
                JOptionPane.showMessageDialog(frame, "¡Botón Sonrisa pulsado! Realizando acción...");
            }
        });

        frame.add(botonSonrisa, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
