package Practica3UT2;

import javax.swing.*;
import java.awt.*;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class BotonSonrisa extends JButton {
    static {
        // Esto es para cargar la libreria de OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    // Atributos
    private boolean sonrisaDetectada; // para saber si se ha detectado una sonrisa
    private CascadeClassifier clasificadorSonrisa; // objeto para el clasificador Haar
    private boolean botonActivado; // para saber si el boton ya fue activado

    public BotonSonrisa(String texto) {
        super(texto);
        setBackground(Color.CYAN); // color de fondo
        setFont(new Font("Arial", Font.BOLD, 16)); // fuente del texto
        setFocusPainted(false); // eliminar borde al enfocar
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // borde negro
        setSonrisaDetectada(false); // inicializamos sin detectar sonrisa
        botonActivado = false; // boton no activado
        iniciarDetectorSonrisa(); // cargar el clasificador de sonrisas
        iniciarDeteccionSonrisa(); // empezar a detectar sonrisas
    }

    private void iniciarDetectorSonrisa() {
        // Cargar el clasificador Haar para detectar sonrisas
        String rutaClasificador = "src/Practica3UT2/Recursos/haarcascade_smile.xml";
        clasificadorSonrisa = new CascadeClassifier(rutaClasificador);
        if (clasificadorSonrisa.empty()) {
            JOptionPane.showMessageDialog(null, "Error al cargar el clasificador Haar en " + rutaClasificador);
        }
    }

    private void iniciarDeteccionSonrisa() {
        VideoCapture captura = new VideoCapture(0); // acceso a la cámara (cámara 0)
        if (!captura.isOpened()) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la cámara");
            return;
        }

        new Thread(() -> {
            Mat frameMat = new Mat(); // matriz para guardar el frame de la cámara

            while (captura.isOpened()) {
                if (captura.read(frameMat)) {
                    // Convertir el frame a escala de grises
                    Mat frameGris = new Mat();
                    Imgproc.cvtColor(frameMat, frameGris, Imgproc.COLOR_BGR2GRAY);
                    Imgproc.equalizeHist(frameGris, frameGris);

                    // Detectar sonrisas usando el clasificador cargado
                    MatOfRect sonrisas = new MatOfRect();
                    clasificadorSonrisa.detectMultiScale(
                            frameGris,
                            sonrisas,
                            1.8,   // Escala de búsqueda
                            20,
                            0,
                            new Size(30, 30), // tamaño mínimo para detectar
                            new Size() // tamaño máximo
                    );

                    // Si detecta una sonrisa, activar el botón
                    if (sonrisas.toArray().length > 0 && !botonActivado) {
                        SwingUtilities.invokeLater(() -> setSonrisaDetectada(true));
                    }

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            captura.release(); // libera la cámara cuando termine
        }).start();
    }

    public void setSonrisaDetectada(boolean detectada) {
        this.sonrisaDetectada = detectada;
        if (detectada && !botonActivado) {
            botonActivado = true;
            setEnabled(true); // activa el botón
            setBackground(Color.GREEN); // cambiar color a verde
            setText("Sonrisa Detectada (Botón Activado)"); // cambiar el texto del botón
        }
    }

    public boolean isSonrisaDetectada() {
        return sonrisaDetectada;
    }

    public static void main(String[] args) {

    }
}
