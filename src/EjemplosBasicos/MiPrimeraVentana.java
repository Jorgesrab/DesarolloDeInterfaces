package EjemplosBasicos;

import javax.swing.*;
import java.awt.*;

public class MiPrimeraVentana {
    public static void main(String[] args) {

        //Frame
        JFrame frame = new JFrame("Primera Ventana");

        //Forma del layout
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        // Para que se pare el programa al cerrar el frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tamaño del frame
        frame.setSize(600, 600);

        // Declaración de paneles
        JPanel panelFlow = new JPanel();
        panelFlow.setLayout(new FlowLayout());
        panelFlow.setBorder(BorderFactory.createTitledBorder("Flow layout"));

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 3, 10, 10));
        panelGrid.setBorder(BorderFactory.createTitledBorder("Grid layout"));

        // Declaración de un nuevo panel con GridBagLayout
        JPanel panelGridBag = new JPanel(new GridBagLayout());
        panelGridBag.setBorder(BorderFactory.createTitledBorder("GridBag layout"));



        // Declaración de botones y añadirlos en panelFlow
        JButton but = new JButton("Botón personalizable");
        panelFlow.add(new JButton("Botón 1"));
        panelFlow.add(new JButton("Botón 2"));
        panelFlow.add(but);

        // Campo de texto
        JTextField text = new JTextField(10);
        panelFlow.add(text);

        // Función para interactuar con el texto
        but.addActionListener(e -> text.setText("Primer textooooo"));

        // Declaración de botones y añadirlos en panelGrid
        JLabel genderLabel = new JLabel("  Género:");
        JRadioButton male = new JRadioButton("Masculino");
        JRadioButton female = new JRadioButton("Femenino");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        panelGrid.add(genderLabel);
        panelGrid.add(male);
        panelGrid.add(female);

        // GridBagConstraints para definir la disposición de los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Márgenes entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir componentes al panel con GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelGridBag.add(new JLabel("Nombre:"), gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField nameField = new JTextField(10);
        panelGridBag.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelGridBag.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField ageField = new JTextField(10);
        panelGridBag.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelGridBag.add(new JButton("Enviar"), gbc);

        // Añadir paneles al frame
        frame.add(panelFlow);
        frame.add(panelGrid);
        frame.add(panelGridBag);  // Añadir el nuevo panel con GridBagLayout

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
