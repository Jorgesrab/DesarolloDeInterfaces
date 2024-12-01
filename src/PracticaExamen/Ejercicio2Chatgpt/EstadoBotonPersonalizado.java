package PracticaExamen.Ejercicio2Chatgpt;

// EstadoBotonPersonalizado.java


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstadoBotonPersonalizado extends JButton {
    private boolean activo; // Estado del botón

    public EstadoBotonPersonalizado() {
        super("No Disponible");
        this.activo = false;
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Añadir ActionListener para alternar estado
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleEstado();
            }
        });
    }

    // Método para alternar estado
    public void toggleEstado() {
        activo = !activo;
        setText(activo ? "Disponible" : "No Disponible");
        setBackground(activo ? Color.GREEN : Color.RED);
    }

    // Obtener el estado actual
    public boolean isActivo() {
        return activo;
    }
}
