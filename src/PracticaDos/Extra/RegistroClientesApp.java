package PracticaDos.Extra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistroClientesApp extends JFrame {



    public RegistroClientesApp() {
        // Aquí creo la ventana inicial que luego lleva a la otra
        setTitle("Sistema de Registro");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Este botón es el que hace que se abra la otra ventana
        JButton registrarNuevoBtn = new JButton("Registrar Nuevo Cliente");
        registrarNuevoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al presionar el botón abre la ventana
                abrirVentanaRegistro();
            }
        });

        // Con esto se añade el botón a la ventana inicial
        add(registrarNuevoBtn);
    }

    // Aqui declaro los componentes de la interfaz para la segunda ventana
    private JTextField nombreField, correoField;
    private JComboBox<String> tipoClienteCombo;
    private JCheckBox aceptaTerminos;
    private JButton confirmarRegistro;

    // Esta es la función que crea la nueva ventana para registrar un cliente
    private void abrirVentanaRegistro() {
        JFrame registroFrame = new JFrame("Registro de Nuevo Cliente");
        registroFrame.setSize(400, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(5, 2));

        // Aquí creo los componentes para la nueva ventana
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        nombreField.setToolTipText("Ingrese su nombre");

        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField();
        correoField.setToolTipText("Ingrese un correo válido");

        // Esto cambia el color del campo de correo cuando gana o pirde el foco
        correoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                correoField.setBackground(Color.YELLOW);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoField.setBackground(Color.WHITE);
            }
        });

        JLabel tipoClienteLabel = new JLabel("Tipo de Cliente:");
        tipoClienteCombo = new JComboBox<>(new String[]{"Regular", "Premium", "VIP"});

        aceptaTerminos = new JCheckBox("Acepto los términos y condiciones");

        // Esto habilita el botón de confirmar cuando los campos son válidos
        aceptarTerminosListener(registroFrame);

        confirmarRegistro = new JButton("Confirmar Registro");
        confirmarRegistro.setEnabled(false); // Lo dejo inicialmente desactivado

        // Añadir componentes a la ventana de registro
        registroFrame.add(nombreLabel);
        registroFrame.add(nombreField);
        registroFrame.add(correoLabel);
        registroFrame.add(correoField);
        registroFrame.add(tipoClienteLabel);
        registroFrame.add(tipoClienteCombo);
        registroFrame.add(aceptaTerminos);
        registroFrame.add(confirmarRegistro);

        // Mostrar la ventana de registro
        registroFrame.setVisible(true);
    }

    // Esto controla la activación del botón Confirmar Registro
    private void aceptarTerminosListener(JFrame registroFrame) {
        aceptaTerminos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean nombreLleno = !nombreField.getText().isEmpty();
                boolean correoLleno = !correoField.getText().isEmpty();
                boolean tipoSeleccionado = tipoClienteCombo.getSelectedIndex() != -1;
                boolean terminosAceptados = aceptaTerminos.isSelected();

                // Habilitar el botón si todos los campos son correctos
                if (nombreLleno && correoLleno && tipoSeleccionado && terminosAceptados) {
                    confirmarRegistro.setEnabled(true);
                } else if (!terminosAceptados) {
                    JOptionPane.showMessageDialog(null, "Debe aceptar los términos para continuar");
                    confirmarRegistro.setEnabled(false);
                }

                // Añadir listener al botón de confirmar registro
                confirmarRegistro.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Validación del correo al confirmar
                        if (validarCorreo(correoField.getText())) {
                            JOptionPane.showMessageDialog(null, "Registro exitoso.");//con esto muestro un pequeño cuadro de texto con el mensaje pertinente
                            registroFrame.dispose();  // Cierra la ventana de registro si to do es correcto (tengo que poner to do separado pq si no sale en verde )
                        } else {
                            JOptionPane.showMessageDialog(null, "El correo no tiene un formato válido.");
                        }
                    }
                });
            }
        });
    }

    // Validación del formato del correo electrónico
    private boolean validarCorreo(String correo) {
        // Esta es la expresion regular que he sacado de internet para validar el correo
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);// esto es un amanera que he encontrado en internet de verificar que el correo coincida con la expresion regular
        if (correo == null)
            return false;
        return pat.matcher(correo).matches();
    }

    public static void main(String[] args) {
        RegistroClientesApp app = new RegistroClientesApp();
        app.setVisible(true);
    }
}
