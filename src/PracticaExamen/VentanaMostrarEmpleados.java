package PracticaExamen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMostrarEmpleados extends JFrame {

    private JTable tablaEmpleados;
    private JButton retroceder;

    public VentanaMostrarEmpleados() {
        
        RegistroEmpleado registroEmpleado = new RegistroEmpleado();
        
        
        ArrayList<String> empleados = registroEmpleado.getEmpleados();
        
        setTitle("Lista de Empleados");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        String[] columnNames = {"Nombre", "Apellido", "Departamento", "Estado"};
        String[][] data = new String[empleados.size()][4];

        for (int i = 0; i < empleados.size(); i++) {
            String[] detalles = empleados.get(i).split(" ");
            if (detalles.length == 4) {
                data[i] = detalles;
            }
        }

        tablaEmpleados = new JTable(data, columnNames);
        add(new JScrollPane(tablaEmpleados), BorderLayout.CENTER);

        // Botón para retroceder
        retroceder = new JButton("Retroceder");
        retroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(retroceder, BorderLayout.SOUTH);
    }
}