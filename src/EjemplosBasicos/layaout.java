package EjemplosBasicos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
public class layaout {
    public static void main(String[] args) {
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Ejemplo de FlowLayout");

        // Configurar el layout del JFrame a FlowLayout
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        // FlowLayout.CENTER: Coloca los componentes centrados
        // 20: Espacio horizontal entre componentes
        // 15: Espacio vertical entre componentes
        // Agregar varios botones al JFrame
        frame.add(new JButton("Botón 1"));
        frame.add(new JButton("Botón 2"));
        frame.add(new JButton("Botón 3"));
        frame.add(new JButton("Botón 4"));
        frame.add(new JButton("Botón 5"));

        // Configurar el tamaño de la ventana
        frame.setSize(300, 200);
        // Configurar el comportamiento para cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Hacer la ventana visible
        frame.setVisible(true);
    }
}
