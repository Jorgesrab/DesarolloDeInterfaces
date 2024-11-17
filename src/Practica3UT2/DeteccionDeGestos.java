package Practica3UT2;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class DeteccionDeGestos {
    static {
        // Cargar la librería nativa de OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private JFrame ventana;
    private JLabel etiquetaCamara;
    private JButton botonAccion;
    private CascadeClassifier clasificadorSonrisa;
    private boolean sonrisaDetectada = false;

    public DeteccionDeGestos() {
        // Configurar la interfaz gráfica
        ventana = new JFrame("Detección de Sonrisas con OpenCV");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Componente de video
        etiquetaCamara = new JLabel();
        ventana.add(etiquetaCamara, BorderLayout.CENTER);

        // Botón de acción que será activado por la detección de sonrisas
        botonAccion = new JButton("Acción (Sonríe para Activar)");
        botonAccion.setEnabled(false);
        botonAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonrisaDetectada) {
                    JOptionPane.showMessageDialog(ventana, "Botón activado Puedes realizar la acción ahora.");
                }
            }
        });
        ventana.add(botonAccion, BorderLayout.SOUTH);

        ventana.setVisible(true);

        // Cargar el clasificador Haar para la detección de sonrisas
        String rutaClasificador = "src/Practica3UT2/Recursos/haarcascade_smile.xml"; // Ruta al archivo Haar de sonrisas
        clasificadorSonrisa = new CascadeClassifier(rutaClasificador);
        if (clasificadorSonrisa.empty()) {
            JOptionPane.showMessageDialog(ventana, "Error al cargar el clasificador Haar en " + rutaClasificador);
            return;
        }

        // Inicia el proceso de detección
        iniciarDeteccionSonrisa();
    }

    private void iniciarDeteccionSonrisa() {
        VideoCapture captura = new VideoCapture(0);
        if (!captura.isOpened()) {
            JOptionPane.showMessageDialog(ventana, "No se pudo acceder a la cámara");
            return;
        }

        new Thread(() -> {
            Mat frameMat = new Mat();

            while (captura.isOpened()) {
                if (captura.read(frameMat)) {
                    // Convierte el frame a escala de grises
                    Mat frameGris = new Mat();
                    Imgproc.cvtColor(frameMat, frameGris, Imgproc.COLOR_BGR2GRAY);
                    Imgproc.equalizeHist(frameGris, frameGris);

                    // Detecta sonrisas (usando el clasificador cargado)
                    MatOfRect sonrisas = new MatOfRect();
                    clasificadorSonrisa.detectMultiScale(
                            frameGris,
                            sonrisas,
                            1.8,   // Escala de búsqueda
                            20,    //
                            0,
                            new Size(30, 30),
                            new Size()
                    );

                    // Si detecta una sonrisa, activa el botón
                    if (sonrisas.toArray().length > 0) {
                        sonrisaDetectada = true;
                        SwingUtilities.invokeLater(() -> botonAccion.setEnabled(true));
                    }

                    // Convierte la imagen de OpenCV a BufferedImage y muestra
                    ImageIcon icono = new ImageIcon(matABufferedImage(frameMat));
                    etiquetaCamara.setIcon(icono);
                    ventana.repaint();

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            captura.release();
        }).start();
    }

    // Convertir un Mat de OpenCV a BufferedImage de Swing
    private BufferedImage matABufferedImage(Mat mat) {
        int tipo = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            tipo = BufferedImage.TYPE_3BYTE_BGR;
        }
        int tamBuffer = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[tamBuffer];
        mat.get(0, 0, buffer);
        BufferedImage imagen = new BufferedImage(mat.cols(), mat.rows(), tipo);
        final byte[] pixelesDestino = ((DataBufferByte) imagen.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, pixelesDestino, 0, buffer.length);
        return imagen;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DeteccionDeGestos::new);
    }
}