import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AhorcamestaApp extends JFrame implements ActionListener {

    private JTextField palabraTxt, letraTxt;
    private JButton nuevaBtn;
    private JComboBox<Pistas.Categoria> categorias;
    private JTextArea pistasTxt;
    private JLabel erroresLbl;
    private DibujoYPanel panel;
    private Pistas.PalabraPista actual;
    private char[] letras;
    private String palabra;
    private int errores;

    public AhorcamestaApp() {
        this.setTitle("Ahorcamesta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel arriba = new JPanel();
        categorias = new JComboBox<>(Pistas.categorias());
        nuevaBtn = new JButton("Nueva palabra");
        arriba.add(new JLabel("Categoria:"));
        arriba.add(categorias);
        arriba.add(nuevaBtn);
        add(arriba, BorderLayout.NORTH);

        panel = new DibujoYPanel();
        add(panel, BorderLayout.WEST);

        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        palabraTxt = new JTextField(20);
        palabraTxt.setEditable(false);
        letraTxt = new JTextField(2);
        pistasTxt = new JTextArea(4, 18);
        pistasTxt.setEditable(false);
        pistasTxt.setLineWrap(true);
        pistasTxt.setWrapStyleWord(true);
        erroresLbl = new JLabel("Errores: 0/6");

        centro.add(new JLabel("Palabra:"));
        centro.add(palabraTxt);
        centro.add(new JLabel("Pistas:"));
        centro.add(pistasTxt);
        centro.add(erroresLbl);
        centro.add(new JLabel("Letra:"));
        centro.add(letraTxt);
        add(centro, BorderLayout.CENTER);

        nuevaBtn.addActionListener(this);
        letraTxt.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        nuevaPalabra();
    }

    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        if (fuente == nuevaBtn) {
            nuevaPalabra();
        } else if (fuente == letraTxt) {
            verificarLetra();
        }
    }

    private void nuevaPalabra() {
        actual = ((Pistas.Categoria) categorias.getSelectedItem()).seleccionarPalabra();
        palabra = actual.getPalabra();
        letras = new char[palabra.length()];
        errores = 0;
        for (int i = 0; i < letras.length; i++) {
            letras[i] = palabra.charAt(i) == ' ' ? ' ' : '_';
        }
        letraTxt.setText("");
        panel.setErrores(0);
        actualizarPantalla();
    }

    private void verificarLetra() {
        String texto = letraTxt.getText().trim();
        if (texto.isEmpty()) return;
        char letra = Character.toUpperCase(texto.charAt(0));
        boolean acerto = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                letras[i] = letra;
                acerto = true;
            }
        }
        if (!acerto) errores++;
        letraTxt.setText("");
        actualizarPantalla();
        if (new String(letras).equals(palabra)) {
            JOptionPane.showMessageDialog(this, "¡Ganaste!\n" + palabra);
        } else if (errores >= 6) {
            JOptionPane.showMessageDialog(this, "Perdiste\nLa palabra era: " + palabra);
        }
    }

    private void actualizarPantalla() {
        String texto = "";
        for (int i = 0; i < letras.length; i++) {
            texto = texto + letras[i] + " ";
        }
        palabraTxt.setText(texto.trim());

        String pistas = "";
        for (String s : actual.getPistas()) {
            pistas = pistas + "- " + s + "\n";
        }
        pistasTxt.setText(pistas);

        erroresLbl.setText("Errores: " + errores + "/6");
        panel.setErrores(errores);
    }

    public static void main(String[] args) {
        new AhorcamestaApp();
    }
}