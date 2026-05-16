import javax.swing.JFrame;

/**
 * Ventana principal de la aplicación del Ahorcado.
 * Contiene el AhorcadoPanel y configura la UI.
 */
public class AhorcadoFrame extends JFrame {

    // -- Constructor: configurar ventana y contenido
    public AhorcadoFrame() {
        setTitle("Bienvenido a Tamaulipas ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new AhorcadoPanel());
        setSize(800, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}