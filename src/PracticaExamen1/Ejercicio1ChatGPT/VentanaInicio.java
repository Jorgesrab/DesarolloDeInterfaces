package PracticaExamen1.Ejercicio1ChatGPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {
    public VentanaInicio() {
        setTitle("Ventana de Registro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Declaración del JLabel con HTML para ajuste automático del texto
        JLabel descripcionLabel = new JLabel("<html><body style='width: 100%;'>Esto es una ventana, para proceder al registro dale al botón y observa cómo el texto se ajusta automáticamente.</body></html>");
        descripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(descripcionLabel);

           /*JTextArea descripcionArea = new JTextArea("Esto es una ventana, para proceder al registro dale al botón y observa cómo el texto se ajusta automáticamente.");
        descripcionArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        descripcionArea.setLineWrap(true); // Ajuste de línea
        descripcionArea.setWrapStyleWord(true); // Ajusta por palabra
        descripcionArea.setEditable(false); // No editable
        descripcionArea.setOpaque(false); // Hace que tenga fondo transparente como un JLabel
        add(descripcionArea);*/

        // Declaración del botón de registro
        JButton botonRegistro = new JButton("Registro");
        botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
        botonRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana de registro
                ventanaRegistro();
            }
        });
        add(botonRegistro);
    }

    // Declaración de componentes para la ventana de registro
    private JLabel ingreseNombre;
    private JTextField ingreseNombreTexto;
    private JLabel ingreseCorreo;
    private JTextField ingreseCorreoTexto;
    private JLabel ingreseTelefono;
    private JTextField ingreseTelefonoTexto;
    private JLabel ingreseContrasenia;
    private JPasswordField ingreseContraseniaTexto;
    private JComboBox<String> genero;
    private JList<String> preferencias;
    private JButton confirmarRegistro;

    // Creación de la segunda ventana
    private void ventanaRegistro() {
        JFrame ventanaRegistro = new JFrame("Ventana de Registro");
        ventanaRegistro.setSize(500, 400);
        ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Configuración de los campos
        ingreseNombre = new JLabel("Nombre:");
        ingreseNombreTexto = new JTextField(15);
        agregarComponente(ventanaRegistro, ingreseNombre, ingreseNombreTexto, gbc);

        ingreseCorreo = new JLabel("Correo:");
        ingreseCorreoTexto = new JTextField(15);
        agregarComponente(ventanaRegistro, ingreseCorreo, ingreseCorreoTexto, gbc);

        ingreseTelefono = new JLabel("Teléfono:");
        ingreseTelefonoTexto = new JTextField(15);
        agregarComponente(ventanaRegistro, ingreseTelefono, ingreseTelefonoTexto, gbc);

        ingreseContrasenia = new JLabel("Contraseña:");
        ingreseContraseniaTexto = new JPasswordField(15);
        agregarComponente(ventanaRegistro, ingreseContrasenia, ingreseContraseniaTexto, gbc);

        JLabel generoLabel = new JLabel("Género:");
        genero = new JComboBox<>(new String[]{"Masculino", "Femenino", "No binario", "Otro"});
        agregarComponente(ventanaRegistro, generoLabel, genero, gbc);

        JLabel preferenciasLabel = new JLabel("Preferencias:");
        preferencias = new JList<>(new String[]{"Noticias", "Deportes", "Tecnología", "Entretenimiento"});
        preferencias.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        preferencias.setVisibleRowCount(3);
        JScrollPane scrollPane = new JScrollPane(preferencias);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy++;
        ventanaRegistro.add(preferenciasLabel, gbc);
        gbc.gridy++;
        ventanaRegistro.add(scrollPane, gbc);

        // Botón de Confirmar Registro
        confirmarRegistro = new JButton("Confirmar Registro");
        confirmarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    ventanaRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente");
                }
            }
        });
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy++;
        ventanaRegistro.add(confirmarRegistro, gbc);

        // Mostrar la ventana de registro
        ventanaRegistro.setVisible(true);
    }

    // Método para agregar componentes de manera ordenada en la ventana de registro
    private void agregarComponente(JFrame frame, JLabel label, JComponent component, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        frame.add(label, gbc);
        gbc.gridx = 1;
        frame.add(component, gbc);
    }

    // Validación de campos
    private boolean validarCampos() {
        if (ingreseNombreTexto.getText().isEmpty() ||
                ingreseCorreoTexto.getText().isEmpty() ||
                ingreseTelefonoTexto.getText().isEmpty() ||
                ingreseContraseniaTexto.getPassword().length == 0 ||
                genero.getSelectedIndex() == -1 ||
                preferencias.isSelectionEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        VentanaInicio app = new VentanaInicio();
        app.setVisible(true);
    }
}
