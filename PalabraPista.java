public class PalabraPista {

    private final String palabra;
    private final String pista;

    public PalabraPista(String palabra, String pista) {
        this.palabra = palabra.toUpperCase();
        this.pista = pista;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getPista() {
        return pista;
    }
}