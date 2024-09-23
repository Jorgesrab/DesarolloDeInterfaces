package PrimeraPractica.Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal {
    public static void main(String[] args) {
        //Cambiamos la fuente de los Label y Buttons
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 15));
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 15));

        //Declaramos y configuramos el Frame
        JFrame frame1 = new JFrame();
        PantallaPago pago = new PantallaPago(frame1);
        frame1.setLayout(new BoxLayout(frame1.getContentPane(),BoxLayout.X_AXIS));
        frame1.setSize(500,200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);



        //Creamos botones y el label
        JLabel entrdas = new JLabel("Ventana de compra de entradas:   ");
        JButton cancelar = new JButton("Cancelar");
        JButton pagar = new JButton("Pagar");
        //Añadimos lo anterior
        frame1.add(entrdas);
        frame1.add(pagar);
        frame1.add(cancelar);

        //Añadimos la accion de cancelar
        cancelar.addActionListener(e-> {
             frame1.dispose();
        });
        //añadimos la accion de abrir la nueva ventana
        pagar.addActionListener(e->{
            pago.setVisible(true);
        });











        frame1.setVisible(true);

    }
}


// a) Tenemos que implementar el JDialog,JFrame, JButton, Jlabel y Jradiobutton
// b) Se asociara al boton pagar
// c) En la ventana inicial y en la ventana de selecion de pago