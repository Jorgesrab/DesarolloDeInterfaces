package EjemplosBasicos;

import javax.swing.*;
import java.awt.*;

public class ventana {
    public static void main(String[] args) {

 //Crear una nueva ventana JFrame
        JFrame frame = new JFrame("Mi Primera Ventana");
        frame.setLayout(new FlowLayout());  // Usar FlowLayout para la disposición de los componentes
        frame.setSize(300, 200);  // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la aplicación cuando se cierre la ventana

 // Crear un botón
        JButton button = new JButton("Haz clic aquí");

 //Crear un campo de texto
        JTextField textField = new JTextField(20);  // Campo de texto con 20 columnas

 //Agregar el campo de texto y el botón a la ventana
        frame.add(textField);
        frame.add(button);

 //Añadir un ActionListener para manejar el evento de clic del botón
        button.addActionListener(e -> {
            textField.setText("¡Botón presionado!");  // Cambiar el texto cuando se haga clic
        });


            //Hacer la ventana visible
            frame.setVisible(true);
        }

}
