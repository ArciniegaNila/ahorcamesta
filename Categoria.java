package com.mycompany.ahorcadogui;

import java.util.Random;

public class Categoria {

    String nombre;
    PalabraPista[] palabras;

    public Categoria(String nombre, PalabraPista[] palabras) {

        this.nombre = nombre;
        this.palabras = palabras;
    }

    public PalabraPista obtenerPalabra() {

        Random random = new Random();

        return palabras[random.nextInt(palabras.length)];
    }

    // =====================================
    // DEPORTES
    // =====================================

    public static Categoria deportes() {

        return new Categoria(
                "Deportes",
                new PalabraPista[]{

                    new PalabraPista(
                            "CLUB DEPORTIVO CHIVAS",
                            new String[]{
                                "Es un Club de Futbol",
                                "El equipo esta en la liga de Mexico",
                                "No es Campeón desde 2017",
                                "Es el equipo donde salió Chicharito",
                                "El nombre del equipo es relacionado a un Animal"
                            }
                    ),

                    new PalabraPista(
                            "LEONEL MESSI",
                            new String[]{
                                "Es un Futbolista",
                                "Ha Jugado en 3 equipos distintos de diferentes países",
                                "Es un jugador conocido",
                                "Es uno de los Maximos Goleadores de la Historia",
                                "Va Jugar su 6 Mundial"
                            }
                    ),

                    new PalabraPista(
                            "CRISTIANO RONALDO",
                            new String[]{
                                "Es un Futbolista",
                                "Ha jugado en 5 equipos distintos de diferentes países",
                                "Es conocido por no ganar un mundial",
                                "Ha Jugado en el Real Madrid tiene mas goles que partidos jugados",
                                "Tiene un Festejo Conocido Mundialmente"
                            }
                    ),

                    new PalabraPista(
                            "MICHAEL JORDAN",
                            new String[]{
                                "Es Un Jugador de Basquetbol",
                                "Esta Retirado",
                                "Tiene 6 Anillos y fue MVP en esas 6 Finales",
                                "Tuvo una media de 30 puntos por partido en toda su carrera",
                                "Es Conocido Por Tener Una Marca de Ropa Mundialmente Conocida"
                            }
                    ),

                    new PalabraPista(
                            "KYLIAN MBAPPE",
                            new String[]{
                                "Es un Futbolista",
                                "Ha Jugando en 3 Equipos",
                                "Es Frances y Actualemente Juega",
                                "Fue Campeón Del Mundial 2018 con 19 años",
                                "Tiene algo en común con Roberto"
                            }
                    )
                }
        );
    }

    // =====================================
    // COMPUTADORA
    // =====================================

    public static Categoria computadora() {

        return new Categoria(
                "Computadora",
                new PalabraPista[]{

                    new PalabraPista(
                            "MONITOR",
                            new String[]{
                                "Sirve para ver la imagen de la computadora",
                                "Tiene una pantalla",
                                "Se conecta al CPU",
                                "Puede ser LED o LCD",
                                "Se usa todos los días en oficinas"
                            }
                    ),

                    new PalabraPista(
                            "TECLADO",
                            new String[]{
                                "Sirve para escribir",
                                "Tiene letras y números",
                                "Se conecta por USB o Bluetooth",
                                "Es un periférico",
                                "Tiene teclas como Enter y Espacio"
                            }
                    ),

                    new PalabraPista(
                            "MOUSE",
                            new String[]{
                                "Se usa con la mano",
                                "Sirve para mover el cursor",
                                "Tiene clic izquierdo y derecho",
                                "Puede ser inalámbrico",
                                "Es un periférico muy usado"
                            }
                    ),

                    new PalabraPista(
                            "PROCESADOR",
                            new String[]{
                                "Es el cerebro de la computadora",
                                "Ejecuta instrucciones",
                                "Intel y AMD fabrican algunos",
                                "Va dentro del gabinete",
                                "Influye en la velocidad de la PC"
                            }
                    ),

                    new PalabraPista(
                            "TARJETA GRAFICA",
                            new String[]{
                                "Ayuda en videojuegos",
                                "Mejora los gráficos",
                                "NVIDIA fabrica muchas",
                                "Se instala dentro de la computadora",
                                "Es importante para edición y gaming"
                            }
                    )
                }
        );
    }

    // =====================================
    // PHOBIAS
    // =====================================

    public static Categoria phobias() {

        return new Categoria(
                "Phobias",
                new PalabraPista[]{

                    new PalabraPista(
                            "ARACNOFOBIA",
                            new String[]{
                                "Es un miedo",
                                "Tiene relación con arañas",
                                "Muchas personas la tienen",
                                "Puede causar nervios",
                                "Termina con fobia"
                            }
                    ),

                    new PalabraPista(
                            "ACROFOBIA",
                            new String[]{
                                "Es un miedo",
                                "Tiene relación con las alturas",
                                "Algunas personas sienten vértigo",
                                "Puede aparecer en edificios altos",
                                "Es una fobia muy conocida"
                            }
                    ),

                    new PalabraPista(
                            "CLAUSTROFOBIA",
                            new String[]{
                                "Es un miedo",
                                "Tiene relación con lugares pequeños",
                                "Algunas personas sienten ansiedad",
                                "Puede pasar en elevadores",
                                "Es una fobia psicológica"
                            }
                    )
                }
        );
    }

    // =====================================
    // VIDEOJUEGOS
    // =====================================

    public static Categoria videojuegos() {

        return new Categoria(
                "Videojuegos",
                new PalabraPista[]{

                    new PalabraPista(
                            "MINECRAFT",
                            new String[]{
                                "Es un videojuego",
                                "Tiene bloques",
                                "Puedes construir casas",
                                "Tiene creepers",
                                "Es uno de los juegos más vendidos"
                            }
                    ),

                    new PalabraPista(
                            "FORTNITE",
                            new String[]{
                                "Es un videojuego",
                                "Tiene modo Battle Royale",
                                "Es famoso por sus bailes",
                                "Tiene temporadas",
                                "Lo desarrolla Epic Games"
                            }
                    ),

                    new PalabraPista(
                            "ROBLOX",
                            new String[]{
                                "Es un videojuego",
                                "Tiene muchos minijuegos",
                                "Los jugadores crean mundos",
                                "Es muy popular entre jóvenes",
                                "Tiene una moneda llamada Robux"
                            }
                    )
                }
        );
    }
}
