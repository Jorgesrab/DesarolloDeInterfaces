package PrimeraPractica.Ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDatos {

    public static void main(String[] args) {
        // Creamos el JFrame principal
        JFrame ventanaPrincipal = new JFrame("Introducción de Datos");

        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new GridLayout(3, 2)); // Usamos GridLayout para organizar los componentes

        // Creamos las etiquetas para el nombre y apellidos
        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(); // Campo para introducir el nombre
        JLabel etiquetaApellidos = new JLabel("Apellidos:");
        JTextField campoApellidos = new JTextField(); // Campo para introducir los apellidos

        // Creamos el botón "Enviar"
        JButton botonEnviar = new JButton("Enviar");

        // Añadimos los componentes al JFrame principal
        ventanaPrincipal.add(etiquetaNombre);
        ventanaPrincipal.add(campoNombre);
        ventanaPrincipal.add(etiquetaApellidos);
        ventanaPrincipal.add(campoApellidos);
        ventanaPrincipal.add(new JLabel()); // Espacio vacío para que el boton enviar este en su sitio
        ventanaPrincipal.add(botonEnviar);

        // Establecer el tamaño inicial de la ventana principal
        ventanaPrincipal.setSize(400, 200);

        // Centrar la ventana principal en la pantalla
        ventanaPrincipal.setLocationRelativeTo(null);


        ventanaPrincipal.setVisible(true);

        // Definir la acción al pulsar el botón "Enviar"
        botonEnviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Crear la segunda ventana que mostrará "Datos enviados"
                JFrame ventanaSecundaria = new JFrame("Confirmación");
                ventanaSecundaria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventanaSecundaria.setLayout(new BorderLayout());

                // Crear el mensaje "Datos enviados"
                JLabel mensaje = new JLabel("Datos enviados", SwingConstants.CENTER);

                // Crear el botón "Cerrar"
                JButton botonCerrar = new JButton("Cerrar");

                // Añadimos el mensaje y el botón a la ventana secundaria
                ventanaSecundaria.add(mensaje, BorderLayout.CENTER);
                ventanaSecundaria.add(botonCerrar, BorderLayout.SOUTH);

                // Establecer el tamaño de la ventana secundaria
                ventanaSecundaria.setSize(300, 150); // Hacemos la ventana secundaria un poco más grande

                // Centrar la ventana secundaria en la pantalla
                ventanaSecundaria.setLocationRelativeTo(null);

                // Hacer visible la ventana secundaria
                ventanaSecundaria.setVisible(true);

                // Definir la acción del botón "Cerrar" para cerrar la ventana secundaria
                botonCerrar.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        ventanaSecundaria.dispose(); // Cierra la ventana secundaria
                    }
                });
            }
        });
    }
}
