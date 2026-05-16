import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Panel que dibuja el ahorcado gráficamente.
 * Dibuja las partes del ahorcado según el número de errores.
 */
public class HangmanPanel extends JPanel {

    // -- Variables usadas: contador de errores
    private int errores;

    // -- Constructor: configurar dimensiones y color
    public HangmanPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300, 420));
    }

    // -- Métodos: establecer número de errores
    public void setErrores(int errores) {
        this.errores = errores;
    }

    // -- Lógica: dibujar el ahorcado según errores
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(52, 73, 94));
        g2.setStroke(new java.awt.BasicStroke(6f, java.awt.BasicStroke.CAP_ROUND, java.awt.BasicStroke.JOIN_ROUND));

        int baseY = getHeight() - 45;

        g2.drawLine(40, baseY, 210, baseY);
        g2.drawLine(75, baseY, 75, 35);
        g2.drawLine(75, 35, 175, 35);
        g2.drawLine(175, 35, 175, 70);

        if (errores > 0) {
            g2.drawOval(150, 70, 50, 50);
        }
        if (errores > 1) {
            g2.drawLine(175, 120, 175, 220);
        }
        if (errores > 2) {
            g2.drawLine(175, 145, 140, 180);
        }
        if (errores > 3) {
            g2.drawLine(175, 145, 210, 180);
        }
        if (errores > 4) {
            g2.drawLine(175, 220, 145, 270);
        }
        if (errores > 5) {
            g2.drawLine(175, 220, 205, 270);
        }

        g2.dispose();
    }
}