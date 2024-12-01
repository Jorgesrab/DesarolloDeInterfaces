package PruebaJAr;

// BotonPersonalizado.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BotonPersonalizado extends JButton {
    public BotonPersonalizado(String texto) {
        super(texto);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBackground(new Color(30, 144, 255)); // Azul por defecto
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(65, 105, 225)); // Azul más oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(30, 144, 255)); // Azul por defecto
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(25, 25, 112)); // Azul aún más oscuro
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(new Color(65, 105, 225)); // Azul más oscuro
            }
        });
    }
}
