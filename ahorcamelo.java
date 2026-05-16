import javax.swing.SwingUtilities;

/**
 * Clase principal: punto de entrada de la aplicación del Ahorcado.
 * Ejecuta la ventana en el Event Dispatch Thread.
 */
public class ahorcamelo {

    // -- Métodos: main para iniciar la aplicación
    public static void main(String[] args) {
        // -- Lógica: ejecutar la interfaz en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AhorcadoFrame frame = new AhorcadoFrame();
                frame.setVisible(true);
            }
        });
    }
}
