package EjemplosBasicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionExample extends JFrame implements MouseMotionListener {

    private JLabel label;

    public MouseMotionExample() {
        // Configuramos la ventana
        setTitle("Mouse Motion Listener Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Etiqueta para mostrar la posición del ratón
        label = new JLabel("Move the mouse inside the window.");
        add(label);

        // Añadimos el MouseMotionListener a la ventana
        addMouseMotionListener(this);

    }

    // Implementamos el método para detectar cuando el ratón se mueve
    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse moved to: X=" + e.getX() + " Y=" + e.getY());
    }

    // Implementamos el método para detectar cuando el ratón se arrastra
    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("Mouse dragged to: X=" + e.getX() + " Y=" + e.getY());
    }

    public static void main(String[] args) {
        // Creamos y mostramos la ventana
        SwingUtilities.invokeLater(() -> {
            MouseMotionExample example = new MouseMotionExample();
            example.setVisible(true);
        });
    }
}
