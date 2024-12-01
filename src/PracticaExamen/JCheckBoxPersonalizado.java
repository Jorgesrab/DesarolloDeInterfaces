package PracticaExamen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckBoxPersonalizado extends JCheckBox {
    private boolean isClicked = false;

    public JCheckBoxPersonalizado() {
        // Configurar el texto y el color inicial
        this.setText("Inactivo");


        // Agregar el listener para cambiar texto y color al hacer clic
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isClicked) {
                    setText("Inactivo");
                    setForeground(Color.BLACK);
                } else {
                    setText("Activo");
                    setForeground(Color.BLUE);
                }
                isClicked = !isClicked;
            }
        });
    }
}
