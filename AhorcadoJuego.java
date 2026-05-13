import java.util.LinkedHashSet;
import java.util.Set;

public class AhorcadoJuego {

    private Categoria categoriaActual;
    private PalabraPista rondaActual;
    private final Set<Character> letrasUsadas = new LinkedHashSet<>();
    private char[] progreso;
    private int intentosRestantes;

    public void iniciarPartida(Categoria categoria) {
        categoriaActual = categoria;
        rondaActual = categoria.seleccionarPalabra();
        letrasUsadas.clear();
        intentosRestantes = 6;
        progreso = new char[rondaActual.getPalabra().length()];

        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
    }

    public boolean puedeUsarLetra(char letra) {
        return !letrasUsadas.contains(letra);
    }

    public boolean probarLetra(char letra) {
        letrasUsadas.add(letra);
        boolean acierto = false;

        for (int i = 0; i < rondaActual.getPalabra().length(); i++) {
            if (rondaActual.getPalabra().charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
        }

        return acierto;
    }

    public boolean estaGanado() {
        return String.valueOf(progreso).equals(rondaActual.getPalabra());
    }

    public boolean estaPerdido() {
        return intentosRestantes <= 0;
    }

    public String getPalabraOculta() {
        StringBuilder builder = new StringBuilder();

        for (char caracter : progreso) {
            builder.append(caracter).append(' ');
        }

        return builder.toString().trim();
    }

    public String getPalabraOcultaCompleta() {
        return rondaActual.getPalabra();
    }

    public Categoria getCategoriaActual() {
        return categoriaActual;
    }

    public String getPista() {
        return rondaActual.getPista();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getErrores() {
        return 6 - intentosRestantes;
    }

    public String getLetrasUsadasComoTexto() {
        if (letrasUsadas.isEmpty()) {
            return "Ninguna";
        }

        StringBuilder builder = new StringBuilder();

        for (char letra : letrasUsadas) {
            builder.append(letra).append(' ');
        }

        return builder.toString().trim();
    }
}
