import java.util.Random;

public class Pistas {

    public static class PalabraPista {
        private final String palabra;
        private final String[] pistas;

        public PalabraPista(String palabra, String[] pistas) {
            this.palabra = palabra.toUpperCase();
            this.pistas = pistas != null ? pistas : new String[0];
        }

        public String getPalabra() { return palabra; }
        public String[] getPistas() { return pistas; }
    }

    public static class Categoria {
        private final String nombre;
        private final PalabraPista[] palabras;

        public Categoria(String nombre, PalabraPista[] palabras) {
            this.nombre = nombre;
            this.palabras = palabras;
        }

        public String toString() { return nombre; }

        public PalabraPista seleccionarPalabra() {
            return palabras[new Random().nextInt(palabras.length)];
        }
    }

    public static Categoria[] categorias() {
        return new Categoria[]{deportes(), computadora(), phobias(), videojuegos()};
    }

    public static Categoria deportes() {
        return new Categoria("Deportes", new PalabraPista[]{
            new PalabraPista("CLUB DEPORTIVO CHIVAS", new String[]{"Es un Club de Futbol", "Liga de Mexico", "Nombre relacionado a un animal"}),
            new PalabraPista("LEONEL MESSI", new String[]{"Es un Futbolista", "Ha jugado en varios clubes", "Maximo goleador"}),
            new PalabraPista("CRISTIANO RONALDO", new String[]{"Es un Futbolista", "Gran goleador", "No ganó el mundial"})
        });
    }

    public static Categoria computadora() {
        return new Categoria("Computadora", new PalabraPista[]{
            new PalabraPista("MONITOR", new String[]{"Sirve para ver imagen", "Tiene pantalla", "Se conecta al CPU"}),
            new PalabraPista("TECLADO", new String[]{"Sirve para escribir", "Tiene teclas", "Puede ser USB o Bluetooth"}),
            new PalabraPista("MOUSE", new String[]{"Se usa con la mano", "Controla el cursor", "Tiene clic izquierdo"})
        });
    }

    public static Categoria phobias() {
        return new Categoria("Phobias", new PalabraPista[]{
            new PalabraPista("ARACNOFOBIA", new String[]{"Miedo a arañas", "Termina con -fobia", "Es común"}),
            new PalabraPista("ACROFOBIA", new String[]{"Miedo a las alturas", "Puede causar vértigo", "Ocurre en edificios altos"})
        });
    }

    public static Categoria videojuegos() {
        return new Categoria("Videojuegos", new PalabraPista[]{
            new PalabraPista("MINECRAFT", new String[]{"Juego de bloques", "Construcción", "Tiene mobs como creepers"}),
            new PalabraPista("FORTNITE", new String[]{"Battle Royale", "Famoso por bailes", "Tiene temporadas"})
        });
    }
}