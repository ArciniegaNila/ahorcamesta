import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AhorcamestaApp {
    static class Juego {
        Pistas.PalabraPista r;
        Set<Character> u = new LinkedHashSet<>();
        char[] p;
        int t;

        void iniciar(Pistas.Categoria c) {
            r = c.seleccionarPalabra();
            u.clear();
            t = 6;
            String s = r.getPalabra();
            p = new char[s.length()];
            for (int i = 0; i < s.length(); i++) p[i] = s.charAt(i) == ' ' ? ' ' : '_';
        }

        boolean probar(char c) {
            c = Character.toUpperCase(c);
            if (u.contains(c)) return false;
            u.add(c);
            boolean h = false;
            for (int i = 0; i < r.getPalabra().length(); i++) {
                if (r.getPalabra().charAt(i) == c) {
                    p[i] = c;
                    h = true;
                }
            }
            if (!h) t--;
            return h;
        }

        boolean ganado() { return new String(p).equals(r.getPalabra()); }
        boolean perdido() { return t <= 0; }
        String prog() {
            StringBuilder b = new StringBuilder();
            for (char c : p) b.append(c).append(' ');
            return b.toString().trim();
        }

        String[] pistas() { return r.getPistas(); }
        int errores() { return 6 - t; }
        String usadas() {
            if (u.isEmpty()) return "Ninguna";
            StringBuilder b = new StringBuilder();
            for (char c : u) b.append(c).append(' ');
            return b.toString().trim();
        }
    }

    JFrame f;
    DibujoYPanel panel;
    JComboBox<Pistas.Categoria> cb;
    JLabel lp, lps, lu, le;
    JTextField in;
    Juego j = new Juego();

    public AhorcamestaApp() {
        f = new JFrame("AhorcamestaApp");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        cb = new JComboBox<>(Pistas.categorias());
        JButton bn = new JButton("Nueva palabra");
        top.add(new JLabel("Categoría:"));
        top.add(cb);
        top.add(bn);
        f.add(top, BorderLayout.NORTH);
        panel = new DibujoYPanel();
        f.add(panel, BorderLayout.WEST);
        JPanel r = new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
        lp = new JLabel("_ _ _");
        lp.setFont(new Font("Monospaced", Font.BOLD, 20));
        r.add(lp);
        le = new JLabel("Errores: 0/6");
        r.add(le);
        r.add(new JLabel("Pistas:"));
        lps = new JLabel(" ");
        r.add(lps);
        JPanel p2 = new JPanel();
        in = new JTextField(2);
        JButton bp = new JButton("Probar");
        p2.add(new JLabel("Letra:"));
        p2.add(in);
        p2.add(bp);
        r.add(p2);
        lu = new JLabel("Letras usadas: Ninguna");
        r.add(lu);
        f.add(r, BorderLayout.CENTER);
        bn.addActionListener(e -> start());
        bp.addActionListener(e -> tryL());
        in.addActionListener(e -> tryL());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    void start() {
        Pistas.Categoria c = (Pistas.Categoria) cb.getSelectedItem();
        j.iniciar(c);
        update();
    }

    void tryL() {
        String t = in.getText().trim();
        if (t.isEmpty()) return;
        j.probar(t.charAt(0));
        in.setText("");
        update();
        if (j.ganado()) JOptionPane.showMessageDialog(f, "¡Ganaste!\n" + j.prog());
        if (j.perdido()) JOptionPane.showMessageDialog(f, "Perdiste");
    }

    void update() {
        lp.setText(j.prog());
        String[] ps = j.pistas();
        StringBuilder sb = new StringBuilder("<html>");
        for (String s : ps) sb.append("• ").append(s).append("<br>");
        sb.append("</html>");
        lps.setText(sb.toString());
        lu.setText("Letras usadas: " + j.usadas());
        le.setText("Errores: " + j.errores() + "/6");
        panel.setErrores(j.errores());
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(() -> new AhorcamestaApp());
    }
}