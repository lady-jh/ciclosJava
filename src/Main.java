import java.util.Scanner;
//votaciones
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int menupr;
        int votoc1=0, votoc2=0, votoc3=0;
        int valorinternet=700000;
        int valorradio=200000;
        int valortv=600000;
        int votoc1int=0,votoc2int=0,votoc3int=0,votoc1rad=0,votoc2rad=0,votoc3rad=0,votoc1tv=0,votoc2tv=0,votoc3tv=0;

        System.out.println("Elecciones para representante del municipio");

        do {
            System.out.println("\n1. Votar por el candidato de su elección.");
            System.out.println("2. Calcular el costo de campaña por candidato dependiendo de la influencia por voto.");
            System.out.println("3. Vaciar todas las urnas de la votación.");
            System.out.println("4. Conocer el número total de votos.");
            System.out.println("5. Porcentaje de votos obtenidos por cada candidato.");
            System.out.println("6. Costo promedio de campaña en las elecciones.");
            System.out.println("7. Salir.");

            System.out.print("Digite la opción: ");
            menupr = teclado.nextInt();

            switch (menupr) {
                case 1 -> {
                    int menuvoto;
                    int menupublicidad;
                    do {
                        System.out.println("\nPuede votar uno de los tres candidatos:");
                        System.out.println("1. Candidato 1");
                        System.out.println("2. Candidato 2");
                        System.out.println("3. Candidato 3");
                        System.out.println("4. Menú principal");
                        System.out.print("Digite la opción: ");
                        menuvoto = teclado.nextInt();

                        if(menuvoto !=4){
                            System.out.println("\nIndique la influencia de su voto");
                            System.out.println("1. Internet");
                            System.out.println("2. Radio");
                            System.out.println("3. Televisión");
                            System.out.print("Digite la opción: ");
                            menupublicidad = teclado.nextInt();

                            switch (menuvoto) {
                                case 1 -> {
                                    votoc1++;
                                    if (menupublicidad == 1) votoc1int++;
                                    else if (menupublicidad == 2) votoc1rad++;
                                    else if (menupublicidad == 3) votoc1tv++;
                                }
                                case 2 -> {
                                    votoc2++;
                                    if (menupublicidad == 1) votoc2int++;
                                    else if (menupublicidad == 2) votoc2rad++;
                                    else if (menupublicidad == 3) votoc2tv++;
                                }
                                case 3 -> {
                                    votoc3++;
                                    if (menupublicidad == 1) votoc3int++;
                                    else if (menupublicidad == 2) votoc3rad++;
                                    else if (menupublicidad == 3) votoc3tv++;
                                }

                                case 4 -> System.out.println("Volviendo al menú principal...");
                                default -> System.out.println("No es una opción válida.");
                            }
                        }
                    } while (menuvoto != 4);
                }

                case 2 -> {
                    int sumac1=valorinternet*votoc1int+valorradio*votoc1rad+valortv*votoc1tv;
                    int sumac2=valorinternet*votoc2int+valorradio*votoc2rad+valortv*votoc2tv;
                    int sumac3=valorinternet*votoc3int+valorradio*votoc3rad+valortv*votoc3tv;
                    System.out.println("\nCalcular el costo de campaña por candidato");
                    System.out.println("Candidato 1: " + sumac1 +"$");
                    System.out.println("Candidato 2: " + sumac2 +"$");
                    System.out.println("Candidato 3: " + sumac3 +"$");
                }

                case 3 -> {
                    System.out.println("Vaciando urnas...");
                    votoc1=votoc2=votoc3=0;
                    votoc1int=votoc2int=votoc3int=0;
                    votoc1rad=votoc2rad=votoc3rad=0;
                    votoc1tv=votoc2tv=votoc3tv=0;
                }

                case 4 -> System.out.println("\nEl total de votos es "+(votoc1+votoc2+votoc3));

                case 5 -> {
                    int totalvotos=(votoc1+votoc2+votoc3);

                    if (totalvotos<1)System.out.println("No hay votos");
                    else if(totalvotos>=1){
                        System.out.println("\nPorcentaje de votos");
                        double porcentajec1= (double) votoc1/totalvotos*100;
                        double porcentajec2= (double) votoc2/totalvotos*100;
                        double porcentajec3= (double) votoc3/totalvotos*100;
                        System.out.println("Candidato 1: " + String.format("%.2f", porcentajec1) + "%");
                        System.out.println("Candidato 2: " + String.format("%.2f", porcentajec2) + "%");
                        System.out.println("Candidato 3: " + String.format("%.2f", porcentajec3) + "%");
                    }
                }
                case 6 ->{
                    int sumac1=valorinternet*votoc1int+valorradio*votoc1rad+valortv*votoc1tv;
                    int sumac2=valorinternet*votoc2int+valorradio*votoc2rad+valortv*votoc2tv;
                    int sumac3=valorinternet*votoc3int+valorradio*votoc3rad+valortv*votoc3tv;
                    int total=(sumac1+sumac2+sumac3)/3;
                    System.out.println("\nEl costo promedio de la campaña es "+total+"$");
                }
                case 7 -> System.out.println("\nSaliendo...");
                default -> System.out.println("\nOpción no válida. Inténtelo de nuevo.");
            }
        } while (menupr != 7);
        teclado.close();
    }
}
//dadon random
class Dados {
    public static void main(String[] args) {
        int lanzar = (int) (Math.random() * 100) + 1;
        int sumaDado1 = 0, sumaDado2 = 0;

        System.out.println("Número de lanzamientos: " + lanzar);
        for (int i = 1; i <= lanzar; i++) {
            int dado1 = (int) (Math.random() * 6) + 1;
            int dado2 = (int) (Math.random() * 6) + 1;

            sumaDado1 += dado1;
            sumaDado2 += dado2;

            System.out.println("Lanzamiento " + i + "\nDado 1: " + dado1 + "   Dado 2: " + dado2);
        }

        System.out.println("\nPuntaje total: \nDado 1: " + sumaDado1 + "\nDado 2: " + sumaDado2);

        if (sumaDado1 > sumaDado2) {
            System.out.println("El Dado 1 gano");
        } else if (sumaDado2 > sumaDado1) {
            System.out.println("El Dado 2 gano");
        } else {
            System.out.println("Empate");
        }
    }
}
//piedra, papel o tijera
class ppt {
    public static void main(String[] args) {
        int vjugador1 = 0, vjugador2 = 0;
        System.out.println("Piedra, papel o tijera.");

        int ronda = 1;
        while (vjugador1 < 2 && vjugador2 < 2) {
            int lzjugador1 = (int) (Math.random() * 3) + 1;
            int lzjugador2 = (int) (Math.random() * 3) + 1;

            //numero a string
            String jugador1 = (lzjugador1 == 1) ? "piedra" : (lzjugador1 == 2) ? "papel" : "tijera";
            String jugador2 = (lzjugador2 == 1) ? "piedra" : (lzjugador2 == 2) ? "papel" : "tijera";

            System.out.println("\nRonda " + ronda);
            System.out.println("Jugador 1: " + jugador1 + "\nJugador 2: " + jugador2);

            if (lzjugador1 == lzjugador2) {
                System.out.println("Resultado: empate");
            } else if ((lzjugador1 == 1 && lzjugador2 == 3) || (lzjugador1 == 2 && lzjugador2 == 1) || (lzjugador1 == 3 && lzjugador2 == 2)) {
                System.out.println("Resultado: gana jugador 1");
                vjugador1++;
            } else {
                System.out.println("Resultado: gana jugador 2");
                vjugador2++;
            }
            ronda++;
        }

        System.out.println("\nResultado final");
        System.out.println("Jugador 1: " + vjugador1 + " victorias\nJugador 2: " + vjugador2 + " victorias");

        if (vjugador1 == 2) {
            System.out.println("Jugador 1 es el ganador");
        } else {
            System.out.println("Jugador 2 es el ganador");
        }
    }
}
