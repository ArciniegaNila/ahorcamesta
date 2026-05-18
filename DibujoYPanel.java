import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DibujoYPanel extends JPanel {

    // aqui se declaran las variables
    private int errores;

    public DibujoYPanel() {
        setPreferredSize(new Dimension(280, 340));
        setBackground(Color.WHITE);
    }

    public void setErrores(int errores) {
        this.errores = errores;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(52, 73, 94));
        g2.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        int baseY = getHeight() - 35;

        g2.drawLine(30, baseY, 210, baseY);
        g2.drawLine(70, baseY, 70, 20);
        g2.drawLine(70, 20, 170, 20);
        g2.drawLine(170, 20, 170, 55);

        if (errores > 0) g2.drawOval(145, 55, 50, 50);
        if (errores > 1) g2.drawLine(170, 105, 170, 205);
        if (errores > 2) g2.drawLine(170, 130, 130, 165);
        if (errores > 3) g2.drawLine(170, 130, 210, 165);
        if (errores > 4) g2.drawLine(170, 205, 140, 275);
        if (errores > 5) g2.drawLine(170, 205, 200, 275);

        g2.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16));
        g2.drawString("Errores: " + Math.min(errores, 6) + "/6", 20, 20);

        g2.dispose();
    }
}