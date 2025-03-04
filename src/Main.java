import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//24/02/25 EJERCICIO ALCANCIA
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int mon20=0,mon50=0,mon100=0,mon200=0,mon500=0;
        int opcionmenu;

        do {
            System.out.println("\n1. Agregar una moneda");
            System.out.println("2. Contar monedas por denominación");
            System.out.println("3. Calcular el total del dinero");
            System.out.println("4. Vaciar la alcancía");
            System.out.println("5. Salir");
            System.out.print("Digite la opción: ");
            opcionmenu=teclado.nextInt();

            switch(opcionmenu) {
                case 1-> {
                    int opcionmoneda;
                    do {
                        System.out.println("\nPuede agregar monedas de las siguientes denominaciones:");
                        System.out.println("1. 20$");
                        System.out.println("2. 50$");
                        System.out.println("3. 100$");
                        System.out.println("4. 200$");
                        System.out.println("5. 500$");
                        System.out.println("6. Volver al menú principal");
                        System.out.print("Digite la opción: ");
                        opcionmoneda=teclado.nextInt();

                        switch(opcionmoneda) {
                            case 1 -> mon20++;
                            case 2 -> mon50++;
                            case 3 -> mon100++;
                            case 4 -> mon200++;
                            case 5 -> mon500++;
                            case 6 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("No es una opción válida.");
                        }
                    }while(opcionmoneda != 6);
                }

                case 2 -> {
                    System.out.println("\nLas monedas que tienes por denominación son:");
                    System.out.println("Monedas de 20$: "+mon20);
                    System.out.println("Monedas de 50$: "+mon50);
                    System.out.println("Monedas de 100$: "+mon100);
                    System.out.println("Monedas de 200$: "+mon200);
                    System.out.println("Monedas de 500$: "+mon500);
                }

                case 3 -> {
                    int suma=mon20*20+mon50*50+mon100*100+mon200*200+mon500*500;
                    System.out.println("\nEl total del dinero es: "+suma+"$");
                }

                case 4 -> {
                    System.out.println("\nVaciando la alcancía...");
                    mon20=mon50=mon100=mon200=mon500=0;
                    System.out.println("La alcancía ha sido vaciada.");
                }

                case 5 -> System.out.println("\nSaliendo de la alcancia...");
                default -> System.out.println("\nOpción no válida. Inténtelo de nuevo.");
            }
        }while(opcionmenu !=5);
        teclado.close();
    }
}

//25/02/25 EJERCICIO DADOS
class Dados {
    public static void main(String[] args) {
        int lanzar=(int)(Math.random()*100)+1;
        int sumaDado1=0,sumaDado2=0;

        System.out.println("Número de lanzamientos: "+lanzar);
        for(int i=1;i<=lanzar;i++) {
            int dado1=(int)(Math.random()*6)+1;
            int dado2=(int)(Math.random()*6)+1;
            sumaDado1+=dado1;
            sumaDado2+=dado2;
            System.out.println("Lanzamiento "+i+"\nDado 1: "+dado1+"    Dado 2: "+dado2);
        }

        System.out.println("\nPuntaje total\nDado 1: "+sumaDado1+"\nDado 2: "+sumaDado2);

        if(sumaDado1>sumaDado2) {
            System.out.println("El Dado 1 gano");
        }else if(sumaDado2>sumaDado1) {
            System.out.println("El Dado 2 gano");
        }else {
            System.out.println("Empate");
        }
    }
}

//25/02/25 EJERCICIO PIEDRA PAPEL O TIJERA
class ppt {
    public static void main(String[] args) {
        int vjugador1=0,vjugador2=0;
        int ronda=1;

        System.out.println("Piedra, papel o tijera.");
        while(vjugador1<2 && vjugador2<2) {
            int lzjugador1=(int)(Math.random()*3)+1;
            int lzjugador2=(int)(Math.random()*3)+1;

            //numero a string
            String jugador1=(lzjugador1==1)?"piedra":(lzjugador1==2)?"papel":"tijera";
            String jugador2=(lzjugador2==1)?"piedra":(lzjugador2==2)?"papel":"tijera";

            System.out.println("\nRonda "+ronda);
            System.out.println("Jugador 1: "+jugador1+"\nJugador 2: "+jugador2);

            if(lzjugador1==lzjugador2) {
                System.out.println("Resultado: empate");
            }else if((lzjugador1==1 && lzjugador2==3) || (lzjugador1==2 && lzjugador2==1) || (lzjugador1==3 && lzjugador2==2)) {
                System.out.println("Resultado: gana jugador 1");
                vjugador1++;
            }else {
                System.out.println("Resultado: gana jugador 2");
                vjugador2++;
            }
            ronda++;
        }

        System.out.println("\nResultado final");
        System.out.println("Jugador 1: "+vjugador1+" victorias\nJugador 2: "+vjugador2+" victorias");

        if(vjugador1==2) {
            System.out.println("Jugador 1 es el ganador");
        }else {
            System.out.println("Jugador 2 es el ganador");
        }
    }
}

//25/02/25 EJERCICIO VOTACIONES
class votaciones {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int votoc1=0,votoc2=0,votoc3=0;
        int valorinternet=700000;
        int valorradio=200000;
        int valortv=600000;
        int votoc1int=0,votoc2int=0,votoc3int=0,votoc1rad=0,votoc2rad=0,votoc3rad=0,votoc1tv=0,votoc2tv=0,votoc3tv=0;
        int menupr;

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
            menupr=teclado.nextInt();

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

                        if(menuvoto !=4) {
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
                        }else{System.out.println("Volviendo al menú principal...");
                        }
                    } while (menuvoto != 4);
                }

                case 2 -> {
                    int sumac1=valorinternet*votoc1int+valorradio*votoc1rad+valortv*votoc1tv;
                    int sumac2=valorinternet*votoc2int+valorradio*votoc2rad+valortv*votoc2tv;
                    int sumac3=valorinternet*votoc3int+valorradio*votoc3rad+valortv*votoc3tv;

                    System.out.println("\nCosto de campaña por candidato dependiendo de la influencia por voto");
                    System.out.println("Candidato 1\nCosto internet: "+(valorinternet*votoc1int)+"$\nCosto radio: "+(valorradio*votoc1rad)+"$\nCosto televisión: "+(valortv*votoc1tv)+"$\nCosto de campaña total: "+sumac1+"$");
                    System.out.println("\nCandidato 2\nCosto internet: "+(valorinternet*votoc2int)+"$\nCosto radio: "+(valorradio*votoc2rad)+"$\nCosto televisión: "+(valortv*votoc2tv)+"$\nCosto de campaña total: "+sumac2+"$");
                    System.out.println("\nCandidato 3\nCosto internet: "+(valorinternet*votoc3int)+"$\nCosto radio: "+(valorradio*votoc3rad)+"$\nCosto televisión: "+(valortv*votoc3tv)+"$\nCosto de campaña total: "+sumac3+"$");
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
                    if (totalvotos==0) System.out.println("\nNo hay votos");
                    else if(totalvotos>=1){
                        System.out.println("\nPorcentaje de votos");
                        double porcentajec1= (double) votoc1/totalvotos*100;
                        double porcentajec2= (double) votoc2/totalvotos*100;
                        double porcentajec3= (double) votoc3/totalvotos*100;
                        System.out.println("Candidato 1: "+String.format("%.2f",porcentajec1)+"%");
                        System.out.println("Candidato 2: "+String.format("%.2f",porcentajec2)+"%");
                        System.out.println("Candidato 3: "+String.format("%.2f",porcentajec3)+"%");
                    }
                }
                case 6 -> {
                    int sumac1=valorinternet*votoc1int+valorradio*votoc1rad+valortv*votoc1tv;
                    int sumac2=valorinternet*votoc2int+valorradio*votoc2rad+valortv*votoc2tv;
                    int sumac3=valorinternet*votoc3int+valorradio*votoc3rad+valortv*votoc3tv;
                    int promedio=(sumac1+sumac2+sumac3)/3;

                    System.out.println("\nCalcular el costo de campaña por candidato");
                    System.out.println("Candidato 1: " + sumac1 +"$");
                    System.out.println("Candidato 2: " + sumac2 +"$");
                    System.out.println("Candidato 3: " + sumac3 +"$");
                    System.out.println("El costo promedio de las campaña es "+promedio+"$");
                }
                case 7 -> System.out.println("\nSaliendo...");
                default -> System.out.println("\nOpción no válida. Inténtelo de nuevo.");
            }
        } while (menupr != 7);
        teclado.close();
    }
}

//03/03/2025 EJERCICIO CUENTA BANCARIA
class CuentaBancaria {
    public static void main(String[] args) {
        Operaciones cuenta1 = new Operaciones("Johana", 4891968, 1);
        Operaciones cuenta2 = new Operaciones("Sebastian", 1578962, 2);
        Operaciones cuenta3 = new Operaciones();
        cuenta3.setTitular("Alejandra");
        cuenta3.setSaldo(7601621);
        cuenta3.setNumeroCuenta(3);

        List<Operaciones> lst=new ArrayList<>();
        lst.add(cuenta1);
        lst.add(cuenta2);
        lst.add(cuenta3);
        Scanner teclado = new Scanner(System.in);
        int menupr;

        do {
            System.out.println("\n--------Cuenta Bancaria--------");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar información de la cuenta");
            System.out.println("4. Salir.");
            System.out.println("\nLas cuentas disponibles son:");
            for(Operaciones milist:lst){
                System.out.println(milist);
            }

            System.out.print("Digite la opción: ");
            menupr = teclado.nextInt();

            switch (menupr) {
                case 1 -> {
                    System.out.println("\nDepositar dinero");
                    System.out.print("Ingrese el número de la cuenta: ");
                    int numCuenta = teclado.nextInt();

                    if (numCuenta==cuenta1.getNumeroCuenta()) {
                        cuenta1.recibirDinero();
                    } else if (numCuenta==cuenta2.getNumeroCuenta()) {
                        cuenta2.recibirDinero();
                    } else if (numCuenta==cuenta3.getNumeroCuenta()) {
                        cuenta3.recibirDinero();
                    } else {
                        System.out.println("Número de cuenta no valido.");
                    }
                }

                case 2 -> {
                    System.out.println("\nRetirar dinero");
                    System.out.print("Ingrese el número de la cuenta: ");
                    int numCuenta = teclado.nextInt();

                    if (numCuenta==cuenta1.getNumeroCuenta()) {
                        cuenta1.retirarDinero();
                    }else if (numCuenta==cuenta2.getNumeroCuenta()) {
                        cuenta2.retirarDinero();
                    }else if (numCuenta==cuenta3.getNumeroCuenta()) {
                        cuenta3.retirarDinero();
                    }else{
                        System.out.println("Número de cuenta no válido.");
                    }
                }

                case 3 -> {
                    System.out.println("\nMostrar información de la cuenta");
                    for(Operaciones milist:lst){
                        System.out.println(milist);
                    }
                }

                case 4 -> System.out.println("\nSaliendo de la cuenta");
                default -> System.out.println("\nSaliendo del banco");
            }
        } while (menupr != 4);
    }
}

//04/03/25 EJERCICIO RULETA RUSA
class RuletaRusa {
    public static void main(String[] args) {
        RuletaMetodos ruleta = new RuletaMetodos();
        int menupr;
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        do {
            System.out.println("Ruleta rusa");
            System.out.println("1. Disparar");
            System.out.println("2. Salir");
            System.out.print("Digite la opción: ");
            menupr = scanner.nextInt();

            switch (menupr) {
                case 1 -> {
                        if (ruleta.disparar()) {
                            System.out.println("\nPerdiste :(");
                        }else{
                            System.out.println("\nSobreviviste :)");
                        }

                }
                case 2 -> System.out.println("Saliendo del juego");
                default -> System.out.println("Opción no valida, intente de nuevo.");
            }
        }while(jugando && menupr!=2);
    }
}



