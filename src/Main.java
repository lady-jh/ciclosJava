import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int mon20 = 0, mon50 = 0, mon100 = 0, mon200 = 0, mon500 = 0;
        int opcionmenu;

        do {
            System.out.println("\n1. Agregar una moneda");
            System.out.println("2. Contar monedas por denominación");
            System.out.println("3. Calcular el total del dinero");
            System.out.println("4. Vaciar la alcancía");
            System.out.println("5. Salir");
            System.out.print("Digite la opción: ");
            opcionmenu = teclado.nextInt();

            switch (opcionmenu) {
                case 1 -> {
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
                        opcionmoneda = teclado.nextInt();

                        switch (opcionmoneda) {
                            case 1 -> mon20++;
                            case 2 -> mon50++;
                            case 3 -> mon100++;
                            case 4 -> mon200++;
                            case 5 -> mon500++;
                            case 6 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("No es una opción válida.");
                        }
                    } while (opcionmoneda != 6);
                }

                case 2 -> {
                    System.out.println("\nLas monedas que tienes por denominación son:");
                    System.out.println("Monedas de 20$: " + mon20);
                    System.out.println("Monedas de 50$: " + mon50);
                    System.out.println("Monedas de 100$: " + mon100);
                    System.out.println("Monedas de 200$: " + mon200);
                    System.out.println("Monedas de 500$: " + mon500);
                }

                case 3 -> {
                    int suma = mon20 * 20 + mon50 * 50 + mon100 * 100 + mon200 * 200 + mon500 * 500;
                    System.out.println("\nEl total del dinero es: " + suma + "$");
                }

                case 4 -> {
                    System.out.println("\nVaciando la alcancía...");
                    mon20 = mon50 = mon100 = mon200 = mon500 = 0;
                    System.out.println("La alcancía ha sido vaciada.");
                }

                case 5 -> System.out.println("\nSaliendo del programa...");
                default -> System.out.println("\nOpción no válida. Inténtelo de nuevo.");
            }
        } while (opcionmenu != 5);
        teclado.close();
    }
}
