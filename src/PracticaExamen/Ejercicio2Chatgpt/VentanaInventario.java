package PracticaExamen.Ejercicio2Chatgpt;

// VentanaInventario.java
import javax.swing.*;
import java.awt.*;

public class VentanaInventario extends JFrame {
    public VentanaInventario() {
        setTitle("Inventario de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Nombre", "Código", "Categoría", "Estado"};
        String[][] data = VentanaAgregarProducto.productos.stream()
                .map(p -> new String[]{p.getNombre(), p.getCodigo(), p.getCategoria(), p.isDisponible() ? "Disponible" : "No Disponible"})
                .toArray(String[][]::new);

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(scrollPane, gbc);
    }
}

