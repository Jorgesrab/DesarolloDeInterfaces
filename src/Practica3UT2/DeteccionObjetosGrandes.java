package Practica3UT2;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.List;
//Este programa muestra un rectangulo alrededor de objetos grandes con el color del propio objeto
public class DeteccionObjetosGrandes extends JFrame {
    static {
        // Cargar la librería nativa de OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    // Componente para mostrar el video de la cámara
    private JLabel vistaCamara;

    public DeteccionObjetosGrandes() {
        // Configurar la ventana de la interfaz
        setTitle("Detección de Objetos Grandes con Recuadro de Color Promedio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Componente de video
        vistaCamara = new JLabel();
        add(vistaCamara, BorderLayout.CENTER);

        setVisible(true);

        // Inicia la captura de video y el procesamiento de AR
        iniciarCapturaVideo();
    }

    private void iniciarCapturaVideo() {
        VideoCapture captura = new VideoCapture(0); // acceso a la cámara (cámara 0)
        if (!captura.isOpened()) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la cámara");
            return;
        }

        new Thread(() -> {
            Mat frame = new Mat(); // matriz para guardar el frame de la cámara

            while (captura.isOpened()) {
                if (captura.read(frame)) {
                    // Convertir el frame a escala de grises para la detección de contornos
                    Mat frameGris = new Mat();
                    Imgproc.cvtColor(frame, frameGris, Imgproc.COLOR_BGR2GRAY);

                    // Aplicar desenfoque para reducir el ruido
                    Imgproc.GaussianBlur(frameGris, frameGris, new Size(5, 5), 0);

                    // Detección de bordes
                    Imgproc.Canny(frameGris, frameGris, 50, 150);

                    // Encontrar contornos
                    List<MatOfPoint> contornos = new ArrayList<>();
                    Mat jerarquia = new Mat();
                    Imgproc.findContours(frameGris, contornos, jerarquia, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

                    // Procesar contornos detectados
                    for (MatOfPoint contorno : contornos) {
                        Rect rectangulo = Imgproc.boundingRect(contorno);

                        // Filtrar solo objetos grandes
                        if (rectangulo.width > 100 && rectangulo.height > 100) {
                            // Calcular el color promedio del área del objeto
                            Mat subMat = frame.submat(rectangulo);
                            Scalar colorPromedio = Core.mean(subMat);
                            subMat.release();

                            // Dibujar un rectángulo del color promedio alrededor del objeto
                            Imgproc.rectangle(frame, rectangulo.tl(), rectangulo.br(), new Scalar(colorPromedio.val[0], colorPromedio.val[1], colorPromedio.val[2]), 3);
                        }
                    }

                    // Convertir el frame a BufferedImage y mostrar en el JLabel
                    ImageIcon icono = new ImageIcon(matABufferedImage(frame));
                    vistaCamara.setIcon(icono);
                    vistaCamara.repaint();

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            captura.release(); // liberar la cámara cuando termine
        }).start();
    }

    // Convertir un Mat de OpenCV a BufferedImage para mostrarlo en Swing
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
        SwingUtilities.invokeLater(DeteccionObjetosGrandes::new);
    }
}
