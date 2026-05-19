import java.util.Random;

// Clase principal 
public class Pistas {

    // Clase interna representa una palabra con sus pistas 
    public static class PalabraPista {
        private final String palabra;          // palabra es la adivinaras
        private final String[] pistas;         // array de pistas para ayudar al jugador

        // Constructor: recibe una palabra y sus pistas, convierte la palabra a mayúsculas
        public PalabraPista(String palabra, String[] pistas) {
            this.pistas = pistas != null ? pistas : new String[0];  // si no hay pistas, creamos un array vacío
        }

    
        public String getPalabra() { return palabra; }
        
        public String[] getPistas() { return pistas; }
    }

    // Clase interna agrupando
    public static class Categoria {
        private final String nombre;              // nombre de la categoría
        private final PalabraPista[] palabras;    // array de palabras con pistas de esta categoría

        // Construimos las categorias con el nombre  
        public Categoria(String nombre, PalabraPista[] palabras) {
            this.nombre = nombre;
            this.palabras = palabras;
        }

        // Retorna el nombre de la categoría 
        public String toString() { return nombre; }

        // Selecciona una palabra aleatoria de esta categoría
        public PalabraPista seleccionarPalabra() {
            return palabras[new Random().nextInt(palabras.length)];
        }
    }

    
    public static Categoria[] categorias() {
        return new Categoria[]{deportes(), computadora(), phobias(), videojuegos()};
    }

    // categoria 1
    public static Categoria deportes() {
        return new Categoria("Deportes", new PalabraPista[]{
            new PalabraPista("CLUB DEPORTIVO CHIVAS", new String[]{"Es un Club de Futbol", "Liga de Mexico", "Nombre relacionado a un animal"}),
            new PalabraPista("LEONEL MESSI", new String[]{"Es un Futbolista", "Ha jugado en varios clubes", "Maximo goleador"}),
            new PalabraPista("CRISTIANO RONALDO", new String[]{"Es un Futbolista", "Gran goleador", "No ganó el mundial"})
        });
    }

    // categoria 2
    public static Categoria computadora() {
        return new Categoria("Informatica", new PalabraPista[]{
            new PalabraPista("monitor", new String[]{"Sirve para ver imagen", "Tiene pantalla", "Se conecta al CPU"}),
            new PalabraPista("teclado", new String[]{"Sirve para escribir", "Tiene teclas", "Puede ser USB o Bluetooth"}),
            new PalabraPista("raton", new String[]{"Se usa con la mano", "Controla el cursor", "Tiene clic izquierdo"})
        });
    }

    // categoria 3
    public static Categoria phobias() {
        return new Categoria("Fobias", new PalabraPista[]{
            new PalabraPista("escolionofobia", new String[]{"Miedo a la escuela", "Termina con -fobia", "Es común"}),
            new PalabraPista("codofobia", new String[]{"Miedo al codigo", "Puede causar estres", "Ocurre en el mundo laboral"}),
            new PalabraPista("Erotofobia", new String[]{"Miedo al amor", "Puede ocurrir en moteles", "Ocurre  en algunos hommbres y  mujeres"})
        });
    }

    // categoria 4
    public static Categoria videojuegos() {
        return new Categoria("Ciudades", new PalabraPista[]{
            new PalabraPista("Altamira", new String[]{"Laguna Champeyan", "Ciudad en Tamaulipas", "De aqui es cuco sanchez, "al poniente de ciudad valles" "}),
            new PalabraPista("Reynosa", new String[]{"Conexion directa con Texas", "Plaza principal Miguel Hidalgo", "Tiene temporadaPharr TX la iudad mas cercana"})
            new
        });
    }
}