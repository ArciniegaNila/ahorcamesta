package proyecto.mavenproject71;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author gelop
 */
public class ahorcamelo {

    public static void main(String[] args) {
  JOptionPane.showMessageDialog(null, "bienvenido al juago ahorcado, tiens 8 intentos para completar la palabra y si no pierdes, introduce una letra y que empieze el juego");//mensaje de vienvenida al usuario
        String[] palabras = {"precosidad","pollo","cafe","hitler","amigo","combate", "chicano"};//las posibles palabras que tedara el juego
        int posicionAleatoria = (int) (Math.random() * palabras.length);//selecciona una palabra aleatoria de las anteriores en un orden de6 palabras    
        String palabra= palabras[posicionAleatoria];//lee el indice o sea la palbra aleatoria de las anteriores.
         jugar(palabra);//Inicia el juego con la palabra random
    }
   private static void jugar(String palabra) {//llamamos al juego para poder empezar 
        int intentosRestantes = 8;//numeros de intentos permitidos
        char[] letras = palabra.toCharArray();//convertimos palabra en array caracteres de manera array
        char[] letrasOcultas = new char[letras.length];//con el mismo array mostramos las palabras con letras adivinas o guiones 

        // Inicializamos la palbara oculta con guiones '_'
        for (int i = 0; i < letras.length; i++) {
            letrasOcultas[i] = '_';
        }
       
        StringBuilder letrasUsadas = new StringBuilder();//aqui guardamos las letras qu ya fueron usadas por ineteto
        boolean palabraAdivinada = false;//aqui verificamos si gano
        String palabraSecreta = palabra; //aqui se revela la palabra que se ve hasta el final

        while (intentosRestantes > 0 && !palabraAdivinada) {//bucle para la palbra y los intentos ademas de ser el principal
            String mensaje = "Palabra: " + mostrarPalabraConEspacios(new String(letrasOcultas)) +//menasaje que muestra por intento y si esta bien o mal
                    "\nIntentos restantes: " + intentosRestantes +//mensaje y funcion de intentos
                    "\nLetras usadas: " + letrasUsadas.toString() +//lee las letras que pusiste si la repites y asi
                    "\n\nIngresa una letra:";//mensaje principal

            String entrada = JOptionPane.showInputDialog(null, mensaje);// soliciata al usuario que ingrese una letra en el panel

            // Validar si el usuario cancela o cierra el cuadro de entrada
            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Juego cancelado.");
                return;
            }

            // Validar que solo sea una letra
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingresa una sola letra no mss.");//mensaje de que no seguiste la indicacion 
                continue;//procede a continuar
            }

            char letra = Character.toLowerCase(entrada.charAt(0));//convierta la letra ongresada a minuscula para comparacion

            // Validar si ya se usó la letra
            if (letrasUsadas.toString().indexOf(letra) != -1) {
                JOptionPane.showMessageDialog(null, "Ya intentaste con esa letra. Intenta otra por favor we.");
                continue;
            }
           
            letrasUsadas.append(letra).append(" ");//agrega la letra a las 3 usadas previamente

            // Verificar si la letra está en la palabra
            boolean acerto = false;//con el boolen sabemos si se encontro la lterta o no
            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == letra) {
                    letrasOcultas[i] = letra;//revela la letra en la poscicion correcta
                    acerto = true;
                }
            }
             //si la letra no esta en la palabra ve disminuyendo los intenttos
            if (!acerto) {
                intentosRestantes--;
                JOptionPane.showMessageDialog(null, "Letra incorrecta we.");// mensaje para letras que no estan la palabra
            }

            // Verificamos los guiones para saber si completo toda la palabra
            if (new String(letrasOcultas).indexOf('_') == -1) {
                palabraAdivinada = true;// aqui cierra con la palabra adivinada en caso de que si este correcta
            }
        }

     //aqui mostramps mensaje si gano  o perdio segun el resulatdo
        if (palabraAdivinada) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! ers un cosa mamalona Adivinaste la palabra: " + palabraSecreta);
        } else {
            JOptionPane.showMessageDialog(null, "juego terminado no pudiste we ni modo. La palabra era: " + palabraSecreta);
        }
    }

   // esta funcion esta de axiliar para mostrar la palabra con espacios 
    public static String mostrarPalabraConEspacios(String palabra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            sb.append(palabra.charAt(i)).append(" ");
        }
        return sb.toString(); //se cierra el ciclo retiurn por lo tamto termina todo 
    }
}