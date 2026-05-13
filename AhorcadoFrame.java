import javax.swing.JFrame;

public class AhorcadoFrame extends JFrame {

    public AhorcadoFrame() {
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new AhorcadoPanel());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}