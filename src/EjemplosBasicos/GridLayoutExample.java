package EjemplosBasicos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class GridLayoutExample {
    public static void main(String[] args) {
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Ejemplo de GridLayout");
        // Configurar el GridLayout: 3 filas y 2 columnas
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        // 10 es el espacio horizontal y vertical entre las celdas
        // Agregar 6 botones
        frame.add(new JButton("Botón 1"));
        frame.add(new JButton("Botón 2"));
        frame.add(new JButton("Botón 3"));
        frame.add(new JButton("Botón 4"));
        frame.add(new JButton("Botón 5"));
        frame.add(new JButton("Botón 6"));
        // Configurar el tamaño de la ventana
        frame.setSize(300, 200);
        // Configurar el comportamiento para cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}