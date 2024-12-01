package PracticaExamen.Ejercicio2Chatgpt;
// VentanaAgregarProducto.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaAgregarProductoAntiguo extends JFrame {
    private JTextField txtNombre, txtCodigo;
    private JComboBox<String> comboCategoria;
    private JCheckBox checkDisponible;

    public static ArrayList<Producto> productos = new ArrayList<>();

    public VentanaAgregarProductoAntiguo() {
        setTitle("Agregar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        txtNombre = new JTextField(15);
        txtCodigo = new JTextField(15);
        comboCategoria = new JComboBox<>(new String[]{"Electrónica", "Ropa", "Alimentos"});
        checkDisponible = new JCheckBox("Disponible/No Disponible");

        checkDisponible.addActionListener(e -> checkDisponible.setBackground(checkDisponible.isSelected() ? Color.GREEN : Color.RED));
        JButton btnGuardar = new JButton("Guardar");

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtNombre, gbc);

        // Código
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Código:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtCodigo, gbc);

        // Categoría
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Categoría:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(comboCategoria, gbc);

        // Estado
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Estado:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(checkDisponible, gbc);

        // Botón Guardar
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnGuardar, gbc);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String codigo = txtCodigo.getText();
            String categoria = (String) comboCategoria.getSelectedItem();
            boolean disponible = checkDisponible.isSelected();

            if (nombre.isEmpty() || codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y Código son obligatorios.");
            } else if (productos.stream().anyMatch(p -> p.getCodigo().equals(codigo))) {
                JOptionPane.showMessageDialog(this, "El código debe ser único.");
            } else {
                productos.add(new Producto(nombre, codigo, categoria, disponible));
                JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
                dispose();
            }
        });
    }
}