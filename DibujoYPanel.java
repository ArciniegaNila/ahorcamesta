import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DibujoYPanel extends JPanel {

    // aqui se declaran las variables
    private int errores; // contador de errores en el juego

    // Inicia el panel con dimensiones y fondo blanco
    public DibujoYPanel() {
        setPreferredSize(new Dimension(280, 340));
        setBackground(Color.WHITE);
    }

    // Método para actualizar el número de errores y redibujar el panel
    public void setErrores(int errores) {
        this.errores = errores;
        repaint(); // llamamos repaint para que se redibuje
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

            
        Graphics2D g2 = (Graphics2D) g.create();
        // ESTA SECCION SE REALIZO CON IA
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Establecemos el color
        g2.setColor(new Color(52, 73, 94));
        // Configuramos
        g2.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Calculamos la posición 
        int baseY = getHeight() - 35;

        // ESTRUCTURA
        g2.drawLine(30, baseY, 210, baseY);     
        g2.drawLine(70, baseY, 70, 20);       
        g2.drawLine(70, 20, 170, 20);           
        g2.drawLine(170, 20, 170, 55);          

        // dERROR
        if (errores > 0) g2.drawOval(145, 55, 50, 50);           
        if (errores > 1) g2.drawLine(170, 105, 170, 205);       
        if (errores > 2) g2.drawLine(170, 130, 130, 165);        
        if (errores > 3) g2.drawLine(170, 130, 210, 165);        
        if (errores > 4) g2.drawLine(170, 205, 140, 275);       
        if (errores > 5) g2.drawLine(170, 205, 200, 275);       

        //  Contador de errores
        g2.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16));
        g2.drawString("Errores: " + Math.min(errores, 6) + "/6", 20, 20);

        g2.dispose(); // Liberamos los recursos de Graphics2D
    }
}