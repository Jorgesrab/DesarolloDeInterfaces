package PracticaExamen.Ejercicio2Chatgpt;


// VentanaPrincipal.java
import javax.swing.*;
        import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Gestión de Inventario");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton btnAgregarProducto = new JButton("Agregar Nuevo Producto");
        JButton btnVerInventario = new JButton("Ver Inventario");
        JButton btnSalir = new JButton("Salir");

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnAgregarProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnVerInventario, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnSalir, gbc);

        btnAgregarProducto.addActionListener(e -> new VentanaAgregarProducto().setVisible(true));
        btnVerInventario.addActionListener(e -> new VentanaInventario().setVisible(true));
        btnSalir.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));

    }
}