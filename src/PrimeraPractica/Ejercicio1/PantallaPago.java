package PrimeraPractica.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.PrintFilesEvent;
import java.awt.event.ActionListener;

public class PantallaPago extends JDialog {
    public PantallaPago(Frame frame) {
        super(frame, "Pantalla Pago",true);
        //configuramos el layout d ela pantalla de pago
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setTitle("Pantalla Pago");
        setSize(200,300);
        setLocationRelativeTo(frame);

        //creamos el label y lo alineamos
        JLabel metodoDePago = new JLabel("Metodo de Pago",SwingConstants.CENTER);
        metodoDePago.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Creamos los botones circulares
        JRadioButton paypal = new JRadioButton("Paypal");
        JRadioButton vida = new JRadioButton("Vida");
        JRadioButton mastercard = new JRadioButton("Mastercard");
        //creamos el grupo de botones y los añadimos
        ButtonGroup pagos = new ButtonGroup();
        pagos.add(paypal);
        pagos.add(vida);
        pagos.add(mastercard);

        add(metodoDePago);
        //Creamos un panel para que quede mas ordenado y estetico y añadimos los botones
        JPanel botones = new JPanel();

        botones.add(paypal);
        botones.add(vida);
        botones.add(mastercard);

        add(botones);
        // creamos el panel para que quede mas ordenado y añadimos el boton de aceptar
        JPanel aceptar = new JPanel();
        JButton aceptarButton = new JButton("Aceptar");
        add(aceptar);
        aceptar.add(aceptarButton);


        aceptarButton.addActionListener(
                e-> {
                    frame.dispose();
                });

    }
}
