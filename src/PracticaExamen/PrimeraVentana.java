package PracticaExamen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import PracticaExamen.RegistroEmpleado;

public class PrimeraVentana extends JFrame {

    RegistroEmpleado registroEmpleado;
    public PrimeraVentana() {
        setTitle("Menu");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton agregarEmpleado = new JButton("Agregar Empleado");
        agregarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistroEmpleado().setVisible(true);

            }
        });

        JButton mostrarEmpleado = new JButton("Mostrar Empleado");
        mostrarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new VentanaMostrarEmpleados().setVisible(true);

            }
        });

        JButton salir = new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(agregarEmpleado);
        add(mostrarEmpleado);
        add(salir);
        setVisible(true);
    }


}
