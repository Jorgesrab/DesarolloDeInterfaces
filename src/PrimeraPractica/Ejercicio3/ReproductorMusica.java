package PrimeraPractica.Ejercicio3;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class ReproductorMusica {

    public static void main(String[] args) {
        // Creamos el Jframe del reproductor de musica
        JFrame reproductor = new JFrame("Reproductor de Música");


        reproductor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos un JPanel con GridLayout de 3 filas y 3 columnas
        JPanel panelBotones = new JPanel(new GridLayout(3, 3));

        // Nombramos  los botones del reproductor de música
        String[] nombresBotones = {
                "Play", "Pause", "Stop",
                "Siguiente", "Anterior", "Repetir",
                "Aleatorio", "Volumen +", "Volumen -"
        };//Lo hacemos con array para mayor comodidaz y limpieza de codigo

        // Añadimos los botones al JPanel con los nombres
        for (String nombre : nombresBotones) {
            // Crear botón con el nombre adecuado
            JButton boton = new JButton(nombre);
            // Añadimos el botón al panel
            panelBotones.add(boton);
        }

        // Añadimos el JPanel al JFrame
        reproductor.add(panelBotones);

        // Realizaamos .pack para ajustar el tamaño de la ventana
        reproductor.pack();


        reproductor.setVisible(true);
    }
}

