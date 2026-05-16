/**
 * Modelo que almacena una palabra y su pista asociada.
 */
public class PalabraPista {

    // -- Variables usadas: palabra y pista
    private final String palabra;
    private final String pista;

    // -- Constructor: inicializar palabra y pista
    public PalabraPista(String palabra, String pista) {
        this.palabra = palabra.toUpperCase();
        this.pista = pista;
    }

    // -- Métodos: getters para obtener palabra y pista
    public String getPalabra() {
        return palabra;
    }

    public String getPista() {
        return pista;
    }
}