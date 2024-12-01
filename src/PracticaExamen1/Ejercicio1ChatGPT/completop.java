package PracticaExamen1.Ejercicio1ChatGPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class completop extends JFrame {

    private static ArrayList<String>Empleados =new ArrayList<>();

    public completop() {
        setTitle("Menu");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));

        JButton agregarEmpleado = new JButton("Agregar Empleado");
        agregarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registroEmpleado();
                setEnabled(false);
            }
        });

        JButton mostrarEmpleado = new JButton("Mostrar Empleado");
        mostrarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

    public static void main(String[] args) {
        new completop();
    }



    private JLabel ingreseNombre;
    private JTextField ingreseNombreTexto;
    private JLabel ingreseApellido;
    private JTextField ingreseApellidoTexto;
    private JLabel ingreseDepartamento;
    private JComboBox<String> departamento;
    private JLabel ingreseActividad;
    private JCheckBox ingreseActividadCheckBox;
    private JButton enviar;
    private JButton retroceder;



    private void registroEmpleado() {
        JFrame ventanaRegistro = new JFrame("Registro Empleado");
        ventanaRegistro.setSize(400,300);
        ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaRegistro.setLayout(new GridBagLayout());
        ventanaRegistro.setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ingreseNombre = new JLabel("Ingrese Nombre:");
        ingreseNombreTexto = new JTextField(15);
        VentanaAgregarEmpleado(ventanaRegistro,ingreseNombre,ingreseNombreTexto,gbc);

        ingreseApellido = new JLabel("Ingrese Apellido:");
        ingreseApellidoTexto = new JTextField(15);
        VentanaAgregarEmpleado(ventanaRegistro,ingreseApellido,ingreseApellidoTexto,gbc);

        ingreseDepartamento = new JLabel("Ingrese Departamento:");
        departamento = new JComboBox<>(new String[]{"Ventas", "IT", "Recursos humanos"});
        VentanaAgregarEmpleado(ventanaRegistro,ingreseDepartamento,departamento,gbc);

        ingreseActividad = new JLabel("Marque si esta activo:");
        ingreseActividadCheckBox = new JCheckBox("Activo");
        VentanaAgregarEmpleado(ventanaRegistro,ingreseActividad,ingreseActividadCheckBox,gbc);


        retroceder = new JButton("Retoceder");
        retroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setEnabled(true);
                ventanaRegistro.dispose();
            }
        });
        enviar = new JButton("Enviar");
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    ventanaRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente");
                }
            }
        });
        VentanaAgregarEmpleado(ventanaRegistro, retroceder,enviar,gbc);


    }





    private void VentanaAgregarEmpleado(JFrame frame, JComponent component2, JComponent component, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        frame.add(component2, gbc);
        gbc.gridx = 1;
        frame.add(component, gbc);
    }

    private boolean validarCampos() {
        if (ingreseNombreTexto.getText().isEmpty() ||
                ingreseApellidoTexto.getText().isEmpty()){


            return false;
        }
        return true;
    }

}
