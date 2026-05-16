import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel principal del juego del Ahorcado.
 * Adaptado del código original de gelop.
 * Código dividido por secciones con comentarios "--" para facilitar lectura.
 */
public class AhorcadoPanel extends JPanel implements ActionListener {

    // -- Variables usadas: componentes de entrada/salida de texto
    private JTextField edt1;  // Campo para mostrar la palabra
    private JTextField edt2;  // Campo para ingresar letra

    // -- Variables usadas: estado del juego
    private String palabra;
    private String[] lineas = new String[10];
    private int contador = 0;
    private int intentos = 0;
    private int correctas = 0;
    private boolean[] revelado;

    // -- Variables usadas: componentes UI - botones
    private JButton BTnbuscar;   // Botón Verificar
    private JButton BTnNuevo;    // Botón Palabra nueva
    private JButton BtnSalir;    // Botón Salir

    // -- Variables usadas: componentes UI - labels
    private JLabel label1;       // Etiqueta "palabra:"
    private JLabel label2;       // Etiqueta "letra:"
    private JLabel label4;       // Etiqueta para mensajes

    // -- Variables usadas: imágenes del progreso del ahorcado
    private JLabel imagenn;
    private JLabel imagenn2;
    private JLabel imagenn3;
    private JLabel imagenn4;
    private JLabel imagenn5;
    private JLabel imagenn6;

    // -- Variables usadas: constantes del juego
    private final int MAX_ERRORES = 6;

    // -- Constructor: configurar UI y listeners
    public AhorcadoPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 400));

        // -- Inicialización: crear labels
        label1 = new JLabel("Palabra:");
        label1.setBounds(100, 20, 100, 20);

        label2 = new JLabel("Letra:");
        label2.setBounds(200, 90, 100, 20);

        label4 = new JLabel("");
        label4.setBounds(140, 40, 200, 20);

        // -- Inicialización: crear campos de texto
        edt1 = new JTextField("");
        edt1.setEditable(false);
        edt1.setBounds(170, 20, 200, 20);

        edt2 = new JTextField("");
        edt2.setBounds(250, 90, 80, 20);

        // -- Inicialización: crear botones
        BTnbuscar = new JButton("Verificar");
        BTnbuscar.setBounds(200, 120, 100, 20);

        BtnSalir = new JButton("Salir");
        BtnSalir.setBounds(200, 200, 100, 20);

        BTnNuevo = new JButton("Palabra nueva");
        BTnNuevo.setBounds(200, 160, 100, 20);

        // -- Inicialización: configurar listeners
        BTnbuscar.addActionListener(this);
        BTnNuevo.addActionListener(this);
        BtnSalir.addActionListener(this);

        // -- Inicialización: crear labels para imágenes
        imagenn = new JLabel();
        imagenn.setBounds(30, 110, 160, 170);

        imagenn2 = new JLabel();
        imagenn2.setBounds(30, 110, 160, 170);

        imagenn3 = new JLabel();
        imagenn3.setBounds(30, 110, 160, 170);

        imagenn4 = new JLabel();
        imagenn4.setBounds(30, 110, 160, 170);

        imagenn5 = new JLabel();
        imagenn5.setBounds(30, 110, 160, 170);

        imagenn6 = new JLabel();
        imagenn6.setBounds(30, 110, 160, 170);

        // -- Inicialización: cargar imágenes de forma segura
        cargarImagenes();

        // -- Inicialización: agregar componentes al panel
        add(label1);
        add(label2);
        add(label4);
        add(edt1);
        add(edt2);
        add(BtnSalir);
        add(BTnbuscar);
        add(BTnNuevo);
        add(imagenn);

        // -- Métodos: iniciar juego
        nuevaPalabra();
    }

    // -- Métodos: cargar imágenes desde recursos o ruta relativa
    private void cargarImagenes() {
        String[] rutas = {"/image/1.png", "/image/2.png", "/image/3.png",
                          "/image/4.png", "/image/5.png", "/image/6.png"};
        JLabel[] labels = {imagenn, imagenn2, imagenn3, imagenn4, imagenn5, imagenn6};

        for (int i = 0; i < rutas.length; i++) {
            try {
                java.net.URL res = getClass().getResource(rutas[i]);
                if (res != null) {
                    labels[i].setIcon(new ImageIcon(res));
                } else {
                    java.io.File f = new java.io.File("." + rutas[i]);
                    if (f.exists()) {
                        labels[i].setIcon(new ImageIcon(f.getAbsolutePath()));
                    }
                }
            } catch (Exception ex) {
                // Si falla, dejamos el label vacío
            }
        }
    }

    // -- Métodos: obtener nueva palabra
    private void nuevaPalabra() {
        PalabraPista pp = Categoria.getRandomPalabra();
        palabra = pp.getPalabra().toUpperCase();
        revelado = new boolean[palabra.length()];
        contador = 0;
        intentos = 0;
        label4.setText("");
        actualizarVista();
        edt2.setText("");
    }

    // -- Métodos: actualizar la vista de la palabra
    private void actualizarVista() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            if (revelado[i]) {
                sb.append(palabra.charAt(i)).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        edt1.setText(sb.toString());
    }

    // -- Lógica: verificar letra ingresada
    private void verificarLetra() {
        String txt = edt2.getText().toUpperCase();
        if (txt.isEmpty()) return;

        char letra = txt.charAt(0);
        boolean acierto = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                revelado[i] = true;
                acierto = true;
                correctas++;
            }
        }

        if (!acierto) {
            contador++;
            intentos++;
            actualizarImagen();
        }

        actualizarVista();
        edt2.setText("");

        // -- Lógica: verificar condiciones de fin de juego
        if (contador >= MAX_ERRORES) {
            JOptionPane.showMessageDialog(this, "Perdiste. La palabra era: " + palabra);
            nuevaPalabra();
        } else if (verificarGanada()) {
            JOptionPane.showMessageDialog(this, "¡Felicidades! Ganaste.");
            nuevaPalabra();
        }
    }

    // -- Utilidad: verificar si la palabra está completa
    private boolean verificarGanada() {
        for (int i = 0; i < revelado.length; i++) {
            if (!revelado[i]) return false;
        }
        return true;
    }

    // -- Métodos: actualizar imagen del ahorcado según errores
    private void actualizarImagen() {
        JLabel imageToShow = null;
        if (contador == 1) imageToShow = imagenn;
        else if (contador == 2) imageToShow = imagenn2;
        else if (contador == 3) imageToShow = imagenn3;
        else if (contador == 4) imageToShow = imagenn4;
        else if (contador == 5) imageToShow = imagenn5;
        else if (contador >= 6) imageToShow = imagenn6;
        
        if (imageToShow != null) {
            // -- Lógica: remover imagen anterior y agregar la nueva
            removeAll();
            add(label1);
            add(label2);
            add(label4);
            add(edt1);
            add(edt2);
            add(BtnSalir);
            add(BTnbuscar);
            add(BTnNuevo);
            add(imageToShow);
            repaint();
        }
    }

    // -- Listeners: acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == BTnbuscar) {
            verificarLetra();
        } else if (src == BTnNuevo) {
            nuevaPalabra();
        } else if (src == BtnSalir) {
            System.exit(0);
        }
    }
}
