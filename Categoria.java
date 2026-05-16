import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Gestión de categorías y palabras del juego.
 * Almacena palabras con sus pistas organizadas por categorías.
 */
public class Categoria {

	// -- Variables usadas: lista de palabras con pistas
	private static final List<PalabraPista> palabras = new ArrayList<>();

	// -- Inicialización: cargar palabras en el bloque estático
	static {
		// Categoría 1: Animales
		palabras.add(new PalabraPista("ELEFANTE", "Mamífero grande con trompa"));
		palabras.add(new PalabraPista("TIGRE", "Felino rayado"));

		// Categoría 2: Frutas
		palabras.add(new PalabraPista("MANZANA", "Fruta roja o verde"));
		palabras.add(new PalabraPista("PLATANO", "Fruta amarilla larga"));

		// Categoría 3: Países
		palabras.add(new PalabraPista("MEXICO", "País con capital Ciudad de México"));
		palabras.add(new PalabraPista("BRASIL", "País sudamericano con carnaval famoso"));

		// Categoría 4: Cine
		palabras.add(new PalabraPista("INCEPTION", "Película sobre los sueños"));
		palabras.add(new PalabraPista("TITANIC", "Barco que chocó con un iceberg"));
	}

	// -- Variables usadas: generador de números aleatorios
	private static final Random R = new Random();

	// -- Métodos: obtener palabra aleatoria
	public static PalabraPista getRandomPalabra() {
		return palabras.get(R.nextInt(palabras.size()));
	}
}
