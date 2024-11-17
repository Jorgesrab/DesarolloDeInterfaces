package Practica3UT2;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioConVoz {
    private JFrame ventana;
    private JTextField campoNombre;
    private JTextField campoEmail;
    private JTextField campoMensaje;
    private JButton botonEnviar;

    public FormularioConVoz() {
        // Configurar el JFrame
        ventana = new JFrame("Formulario Controlado por Voz");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes del formulario
        JLabel etiquetaNombre = new JLabel("Nombre:");
        campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);

        JLabel etiquetaMensaje = new JLabel("Mensaje:");
        campoMensaje = new JTextField(20);

        botonEnviar = new JButton("Enviar");

        // Agregar componentes al frame
        ventana.add(etiquetaNombre);
        ventana.add(campoNombre);

        ventana.add(etiquetaEmail);
        ventana.add(campoEmail);

        ventana.add(etiquetaMensaje);
        ventana.add(campoMensaje);

        ventana.add(new JLabel()); // Espacio vacío
        ventana.add(botonEnviar);

        // Acción del botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarFormulario();
            }
        });

        ventana.setVisible(true);

        // Inicializar reconocimiento de voz
        try {
            iniciarReconocimientoVoz();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void enviarFormulario() {
        String nombre = campoNombre.getText();
        String email = campoEmail.getText();
        String mensaje = campoMensaje.getText();

        JOptionPane.showMessageDialog(ventana, "Formulario Enviado:\n" +
                "Nombre: " + nombre + "\n" +
                "Email: " + email + "\n" +
                "Mensaje: " + mensaje);
    }

    private void iniciarReconocimientoVoz() throws Exception {
        Configuration configuracion = new Configuration();

        // Configurar las rutas a los modelos acústicos, diccionario y modelo de lenguaje
        configuracion.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuracion.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuracion.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        LiveSpeechRecognizer reconocedor = new LiveSpeechRecognizer(configuracion);
        reconocedor.startRecognition(true);

        new Thread(() -> {
            SpeechResult resultado;
            while ((resultado = reconocedor.getResult()) != null) {
                String comando = resultado.getHypothesis();

                // Manejar comandos de voz
                if (comando.equalsIgnoreCase("enviar")) {
                    botonEnviar.doClick();
                } else {
                    System.out.println("Reconocido: " + comando);
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioConVoz());
    }
}