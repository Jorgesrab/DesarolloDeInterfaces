package PracticaExamen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistroEmpleado extends JFrame {

    protected static ArrayList<String> Empleados = new ArrayList<>();
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
    private PrimeraVentana mainVentana;

    public RegistroEmpleado() {
        this.mainVentana = mainVentana;
        setTitle("Registro Empleado");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ingreseNombre = new JLabel("Ingrese Nombre:");
        ingreseNombreTexto = new JTextField(15);
        agregarComponentes(ingreseNombre, ingreseNombreTexto, gbc);

        ingreseApellido = new JLabel("Ingrese Apellido:");
        ingreseApellidoTexto = new JTextField(15);
        agregarComponentes(ingreseApellido, ingreseApellidoTexto, gbc);

        ingreseDepartamento = new JLabel("Ingrese Departamento:");
        departamento = new JComboBox<>(new String[]{"Ventas", "IT", "Recursos_humanos"});
        agregarComponentes(ingreseDepartamento, departamento, gbc);

        ingreseActividad = new JLabel("Marque si está activo:");
        ingreseActividadCheckBox = new JCheckBoxPersonalizado();
        agregarComponentes(ingreseActividad, ingreseActividadCheckBox, gbc);

        retroceder = new JButton("Retroceder");
        retroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVentana.setEnabled(true);
                dispose();
            }
        });

        enviar = new JButton("Enviar");
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    guardarInformacion();
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente");
                }
            }
        });

        agregarComponentes(retroceder, enviar, gbc);
    }

    private void agregarComponentes(JComponent component1, JComponent component2, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(component1, gbc);
        gbc.gridx = 1;
        add(component2, gbc);
    }

    private boolean validarCampos() {
        return !ingreseNombreTexto.getText().isEmpty() && !ingreseApellidoTexto.getText().isEmpty();
    }

    private void guardarInformacion(){
        String actividad;

        if (ingreseActividadCheckBox.isSelected()){
            actividad = "activo";

        }else {
            actividad = "inactivo";
        }

        Empleados.add(ingreseNombreTexto.getText() + " " + ingreseApellidoTexto.getText()+ " " +departamento.getSelectedItem().toString()+" "+actividad);
       
    }
    // En la clase RegistroEmpleado
    public ArrayList<String> getEmpleados() {
        return Empleados;
    }

}
