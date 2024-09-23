package PracticaDos;

// Guía de usuario usuario:
// Esta aplicacion registra ciertas acciones y las muetra luego por pantalla en la caja de texto, esas acciones son las siguientes:
// 1 Presionar o liberar una tecla en el campo de texto.
// 2 Entrar o salir del campo de texto con el ratón.
// 3 Entrar o salir de la caja de texto con el ratón.
// 4 Presionar un boton el cual muestras lo que este escrito en el campo de texto .
// 5 Detectar cuando la ventana está activa o inactiva.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPracticaDosJorge extends JFrame {

    private JTextField campoTexto;
    private JTextArea cajaTexto;
    private JButton boton;

    public MainPracticaDosJorge() {
        // Aqui se configura la ventana orincipal
        setTitle("Práctica 2 UT2 DAM2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Iniciamos todos los componentes
        campoTexto = new JTextField(20); // Este es el campo donde escribe el usuario
        cajaTexto = new JTextArea(10, 30); // En este se muestran todas las acciones
        boton = new JButton("Clic aquí"); // Y este es el boton que se preciona

        // Aqui agregamos los listeners para el campo de texto
        campoTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                cajaTexto.append("Tecla presionada: " + e.getKeyChar() + "\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cajaTexto.append("Tecla liberada: " + e.getKeyChar() + "\n");
            }
        });

        campoTexto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cajaTexto.append("Ratón entra en el campo de texto\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cajaTexto.append("Ratón sale del campo de texto\n");
            }
        });

        // Listener del boton
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de texto y mostrarlo en la caja de texto
                String textoCampo = campoTexto.getText();
                cajaTexto.append("Texto en el campo: " + textoCampo + "\n");
            }
        });

        // Listeners de la caja de texto
        cajaTexto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cajaTexto.append("Ratón entra en la caja de texto\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cajaTexto.append("Ratón sale de la caja de texto\n");
            }
        });

        // Aqui desactivo la edicion de la caja de texto
        cajaTexto.setEditable(false);

        // Aqui pongo para que las barras del scroll se muestren siempre
        JScrollPane scrollPane = new JScrollPane(cajaTexto);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Agregamos los componentes a la ventana
        add(campoTexto);
        add(boton);
        add(scrollPane);

        // Aqui agrego un WindowFocusListener para detectar cuando la ventana esta en foco y cuando deja de estarlo
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                cajaTexto.append("La ventana está activa\n");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                cajaTexto.append("La ventana ha perdido el foco\n");
            }
        });

        // Aqui hago vivible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Iniciar la aplicación
        new MainPracticaDosJorge();
    }
}
