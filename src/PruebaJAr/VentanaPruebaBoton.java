package PruebaJAr;

// VentanaPruebaBoton.java
import javax.swing.*;
import java.awt.*;
import PruebaJAr.BotonPersonalizado;

public class VentanaPruebaBoton extends JFrame {
    public VentanaPruebaBoton() {
        setTitle("Prueba Botón Personalizado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        BotonPersonalizado botonPersonalizado = new BotonPersonalizado("Haz clic aquí");
        botonPersonalizado.addActionListener(e -> JOptionPane.showMessageDialog(this, "¡Botón Personalizado Pulsado!"));

        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(botonPersonalizado, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPruebaBoton().setVisible(true));
    }
}
